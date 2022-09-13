package graph.bj11657;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static Edge edges[];
    public static long distance[];
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int citySize = Integer.parseInt(st.nextToken());
        int busSize = Integer.parseInt(st.nextToken());
        distance = new long[citySize + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        edges = new Edge[busSize + 1];

        for (int i = 0; i < busSize; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(start, end, value);
        }

        distance[1] = 0;
        for (int i = 0; i < citySize - 1; i++) {
            for (int j = 0; j < busSize; j++) {
                Edge now = edges[j];

                if(distance[now.start] != Integer.MAX_VALUE) {
                    if(distance[now.end] > distance[now.start] + now.value) {
                        distance[now.end] = distance[now.start] + now.value;
                    }
                }
            }
        }

        boolean isCycle = false;

        for (int i = 0; i < busSize; i++) {
            Edge now = edges[i];
            if(distance[now.start] != Integer.MAX_VALUE) {
                if(distance[now.end] > distance[now.start] + now.value) {
                    isCycle = true;
                }
            }
        }

        if(!isCycle) {
            for (int i = 2; i <= citySize; i++) {
                if(distance[i] == Integer.MAX_VALUE) {
                    result.append(-1);
                }else {
                    result.append(distance[i]);
                }
                result.append("\n");
            }
        } else {
            result.append(-1);
        }

        bw.write(result.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}

class Edge {
    int start;
    int end;
    int value;

    public Edge(int start, int end, int value) {
        this.start = start;
        this.end = end;
        this.value = value;
    }
}
