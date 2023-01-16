package org.example.backtracking.bj1799;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main2 {
    static int[][] board;
    static int size;
    static final int CAN_PLACE = 1;
    static final int BAN_PLACE = 0;
    static int maxCount = 0;
    static int count = 0;

    static List<Pair> whiteTarget = new ArrayList<>();
    static List<Pair> blackTarget = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        size = Integer.parseInt(st.nextToken());
        board = new int[size][size];
        boolean whiteFirst = true;
        for (int i = 0; i < size; i++) {
            board[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            if (whiteFirst) {
                checkBoardTarget(i, whiteTarget, blackTarget);
            } else {
                checkBoardTarget(i, blackTarget, whiteTarget);
            }
            whiteFirst = !whiteFirst;
        }

        for (int i = 0; i < whiteTarget.size(); i++) {
            dfs(i, whiteTarget);
            count = 0;
        }
        int whiteMax = maxCount;
        maxCount = 0;
        for (int i = 0; i < blackTarget.size(); i++) {
            dfs(i, blackTarget);

            count = 0;
        }
        int total = whiteMax + maxCount;
        result.append(total);


        bw.write(result.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    private static void dfs(int i, List<Pair> target) {
        Pair pair = target.get(i);
        System.out.println("pair.x = " + pair.x);
        System.out.println("pair.y = " + pair.y);
        boolean isPlace = false;
        if (board[pair.x][pair.y] == CAN_PLACE) {
            isPlace = true;
            count++;
            banPlace(pair);
        }
        for (int j = i + 1; j < target.size(); j++) {
            dfs(j, target);
        }
        maxCount = Math.max(maxCount, count);
        if (isPlace) {
            count--;
            rollbackPlace(pair);
        }
    }

    private static void banPlace(Pair pair) {
        //남동방향
        int xPivot = pair.x;
        int yPivot = pair.y;
        while (xPivot < size && yPivot < size) {
            if (board[xPivot][yPivot] == CAN_PLACE) {
                board[xPivot][yPivot] = pair.id;
            }
            xPivot++;
            yPivot++;
        }

        //남서방향
        xPivot = pair.x;
        yPivot = pair.y;
        while (xPivot < size && yPivot >= 0) {
            if (board[xPivot][yPivot] == CAN_PLACE) {
                board[xPivot][yPivot] = pair.id;
            }
            xPivot++;
            yPivot--;
        }
    }

    private static void rollbackPlace(Pair pair) {
//남동방향
        int xPivot = pair.x;
        int yPivot = pair.y;
        while (xPivot < size && yPivot < size) {
            if (board[xPivot][yPivot] == pair.id) {
                board[xPivot][yPivot] = CAN_PLACE;
            }
            xPivot++;
            yPivot++;
        }

        //남서방향
        xPivot = pair.x;
        yPivot = pair.y;
        while (xPivot < size && yPivot >= 0) {
            if (board[xPivot][yPivot] == pair.id) {
                board[xPivot][yPivot] = CAN_PLACE;
            }
            xPivot++;
            yPivot--;
        }
    }

    private static void checkBoardTarget(int row, List<Pair> targetA, List<Pair> targetB) {
        for (int j = 0; j < size; j += 2) {
            if (board[row][j] == CAN_PLACE) {
                targetA.add(new Pair(row, j, row * size + j + 100));
            }
        }
        for (int j = 1; j < size; j += 2) {
            if (board[row][j] == CAN_PLACE) {
                targetB.add(new Pair(row, j, row * size + j + 100));
            }
        }
    }
}

class Pair {
    int x;
    int y;
    int id;


    public Pair(int x, int y, int id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }
}
