package org.example.tree.bj1991;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    private static Map<String, Tree> graph;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        graph = new HashMap<>();

        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            graph.put(st.nextToken(), new Tree(st.nextToken(), st.nextToken()));
        }

        List<String> pre = new ArrayList<>();
        List<String> ino = new ArrayList<>();
        List<String> post = new ArrayList<>();
        setPre(pre, "A");
        setInOrder(ino, "A");
        setPost(post, "A");
        pre.forEach(result::append);
        result.append("\n");
        ino.forEach(result::append);
        result.append("\n");
        post.forEach(result::append);
        result.append("\n");

        bw.write(result.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    private static void setPre(List<String> list, String head) {
        list.add(head);
        if (!graph.get(head).left.equals(".")) {
            setPre(list, graph.get(head).left);
        }
        if (!graph.get(head).right.equals(".")) {
            setPre(list, graph.get(head).right);
        }
    }



    private static void setInOrder(List<String> list, String head) {
        if (!graph.get(head).left.equals(".")) {
            setInOrder(list, graph.get(head).left);
        }
        list.add(head);
        if (!graph.get(head).right.equals(".")) {
            setInOrder(list, graph.get(head).right);
        }
    }

    private static void setPost(List<String> list, String head) {
        if (!graph.get(head).left.equals(".")) {
            setPost(list, graph.get(head).left);
        }
        if (!graph.get(head).right.equals(".")) {
            setPost(list, graph.get(head).right);
        }
        list.add(head);
    }
}

class Tree {
    String left;
    String right;

    public Tree(String left, String right) {
        this.left = left;
        this.right = right;
    }
}
