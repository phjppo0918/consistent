package org.example.cbustudy.week4.bj1707;

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

        int testSize = Integer.parseInt(st.nextToken());

        for (int i = 0; i < testSize; i++) {
            st = new StringTokenizer(br.readLine());
            int nodeSize = Integer.parseInt(st.nextToken());
            int edgeSize = Integer.parseInt(st.nextToken());
            List<Integer>[] graph = new List[nodeSize + 1];
            for (int j = 0; j <= nodeSize; j++) {
                graph[j] = new ArrayList<>();
            }
            for (int j = 0; j < edgeSize; j++) {
                st = new StringTokenizer(br.readLine());
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());
                graph[n1].add(n2);
                graph[n2].add(n1);
            }

            if(isBinary(nodeSize, graph)) {
                sb.append("YES");
            }else {
                sb.append("NO");
            }

            sb.append("\n");


        }

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    private static boolean isBinary(int nodeSize, List<Integer>[] graph) {

        State[] status = new State[nodeSize + 1];
        Arrays.fill(status, State.WHITE);


        for (int j = 1; j <= nodeSize; j++) {
            if (status[j] == State.WHITE) {
                Queue<Integer> queue = new LinkedList<>();
                status[j] = State.BLUE;
                queue.add(j);
                while (!queue.isEmpty()) {
                    final int now = queue.poll();
                    for (int next : graph[now]) {
                        if (status[next] == State.WHITE) {
                            status[next] = status[now].getChange();
                            queue.add(next);
                        } else if (status[next] == status[now]) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}

enum State {
    BLUE,
    RED,
    WHITE;


    public State getChange() {
        if (this.equals(BLUE)) {
            return RED;
        }
        return BLUE;
    }
}
