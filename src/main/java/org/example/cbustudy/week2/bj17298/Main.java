package org.example.cbustudy.week2.bj17298;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        final List<Node> nodes = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).map(Node::new).collect(Collectors.toList());

        int pivot = 0;
        Stack<Node> stack = new Stack<>();

        while (pivot < size) {
            Node next = nodes.get(pivot);
            while (!stack.empty() && stack.peek().value < next.value) {
                Node pop = stack.pop();
                pop.nge = next.value;
            }
            stack.push(next);
            pivot++;
        }


        nodes.forEach(i -> sb.append(i.nge).append(" "));
        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}

class Node {
    int value;
    int nge = -1;

    public Node(int value) {
        this.value = value;
    }
}