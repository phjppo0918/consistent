package org.example.backtracking.bj1987;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] visited;
    static char [][] graph;
    static boolean[] visitChar = new boolean[26];
    static int answer = 0;
    static int maxRow;
    static int maxCol;
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        maxRow = Integer.parseInt(st.nextToken());
        maxCol = Integer.parseInt(st.nextToken());
        graph = new char[maxRow][];
        visited = new boolean[maxRow][maxCol];
        for (int i = 0; i < maxRow; i++) {
            graph[i] = br.readLine().toCharArray();
        }
        dfs(0,0,0);
        sb.append(answer);

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    public static void dfs(int row, int col, int count) {
        visited[row][col] = true;
        visitChar[graph[row][col] - 'A'] = true;
        count++;
        answer = Math.max(count, answer);

        //상
        if(row - 1 >= 0 && !visited[row-1][col] && !visitChar[graph[row-1][col] - 'A']) {
            dfs(row - 1, col, count);
        }
        //하
        if(row + 1 < maxRow && !visited[row+1][col] && !visitChar[graph[row+1][col] - 'A']) {
            dfs(row + 1, col, count);
        }
        //좌
        if(col - 1 >= 0 && !visited[row][col-1] && !visitChar[graph[row][col-1] - 'A']) {
            dfs(row, col-1, count);
        }
        //우
        if(col + 1 < maxCol && !visited[row][col+1] && !visitChar[graph[row][col+1] - 'A']) {
            dfs(row, col + 1, count);
        }


        visited[row][col] = false;
        visitChar[graph[row][col] - 'A'] = false;
    }
}
