package org.example.dp.bj1932;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int[][] graph = new int[size][];
        for (int i = 0; i < size; i++) {
            graph[i] = parseArr(br.readLine());
        }
        for (int i = size - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                graph[i-1][j] += Math.max(graph[i][j], graph[i][j+1]);
            }
        }
        result.append(graph[0][0]);

        bw.write(result.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    private static int[] parseArr(String element) {
        return Arrays.stream(element.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}

/*
풀이 과정:
1. 삼각형 배열 만들기
2. 아래층 부터 올라가볼까용
3. 양 노드 중 큰 값 선택 후 본인에게 더함
4. 맨 위층까지 반복
 */
