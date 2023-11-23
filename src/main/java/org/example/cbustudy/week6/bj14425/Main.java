package org.example.cbustudy.week6.bj14425;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());

        Map<Character, Tree> graph = new HashMap<>();

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            char l = st.nextToken().charAt(0);
            char r = st.nextToken().charAt(0);
            graph.put(c, new Tree(l, r));
        }

        sb.append(pre(graph, 'A')).append("\n");
        sb.append(in(graph, 'A')).append("\n");
        sb.append(post(graph, 'A')).append("\n");

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    private static String pre(Map<Character, Tree> graph, char c) {
        if (c == '.') {
            return "";
        }

        return c + pre(graph, graph.get(c).left) + pre(graph, graph.get(c).right);
    }

    private static String in(Map<Character, Tree> graph, char c) {
        if (c == '.') {
            return "";
        }
        return in(graph, graph.get(c).left) + c + in(graph, graph.get(c).right);
    }

    private static String post(Map<Character, Tree> graph, char c) {
        if (c == '.') {
            return "";
        }

        return post(graph, graph.get(c).left) + post(graph, graph.get(c).right) + c;
    }
}

class Tree {
    char left;
    char right;

    public Tree(char left, char right) {
        this.left = left;
        this.right = right;
    }
}
