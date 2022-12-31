package graph.bj1325;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static List<Integer>[] graph;
    public static boolean[] visited;
    public static int[] ans;
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        int nodeSize = Integer.parseInt(st.nextToken());
        int edgeSize = Integer.parseInt(st.nextToken());
        graph = new ArrayList[nodeSize + 1];
        ans = new int[nodeSize + 1];
        for (int i = 1; i <= nodeSize; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edgeSize; i++) {
            st = new StringTokenizer(br.readLine());
            int startNode = Integer.parseInt(st.nextToken());
            int endNode = Integer.parseInt(st.nextToken());
            graph[startNode].add(endNode);
        }

        for (int i = 1; i <= nodeSize; i++) {
            visited = new boolean[nodeSize + 1];
            visited[i] = true;
            bfs(i);
        }

        List<Integer> answer = new ArrayList<>();;
        int maxCount = 0;
        for (int i = 1; i <= nodeSize; i++) {
            if(ans[i] > maxCount) {
                answer = new ArrayList<>();
                answer.add(i);
                maxCount = ans[i];
            }else if(ans[i] == maxCount) {
                answer.add(i);
            }
        }

        answer.forEach(i -> {
            result.append(i);
            result.append(" ");
        });

        result.append("\n");
        
        bw.write(result.toString());
    
        bw.flush();
        br.close();
        bw.close();
    }

    public static void bfs(int index) {
        Queue<Integer> queue = new LinkedList<>();

        graph[index].forEach(i -> {
            if(!visited[i]) {
                queue.add(i);
                ans[i]++;
                visited[i] = true;
            }
        });

        while (!queue.isEmpty()) {
            bfs(queue.poll());
        }

    }
}
