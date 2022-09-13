package graph.bj1219;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int citySize = Integer.parseInt(st.nextToken());
        int startCity = Integer.parseInt(st.nextToken());
        int endCity = Integer.parseInt(st.nextToken());
        int edgeSize = Integer.parseInt(st.nextToken());

        Edge graph[] = new Edge[edgeSize];

        for (int i = 0; i < edgeSize; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            graph[i] = new Edge(start, end, value);
        }
        int price[] = new int[citySize ];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < citySize; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        long totalSum[] = new long[citySize];
        Arrays.fill(totalSum, Long.MIN_VALUE);

        totalSum[startCity] = price[startCity];
        for (int i = 0; i <= citySize + 100; i++) {
            for (int j = 0; j < edgeSize; j++) {
                Edge now = graph[j];
                if (totalSum[now.start] == Long.MIN_VALUE) {
                    continue;
                } else if(totalSum[now.start] == Long.MAX_VALUE) {
                    totalSum[now.end] = Long.MAX_VALUE;
                } else if (totalSum[now.end] < totalSum[now.start] + price[now.end] - now.value) {

                    totalSum[now.end] = totalSum[now.start] + price[now.end] - now.value;
                    if (i >= citySize - 1) {
                        totalSum[now.end] = Long.MAX_VALUE;
                    }

                }
            }
        }

        if (totalSum[endCity] == Long.MIN_VALUE) {
            result.append("gg");
        } else if(totalSum[endCity] == Long.MAX_VALUE) {
            result.append("Gee");
        }else {
            result.append(totalSum[endCity]);
        }

        result.append("\n");

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