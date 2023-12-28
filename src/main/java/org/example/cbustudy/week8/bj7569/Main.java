package org.example.cbustudy.week8.bj7569;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int garo = Integer.parseInt(st.nextToken());
        int sero = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        int[][][] graph = new int[garo][sero][height];

        Queue<Node> queue = new LinkedList<>();
        for (int h = 0; h < height; h++) {
            for (int s = 0; s < sero; s++) {
                st = new StringTokenizer(br.readLine());
                for (int g = 0; g < garo; g++) {
                    graph[g][s][h] = Integer.parseInt(st.nextToken());
                    if (graph[g][s][h] == 1) {
                        queue.add(new Node(g, s, h));
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            final Node now = queue.poll();

            for (int i = 0; i < 6; i++) {
                int ng = now.g + dx[i];
                int ns = now.s + dy[i];
                int nh = now.h + dz[i];

                if(ng >=0 && ns >= 0 && nh >=0 && ng < garo && ns < sero && nh < height) {
                    if(graph[ng][ns][nh] == 0) {
                        graph[ng][ns][nh] = graph[now.g][now.s][now.h] + 1;
                        queue.add(new Node(ng, ns, nh));
                    }
                }
            }
        }
        boolean isAll = true;
        int max = Integer.MIN_VALUE;

        for (int h = 0; h < height; h++) {
            for (int s = 0; s < sero; s++) {
                for (int g = 0; g < garo; g++) {
                    if (graph[g][s][h] == 0) {
                      isAll = false;
                      break;
                    }
                    max = Math.max(max, graph[g][s][h]);
                }
            }
        }
        if(isAll) {
            sb.append(max - 1);
        }else {
            sb.append(-1);
        }


        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}

class Node {
    int g;
    int s;
    int h;

    public Node(int g, int s, int h) {
        this.g = g;
        this.s = s;
        this.h = h;
    }
}