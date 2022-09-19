package tree.bj11725;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        int nodeSize = Integer.parseInt(st.nextToken());
        List<Integer>[] graph = new List[nodeSize + 1];
        for (int i = 1; i <= nodeSize; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < nodeSize -1; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            graph[node1].add(node2);
            graph[node2].add(node1);
        }

        int parent[] = new int[nodeSize + 1];
        parent[1] = 1;
        Stack<Integer> stack = new Stack<>();
        stack.push(1);

        while (!stack.isEmpty()) {
            int now = stack.pop();
            for (Integer i : graph[now]) {
                if(parent[i] != 0) {
                    continue;
                }
                parent[i] = now;
                stack.push(i);
            }
        }

        for (int i = 2; i <= nodeSize; i++) {
            result.append(parent[i]);
            result.append("\n");
        }

        bw.write(result.toString());
    
        bw.flush();
        br.close();
        bw.close();
    }
}
