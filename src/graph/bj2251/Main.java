package graph.bj2251;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int[] send = {1,1,2,2,3,3};
    public static int[] recive = {2,3,1,3,1,2};
    public static boolean visited[][] = new boolean[201][201];
    public static boolean answer[] = new boolean[201];
    public static int bottle[] = new int[4];

    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i < 4; i++) {
            bottle[i] = Integer.parseInt(st.nextToken());
        }


        bfs();

        for (int i = 0; i <= 200; i++) {
            if(answer[i]) {
                result.append(i);
                result.append(" ");
            }

        }

        result.append("\n");

        bw.write(result.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    public static void bfs() {
        Queue<BottleSet> queue = new LinkedList<>();
        queue.add(new BottleSet(0, 0));
        visited[0][0] = true;
        answer[bottle[3]] = true;

        while (!queue.isEmpty()) {
            BottleSet bs = queue.poll();
            int aTemp = bs.bottleA;
            int bTemp = bs.bottleB;
            int c = bottle[3] - aTemp - bTemp;
            for (int i = 0; i < 6; i++) {
                int[] next = {0, aTemp, bTemp, c};
                next[recive[i]] += next[send[i]];
                next[send[i]] = 0;

                if(next[recive[i]] > bottle[recive[i]]) {
                    next[send[i]] = next[recive[i]] - bottle[recive[i]];
                    next[recive[i]] = bottle[recive[i]];
                }

                if(!visited[next[1]][next[2]]) {
                    visited[next[1]][next[2]] = true;
                    queue.add(new BottleSet(next[1], next[2]));

                    if(next[1] == 0) {
                        answer[next[3]] = true;
                    }
                }
            }
        }
    }
}

class BottleSet {
    int bottleA;
    int bottleB;

    public BottleSet(int bottleA, int bottleB) {
        this.bottleA = bottleA;
        this.bottleB = bottleB;
    }
}
