package org.example.cbustudy.week4.bj1325;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static int[] visitCount;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeSize = Integer.parseInt(st.nextToken());
        int edgeSize = Integer.parseInt(st.nextToken());

        graph = new List[nodeSize + 1];
        for (int i = 0; i <= nodeSize; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < edgeSize; i++) {
            st = new StringTokenizer(br.readLine());
            int end = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            graph[start].add(end);
        }

        visitCount = new int[nodeSize + 1];
        //Arrays.fill(visitCount, 1);
        //boolean[] visited = new boolean[nodeSize + 1];

        for (int i = 1; i <= nodeSize; i++) {
            visitCount[i] = getCount(i);
        }

        int max = -1;
        List<Integer> answer = new ArrayList<>();

        for (int i = 1; i <= nodeSize; i++) {
            if(max < visitCount[i]) {
                answer.clear();
                answer.add(i);
                max = visitCount[i];
            }else if(max == visitCount[i]) {
                answer.add(i);
            }

        }


        answer.forEach(i -> sb.append(i).append(" "));


        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    static int getCount(int num) {
        int count = 1;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.length + 1];
        queue.add(num);
        visited[num] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : graph[now]) {
                if(!visited[next]) {
                    count++;
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }

        return  count;
    }
}
