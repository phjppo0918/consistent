package org.example.bm.chap2;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        final int solve = main.solve(new int[]{1, 2, 3, 4, 5, 6, 7}, 1);
        System.out.println(solve);
    }

    public int solve(int[] time, int n) {
        Queue<Member> queue = new LinkedList<>();
        for (final int i : time) {
            queue.add(new Member(i));
        }
        Member[] play = new Member[n];
        int timer = 0;
        int out = 0;
        while (out < time.length) {
            int piv = timer%n;

            if(play[piv] == null) {
                if(queue.isEmpty()) {
                    timer++;
                    continue;
                }
                Member m = queue.poll();
                m.fin = timer + m.time;
                play[piv] = m;
            }else {
                if(play[piv].fin <= timer) {
                    play[piv] = null;
                    out++;
                    if(queue.isEmpty()) {
                        timer++;
                        continue;
                    }
                    Member m = queue.poll();
                    m.fin = timer + m.time;
                    play[piv] = m;
                }
            }
            timer++;
        }

        return timer - 1;
    }
}

class Member {
    int time;

    int fin = 0;

    public Member(final int time) {
        this.time = time;
    }
}
