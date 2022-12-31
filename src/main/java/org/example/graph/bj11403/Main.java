package graph.bj11403;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeSize = Integer.parseInt(st.nextToken());

        int graph[][] = new int[nodeSize][nodeSize];

        for (int i = 0; i < nodeSize; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < nodeSize; j++) {
                int node = Integer.parseInt(st.nextToken());
                graph[i][j] = node;
            }
        }

        for (int k = 0; k < nodeSize; k++) {
            for (int i = 0; i <nodeSize; i++) {
                for (int j = 0; j < nodeSize; j++) {
                    if(graph[i][k] + graph[k][j] > 1) {
                        graph[i][j] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < nodeSize; i++) {
            for (int j = 0; j < nodeSize; j++) {
                result.append(graph[i][j]);
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
