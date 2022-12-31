package graph.bj1976;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int graph[];
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        int citySize = Integer.parseInt(st.nextToken());
        int caseSize = Integer.parseInt(br.readLine());
        graph = new int[citySize + 1];
        for (int i = 1; i <=citySize ; i++) {
            graph[i] = i;
        }
        for (int i = 1; i <= citySize ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= citySize; j++) {
                int city = Integer.parseInt(st.nextToken());
                if (city == 1) {
                    setParent(i , j);
                }
            }
        }

        Integer[] trip = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt).toArray(Integer[]::new);

        String answer = "YES";
        for (Integer i : trip) {
            if(!confirm(trip[0], i)) {
                answer = "NO";
                break;
            }
        }
        result.append(answer);

        bw.write(result.toString());
    
        bw.flush();
        br.close();
        bw.close();
    }

    public static void setParent(int node1, int node2) {
        if (node1 != node2) {
            graph[getParent(node2)] = getParent(node1);
        }
    }

    public static boolean confirm(int node1, int node2) {
        return getParent(node1) == getParent(node2);
    }

    public static int getParent(int node) {
        if(graph[node] == node) {
            return node;
        }

        return graph[node] = getParent(graph[node]);
    }
}
