package org.example.graph.union.bj16724;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        char[][] graph = new char[row][col];
        int[][] visit = new int[row][col];
        int answer = 0;
        int count = 0;
        for (int i = 0; i < row; i++) {
            graph[i] = br.readLine().toCharArray();
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (visit[i][j] == 0) {
                    count++;
                    int rowPivot = i;
                    int colPivot = j;
                    while (visit[rowPivot][colPivot] == 0) {
                        visit[rowPivot][colPivot] = count;
                        switch (graph[rowPivot][colPivot]) {
                            case 'D':
                                rowPivot++;
                                break;
                            case 'U':
                                rowPivot--;
                                break;
                            case 'L':
                                colPivot--;
                                break;
                            case 'R':
                                colPivot++;
                                break;
                        }
                    }
                    if(visit[rowPivot][colPivot] == count) {
                        answer++;
                    }
                }
            }
        }
        sb.append(answer);
        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
