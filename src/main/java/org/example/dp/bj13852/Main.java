package org.example.dp.bj13852;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        List<Integer>[] graph = new List[(size + 1) * 3];
        graph[1] = new ArrayList<>();

        for (int i = 1; i <= size; i++) {
            graph[i].add(i);
            setDp(size, graph, i, i + 1);
            setDp(size, graph, i, i * 2);
            setDp(size, graph, i, i * 3);

        }
        result.append(graph[size].size() - 1).append("\n");
        graph[size].stream().sorted(Collections.reverseOrder()).forEach(i -> {
            result.append(i);
            result.append(" ");
        });

        bw.write(result.toString());


        bw.flush();
        br.close();
        bw.close();
    }

    private static void setDp(int size, List<Integer>[] graph, int i, int pivot) {
        if (pivot <= size && (graph[pivot] == null || graph[pivot].size() > graph[i].size())) {
            graph[pivot] = new ArrayList<>(graph[i]);
        }
    }
}
