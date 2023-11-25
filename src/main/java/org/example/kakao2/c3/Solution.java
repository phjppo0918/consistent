package org.example.kakao2.c3;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    int [][] d;
    public int[] solution(int[][] dice) {
        d = dice;
        // 주사위를 먼저 골라
        pickNum(new ArrayList<>(), -1);
        // 다 골랐으면 굴리는 경우를 세

        return null;
    }

    public void pickNum(List<Integer> number, int lp) {

        if(number.size() == d.length/2) {
            roll(new ArrayList<>(), number);
        }

        for (int i = lp+1; i < d.length; i++) {
            if(!number.contains(i)) {
                List<Integer> temp = new ArrayList<Integer>(number);
                temp.add(i);
                pickNum(temp, i);
            }
        }
    }

    public void roll(List<Integer> number, List<Integer> pick) {
        if (number.size() == d.length) {

        }

        for (int i = 0; i < 6; i++) {
            List<Integer> temp = new ArrayList<>(number);
            temp.add(i);
            roll(temp, pick);
        }

    }

}

