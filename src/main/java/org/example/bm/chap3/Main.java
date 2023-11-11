package org.example.bm.chap3;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        final int solve = main.solve(new int[]{0,0,0,0,0,0,1,0,0,0,0,1,0,1,1}, 10);
        System.out.println(solve);
    }

    int solve(int[] wt, int c) {
        int max = c;
        int piv = 0;
        boolean beforeWork = false;
        while (piv < wt.length) {
            //흐림
            if(wt[piv] == 1) {
                if(c == 0) {
                    piv--;
                    break;
                }
                beforeWork = false;
                c--;
            }else {
                //맑을 때
                if(beforeWork) {
                    c++;
                } else if(c <= 1) {
                    beforeWork = true;
                    c = 1;
                } else {
                    beforeWork = false;
                    c--;
                }
            }
            c = Math.min(c, max);
            piv++;
        }
        return Math.min(piv, wt.length);
    }
}
