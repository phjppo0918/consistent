package org.example.dp.bj2156;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int[] dp = new int[size + 1];
        int[] arr = new int[size + 1];
        for (int i = 1; i <= size; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        if (size == 1) {
            result.append(arr[1]);
        } else if (size == 2) {
            result.append(arr[2] + arr[1]);
        } else {
            dp[1] = arr[1];
            dp[2] = arr[2] + arr[1];
            for (int i = 3; i <= size; i++) {
                dp[i] = Math.max(
                        arr[i] + Math.max(dp[i - 2], arr[i - 1] + dp[i - 3]),
                        dp[i - 1]);
            }

            result.append(dp[size]);
        }

        bw.write(result.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
/*
풀이 과정
테스트 경우가 2개일 때까지는 직접 구함
N번째 와인을 먹을 때 경우 비교
A : 본인과 N-1 먹구 N-3의 DP값
B : 본인과 N-2의 DP값
C : N - 1의 DP값 (본인꺼를 안먹음)
A,B,C중 최대값

맨 마지막 것을 먹는 DP와 안 먹는 DP를 비교
 */
