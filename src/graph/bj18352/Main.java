package graph.bj18352;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static List<Integer>[] graph;
    public static int[] visited;
    public static Queue<Integer> queue = new LinkedList<>();
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int citySize = Integer.parseInt(st.nextToken());
        int roadSize = Integer.parseInt(st.nextToken());
        int range = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(st.nextToken());
        graph = new List[citySize + 1];
        visited = new int[citySize + 1];
        for (int i = 1; i <= citySize; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < roadSize; i++) {
            st = new StringTokenizer(br.readLine());
            int startNum = Integer.parseInt(st.nextToken());
            int finishNum = Integer.parseInt(st.nextToken());
            graph[startNum].add(finishNum);
        }
        bfs(startNode);

        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i <= citySize; i++) {
            if(visited[i] - 1 == range) {
                answer.add(i);
            }
        }



        if(answer.isEmpty()) {
            result.append(-1);
            result.append("\n");
        }else {
            answer.forEach(i -> {
                result.append(i);
                result.append("\n");
            });
        }

        
        bw.write(result.toString());
    
        bw.flush();
        br.close();
        bw.close();
    }
    public static void bfs(int node) {
        visited[node]++;

        graph[node].forEach(i -> {
            if(visited[i] == 0) {
                visited[i] = visited[node];
                queue.add(i);
            }
        });

        while (!queue.isEmpty()) {
            bfs(queue.poll());
        }
    }
}
