package org.example.impl.bj21608;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static Set<Integer>[] friends;
    static int[][] seat;
    static int[] rowPivot = {1, -1, 0, 0};
    static int[] colPivot = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int studentCount = n * n;
        int[] seatOrder = new int[studentCount];
        friends = new Set[studentCount + 1];

        for (int i = 0; i < studentCount; i++) {
            st = new StringTokenizer(br.readLine());
            int nextStudent = Integer.parseInt(st.nextToken());
            seatOrder[i] = nextStudent;
            friends[nextStudent] = new HashSet<>();
            for (int j = 0; j < 4; j++) {
                friends[nextStudent].add(Integer.parseInt(st.nextToken()));
            }
        }

        seat = new int[n][n];
        int[][] blankCount = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 4; k++) {
                    if (inRange(i + rowPivot[k], j + colPivot[k])) {
                        blankCount[i + rowPivot[k]][j + colPivot[k]]++;
                    }
                }
            }
        }

        for (int s = 0; s < studentCount; s++) {
            int nextRow = -1;
            int nextCol = -1;
            int maxFriendCount = -1;
            int maxBlankCount = -1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(seat[i][j] > 0) {
                        continue;
                    }
                    int friendCount = countNearFriend(seatOrder[s], i, j);
                    if (friendCount > maxFriendCount) {
                        nextRow = i;
                        nextCol = j;
                        maxFriendCount = friendCount;
                        maxBlankCount = blankCount[i][j];
                    } else if(friendCount == maxFriendCount && blankCount[i][j] > maxBlankCount){
                        maxBlankCount = blankCount[i][j];
                        nextRow = i;
                        nextCol = j;
                    } else if(maxFriendCount <=0 && blankCount[i][j] > maxBlankCount) {
                        maxBlankCount = blankCount[i][j];
                        nextRow = i;
                        nextCol = j;
                    }
                }
            }
            seat[nextRow][nextCol] = seatOrder[s];
            for (int k = 0; k < 4; k++) {
                if (inRange(nextRow + rowPivot[k], nextCol + colPivot[k])) {
                    blankCount[nextRow + rowPivot[k]][nextCol + colPivot[k]]--;
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int point = countNearFriend(seat[i][j], i, j);

                if(point == 2) {
                    point = 10;
                }else if(point == 3) {
                    point = 100;
                }else if(point == 4) {
                    point = 1000;
                }
                answer += point;
            }
        }
        sb.append(answer);

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    static int countNearFriend(int student, int row, int col) {
        int count = 0;
        for (int k = 0; k < 4; k++) {
            if (inRange(row + rowPivot[k], col + colPivot[k])) {
                if (friends[student].contains(seat[row + rowPivot[k]][col + colPivot[k]])) {
                    count++;
                }
            }
        }

        return count;
    }

    static boolean inRange(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < n;
    }
}
