package org.example.graph.bj2623;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeSize = Integer.parseInt(st.nextToken());
        int actSize = Integer.parseInt(st.nextToken());
        List<Integer>[] graph = new List[nodeSize + 1];
        int[] count = new int[nodeSize + 1];
        for (int i = 0; i < nodeSize + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < actSize; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 1; j <arr.length - 1; j++) {
                graph[arr[j]].add(arr[j + 1]);
                count[arr[j + 1]]++;
            }
        }
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < nodeSize) {
            int next = -1;
            for (int i = 1; i <= nodeSize; i++) {
                if(count[i] == 0) {
                    next = i;
                    count[i] = -10;
                    break;
                }
            }
            if(next == -1) {
                answer.clear();
                break;
            }

            answer.add(next);
            for(Integer i : graph[next]) {
                count[i]--;
            }
        }

        if(answer.isEmpty()) {
            answer.add(0);
        }

        answer.forEach(i -> sb.append(i).append("\n"));

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
