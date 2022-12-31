package graph.bj1043;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static int[] graph;
    public static List<Integer>[] party;
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        int manSize = Integer.parseInt(st.nextToken());
        int partySize = Integer.parseInt(st.nextToken());
        graph = new int[manSize + 1];
        party = new ArrayList[partySize];

        for (int i = 1; i <= manSize; i++) {
            graph[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int knowManSize = Integer.parseInt(st.nextToken());
        for (int i = 0; i < knowManSize; i++) {
            int man = Integer.parseInt(st.nextToken());
            graph[man] = 0;
        }

        for (int i = 0; i < partySize; i++) {
            party[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            int firstMan = Integer.parseInt(st.nextToken());
            party[i].add(firstMan);
            for (int j = 1; j < count; j++) {
                int man= Integer.parseInt(st.nextToken());
                party[i].add(man);
                union(firstMan, man);
            }
        }

        int count = partySize;
        for (int i = 0; i < partySize; i++) {
            for (Integer e : party[i]) {
                if(check(0, e)) {
                    count--;
                    break;
                }
            }
        }

        result.append(count);
        result.append("\n");
        
        bw.write(result.toString());
    
        bw.flush();
        br.close();
        bw.close();
    }

    public static void union(int node1, int node2) {
        if(node2 != node1) {
            graph[getParent(node2)] = getParent(node1);
        }
    }

    public static int getParent(int node) {
        if(node == graph[node]) {
            return node;
        }

        return graph[node] = getParent(graph[node]);
    }

    public static boolean check(int node1, int node2){
        return getParent(node1) == getParent(node2);
    }
}
