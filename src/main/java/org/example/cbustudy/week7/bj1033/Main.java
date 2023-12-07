package org.example.cbustudy.week7.bj1033;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Node>[] graph;
    static boolean[] visited;
    static long[] answer;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        graph = new List[size];
        visited = new boolean[size];
        answer = new long[size];

        for (int i = 0; i < size; i++) {
            graph[i] = new ArrayList<>();
        }
        long gongbe = 1;

        for (int i = 0; i < size - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int n3 = Integer.parseInt(st.nextToken());
            int n4 = Integer.parseInt(st.nextToken());
            graph[n1].add(new Node(n2, n3, n4));
            graph[n2].add(new Node(n1, n4, n3));
            gongbe *= (n3 * n4 / gong(n3, n4));
        }
        answer[0] = gongbe;
        dfs(0);
        long div = answer[0];
        for (int i = 1; i < size; i++) {
            div = gong(div, answer[i]);
        }
        for (int i = 0; i < size; i++) {
            sb.append(answer[i]/div).append(" ");
        }

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    static long gong(long a, long b) {
        if (a > b) {
            long temp = a;
            a = b;
            b = temp;
        }

        while (b % a != 0) {
            long temp = a;
            a = b % a;
            b = temp;
        }

        return a;
    }

    static void dfs(int now) {
        visited[now] = true;
        for (Node n : graph[now]) {
            int next = n.target;
            if (!visited[next]) {
                answer[next] = answer[now] * n.q / n.p;
                dfs(next);
            }
        }
    }
}

class Node {
    int target;
    int p;
    int q;

    public Node(int target, int p, int q) {
        this.target = target;
        this.p = p;
        this.q = q;
    }
}