package graph.bj1707;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static List<Integer>[] graph;
    public static boolean[] visited;
    public static boolean answer = true;
    public static int[] group;
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int caseSize = Integer.parseInt(st.nextToken());
        for (int i = 0; i < caseSize; i++) {
            st = new StringTokenizer(br.readLine());
            int nodeSize = Integer.parseInt(st.nextToken());
            int edgeSize = Integer.parseInt(st.nextToken());
            graph = new List[nodeSize + 1];
            answer = true;
            visited = new boolean[nodeSize+1];
            group = new int[nodeSize + 1];
            for (int j = 1; j <= nodeSize; j++) {
                graph[j] = new ArrayList<>();
            }

            for (int j = 0; j < edgeSize; j++) {
                st = new StringTokenizer(br.readLine());
                int node1 = Integer.parseInt(st.nextToken());
                int node2 = Integer.parseInt(st.nextToken());
                graph[node1].add(node2);
                graph[node2].add(node1);
            }

            for (int j = 1; j <= nodeSize; j++) {
                if(!visited[j]) {
                    dfs(j);
                }
            }

            if(answer) {
                result.append("YES");
            }else {
                result.append("NO");
            }

            result.append("\n");

        }

        bw.write(result.toString());

        bw.flush();
        br.close();
        bw.close();
    }
    public static void dfs(int index) {
        visited[index] = true;

        graph[index].forEach(i -> {
            if(!visited[i]) {
                group[i] = (group[index] + 1) % 2;
                dfs(i);
            }else if(group[i] == group[index]){
                answer = false;
            }
        });
    }
}
