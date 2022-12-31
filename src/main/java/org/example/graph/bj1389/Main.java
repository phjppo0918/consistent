package graph.bj1389;

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
    
        int nodeSize = Integer.parseInt(st.nextToken());
        int edgeSize = Integer.parseInt(st.nextToken());

        int graph[][] = new int[nodeSize + 1][nodeSize + 1];
        for (int i = 1; i <=nodeSize; i++) {
            Arrays.fill(graph[i], 1000000);
            graph[i][i] = 0;
        }
        for (int i = 1; i <=edgeSize; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            graph[num1][num2] = 1;
            graph[num2][num1] = 1;
        }
        for (int k = 1; k <=nodeSize; k++) {
            for (int i = 1; i <=nodeSize; i++) {
                for (int j = 1; j <= nodeSize; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int answer = 0;

        for (int i = nodeSize; i >= 1; i--) {
            int sum = Arrays.stream(graph[i]).sum();
            if(sum <= min) {
                answer = i;
                min = sum;
            }
        }

        result.append(answer);
        result.append("\n");
        
        bw.write(result.toString());
    
        bw.flush();
        br.close();
        bw.close();
    }
}
