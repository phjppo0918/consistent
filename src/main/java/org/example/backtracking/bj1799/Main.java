package org.example.backtracking.bj1799;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int boardSize;
    static int[][] board;
    static boolean[][] isVisited;
    static boolean[][] isBlacked;
    static int[] result;

    static int[] dx = {-1, -1};
    static int[] dy = {1, -1};

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        boardSize = Integer.parseInt(st.nextToken());
        board = new int[boardSize][boardSize];
        isVisited = new boolean[boardSize][boardSize];
        isBlacked = new boolean[boardSize][boardSize];

        result = new int[2];
        boolean boardBlackStart = true;
        boolean isBlack = true;
        for (int i = 0; i < boardSize; i++) {
            st = new StringTokenizer(br.readLine());
            isBlack = boardBlackStart;
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());

                //검정색 칸 생성처리
                isBlacked[i][j] = isBlack;
                isBlack = !isBlack;
            }
            boardBlackStart = !boardBlackStart;
        }

        //검정칸 탐색
        search(-1, true, 0);
        //흰칸 탐색
        search(-1, false, 0);

        sb.append(result[0] + result[1]);

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    private static void search(int index, boolean isSearchBlack, int count) {
        for (int i = index + 1; i < boardSize * boardSize; i++) {
            int x = i / boardSize;
            int y = i % boardSize;

            // 현재 탐색중인 색이 아니거나, 비숍을 놓을 수 없거나, 대각선에 비숍이 존재하거나
            if (isBlacked[x][y] != isSearchBlack || board[x][y] == 0 || !isValid(x, y)) {
                continue;
            }

            isVisited[x][y] = true;
            search(i, isSearchBlack, count + 1);
            isVisited[x][y] = false;
        }

        int resultIndex = isSearchBlack ? 0 : 1;
        result[resultIndex] = Math.max(result[resultIndex], count);
    }

    private static boolean isValid(int x, int y) {
        // 좌측 하단부터 우측 하단순으로 탐색하므로 윗 대각선의 비숍만 체크한다.
        for (int i = 0; i < 2; i++) {
            int xx = x;
            int yy = y;

            while (xx < boardSize && yy < boardSize && xx >= 0 && yy >= 0) {
                if (isVisited[xx][yy]) {
                    return false;
                }

                xx += dx[i];
                yy += dy[i];
            }
        }

        return true;
    }
}