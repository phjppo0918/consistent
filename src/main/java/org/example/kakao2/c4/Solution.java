package org.example.kakao2.c4;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(4, new int[] {3, 6, 7, 2, 1, 10, 5, 9, 8, 12, 11, 4}));
    }
    public int solution(int coin, int[] cards) {
        final int target = cards.length + 1;

        Set<Integer> has = new HashSet<>();
        Set<Integer> miss = new HashSet<>();
        Queue<Integer> remain = new LinkedList<>();
        int life = 0;

        for (int i = 0; i < cards.length / 3; i++) {

            if (has.contains(target - cards[i])) {
                life++;
                has.remove(target - cards[i]);
            }else {
                has.add(cards[i]);
            }
        }
        for (int i = cards.length / 3; i < cards.length; i++) {
            remain.add(cards[i]);
        }
        int remainLife = 0;

        int round = 1;

        while (!remain.isEmpty()) {
            int c1 = remain.poll();
            int c2 = remain.poll();
            if (coin > 0 && has.contains(target - c1)) {
                life++;
                has.remove(target - c1);
                coin--;
            } else {
                if (miss.contains(target - c1)) {
                    miss.remove(target - c1);
                    remainLife++;
                } else {
                    miss.add(c1);
                }
            }
            if (coin > 0 && has.contains(target - c2)) {
                life++;
                has.remove(target - c2);
                coin--;
            } else {
                if (miss.contains(target - c2)) {
                    miss.remove(target - c2);
                    remainLife++;
                } else {
                    miss.add(c2);
                }
            }

            if (life < 1) {
                if (coin >= 2 && remainLife > 0) {
                    coin -= 2;
                    remainLife--;
                }else {
                    break;
                }
            } else {
                life--;
            }

            round++;
        }


        return round;
    }
}
