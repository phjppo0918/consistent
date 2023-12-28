package org.example.cbustudy.week8.bj14500;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int graph[][];
    static boolean visit[][];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int h;
    static int w;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        graph = new int[h][w];
        visit = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                answer = Math.max(answer, back(i,j, 1));
            }
        }


        sb.append(answer);
        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    static int back(int x, int y, int dep) {
        if (dep == 4) {
            return graph[x][y];
        }

        int answer = graph[x][y];


        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < h && ny < w && !visit[nx][ny]) {
                if(dep == 2) {
                    visit[nx][ny] = true;
                    answer = Math.max(answer,  graph[nx][ny]+ back(x,y, dep + 1));
                    visit[nx][ny] = false;
                }
                visit[x][y] = true;
                answer = Math.max(answer, graph[x][y] + back(nx, ny,dep +1));
                visit[x][y] = false;
            }

        }
        return answer;
    }
}
