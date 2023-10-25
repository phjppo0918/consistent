package org.example.cbustudy.week2.bj11724;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeSize = Integer.parseInt(st.nextToken());
        int edgeSize = Integer.parseInt(st.nextToken());
        List<Integer>[] graph = new List[nodeSize + 1];
        boolean[] visited = new boolean[nodeSize + 1];
        for (int i = 0; i <= nodeSize; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edgeSize; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            graph[n1].add(n2);
            graph[n2].add(n1);
        }


        if (edgeSize == 0) {
            sb.append(nodeSize);
        } else {
            int answer = 0;
            boolean isFin = false;
            int nextStart = 1;

            while (!isFin) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(nextStart);
                visited[nextStart] = true;
                answer++;
                while (!queue.isEmpty()) {
                    int next = queue.poll();
                    for (int n : graph[next]) {
                        if (!visited[n]) {
                            queue.add(n);
                            visited[n] = true;
                        }
                    }
                }

                isFin = true;
                for (int i = nextStart + 1; i <= nodeSize; i++) {
                    if (!visited[i]) {
                        nextStart = i;
                        isFin = false;
                        break;
                    }
                }

            }
            sb.append(answer);
        }


        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
