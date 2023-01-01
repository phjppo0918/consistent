package org.example.dp.bj11057;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        long answer = getCount(size)%10007;
        result.append(answer);

        bw.write(result.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    public static long getCount(int size) {
        long[][] arr = new long[10][size+1];
        for (int i = 0; i < size; i++) {
            arr[9][i] = 1;
        }
        for (int i = 0; i < 10; i++) {
            arr[i][size] = 1;
        }
        for (int i = size - 1; i >= 0; i--) {
            for (int j = 8; j >= 0; j--) {
                arr[j][i] = (arr[j][i+1] + arr[j+1][i])%10007;
            }
        }
        return arr[0][0];
    }
}
/*
풀이 :
1. 크기 N인 이차원 배열 만들어

2. 1~N인 K를
arr[N][1] ~ arr[N][k]
arr[1][N] ~ arr[K][N] 을 전부 1로 채워
arr[N-1][N-1]은 arr[N-1][N] + arr[N][N-1]
arr[0][0]이 답
 */
