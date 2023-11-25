package org.example.kakao2.c5;

public class Solution {
    public int solution(int n, int[] tops) {

        int[] dpHas = new int[n+1];
        int[] dpNoHas = new int[n+1];

        if(tops[0] == 0) {
            dpHas[1] = 1;
            dpNoHas[1] = 2;
        }else {
            dpHas[1] = 1;
            dpNoHas[1] = 3;
        }

        for(int i = 2; i <= n; i++) {
            if(tops[i-1] == 0) {
                dpHas[i] = dpHas[i-1] + dpNoHas[i-1];
                dpNoHas[i] = dpHas[i-1] + dpNoHas[i-1] * 2;
            }else {
                dpHas[i] = dpHas[i-1] + dpNoHas[i-1];
                dpNoHas[i] =  (dpHas[i-1] + dpNoHas[i-1]) * 2 + dpNoHas[i-1];
            }
            dpHas[i] %= 10007;
            dpNoHas[i] %= 10007;
        }

        int answer = (dpHas[n] + dpNoHas[n]) % 10007;
        return answer;
    }


}