package org.example.cbustudy.week4.bj1976;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] union;
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int citySize = Integer.parseInt(st.nextToken());
        final int q_ = Integer.parseInt(br.readLine());
        bw.write(sb.toString());

        union = new int[citySize + 1];
        for (int i = 0; i <= citySize; i++) {
            union[i] = i;
        }

        int[][] graph = new int[citySize + 1][citySize + 1];

        for (int i = 1; i <= citySize; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= citySize; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <citySize; i++) {
            for (int j = i+1; j <=citySize ; j++) {
                if(graph[i][j] == 1) {
                    union[getUnion(j)] = getUnion(i);
                }
            }
        }

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int target = getUnion(arr[0]);
        boolean isCan = true;
        for (int i = 0; i < arr.length; i++) {
            if(getUnion(arr[i]) != target) {
                isCan = false;
                break;
            }
        }

        if(isCan) {
            sb.append("YES");
        }else {
            sb.append("NO");
        }

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    static int getUnion(int num) {
        if(num == union[num]) return num;

        union[num] = getUnion(union[num]);
        return union[num];
    }
}
