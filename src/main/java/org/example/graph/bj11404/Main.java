package graph.bj11404;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        int citySize = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int busSize = Integer.parseInt(st.nextToken());
        long graph[][] = new long[citySize + 1][citySize + 1];

        final int MAX_VALUE = 10000001;
        for (int i = 1; i <= citySize; i++) {
            Arrays.fill(graph[i], MAX_VALUE);
            graph[i][i] = 0;
        }

        for (int i = 0; i < busSize; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            if (graph[start][end] > value) {
                graph[start][end] = value;
            }
        }

        for (int k = 1; k <= citySize; k++) {
            for (int i = 1; i <=citySize ; i++) {
                for (int j = 1; j <= citySize ; j++) {
                    if(graph[i][j] > graph[i][k] + graph[k][j]) {
                        graph[i][j] =  graph[i][k] + graph[k][j];
                    }
                }
            }
        }

        for (int i = 1; i <= citySize; i++) {
            for (int j = 1; j <= citySize; j++) {
                if(graph[i][j] == MAX_VALUE) {
                    result.append(0);
                }else {
                    result.append(graph[i][j]);
                }
                result.append(" ");
            }
            result.append("\n");
        }
        
        bw.write(result.toString());
    
        bw.flush();
        br.close();
        bw.close();
    }
}
