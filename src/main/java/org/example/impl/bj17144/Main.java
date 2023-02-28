package org.example.impl.bj17144;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] graph;
    static int row;
    static int col;
    static int[] rowPivot = {-1, 1, 0, 0};
    static int[] colPivot = {0, 0, -1, 1};
    final static int BLANK = 0;
    final static int FILTER = -1;
    static int filterHeader = -1;
    static int filterFooter = -1;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(st.nextToken());
        graph = new int[row][col];
        for (int i = 0; i < row; i++) {
            graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < col; j++) {
                if (graph[i][j] == FILTER && filterHeader == -1) {
                    filterHeader = i;
                    filterFooter = i + 1;
                }
            }
        }

        for (int t = 0; t < time; t++) {
            fuckingChina();
            cleanTop();
            cleanBottom();
        }
        int answer = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(graph[i][j] == FILTER) {
                    continue;
                }
                answer += graph[i][j];
            }
        }
        sb.append(answer);

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    private static void fuckingChina() {
        int[][] newBoard = new int[row][col];
        newBoard[filterHeader][0] = -1;
        newBoard[filterFooter][0] = -1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (graph[i][j] > 0) {
                    int value = graph[i][j] / 5;
                    int divideCnt = 0;
                    for (int k = 0; k < 4; k++) {
                        int nextRow = i + rowPivot[k];
                        int nextCol = j + colPivot[k];
                        if (canPlace(nextRow, nextCol)) {
                            divideCnt++;
                            newBoard[nextRow][nextCol] += value;
                        }
                    }
                    newBoard[i][j] += (graph[i][j] - divideCnt * value);
                }
            }
        }

        graph = newBoard;
    }

    private static void cleanTop() {
        //좌상 -> 좌하
        for (int i = filterHeader - 2; i >= 0; i--) {
            graph[i + 1][0] = graph[i][0];
        }

        //상우 -> 상좌
        for (int i = 1; i < col; i++) {
            graph[0][i - 1] = graph[0][i];
        }

        //우하 -> 우상
        for (int i = 0; i < filterHeader; i++) {
            graph[i][col - 1] = graph[i + 1][col - 1];
        }

        //좌하 -> 우하
        for (int i = col - 1; i >= 2; i--) {
            graph[filterHeader][i] = graph[filterHeader][i - 1];
        }
        graph[filterHeader][1] = 0;
    }

    private static void cleanBottom() {
        //좌하 -> 좌상
        for (int i = filterFooter + 1; i < row - 1; i++) {
            graph[i][0] = graph[i + 1][0];
        }
        //우하 -> 우좌
        for (int i = 0; i < col - 1; i++) {
            graph[row - 1][i] = graph[row - 1][i + 1];
        }
        // 우상 -> 우하
        for (int i = row - 1; i > filterFooter; i--) {
            graph[i][col - 1] = graph[i - 1][col - 1];
        }
        // 좌상 -> 우상
        for (int i = col - 1; i > 1; i--) {
            graph[filterFooter][i] = graph[filterFooter][i - 1];
        }
        graph[filterFooter][1] = 0;
    }

    private static boolean canPlace(int trow, int tcol) {
        if (trow < 0 || tcol < 0 || tcol >= col || trow >= row) return false;

        return graph[trow][tcol] != FILTER;
    }
}


// 개별 확산
// 공기 청정기 위치 찾기
// 확산 이후 상태
// 반시계 순환
// 시계 순환