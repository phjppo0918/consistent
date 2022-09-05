package dfs.bj11724;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static ArrayList<Integer>[] gr;
    public static Stack<Integer> stack = new Stack<>();
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        int nodeCount = Integer.parseInt(st.nextToken());
        int edgeCount = Integer.parseInt(st.nextToken());

        gr = new ArrayList[nodeCount+1];
        long answer = 0;
        for (int i = 0; i <= nodeCount; i++) {
            gr[i] = new ArrayList<>();
        }

        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            gr[start].add(end);
            gr[end].add(start);
        }
        for (int i = 1; i <= nodeCount; i++) {
            if(gr[i].isEmpty()) {
                answer++;
            }
        }

        for (int i = 1; i <= nodeCount; i++) {
            if(!gr[i].isEmpty()) {
                dfs(i);
                answer++;
            }
        }
        result.append(answer);
        
        bw.write(result.toString());
    
        bw.flush();
        br.close();
        bw.close();
    }

    public static void dfs(int index) {
        while (!gr[index].isEmpty()) {
            gr[index].forEach(e -> {
                stack.push(e);
                gr[e].remove((Integer) index);
            });
            gr[index].clear();
        }
        if(stack.empty()) {
            return;
        }
        dfs(stack.pop());
    }
}
