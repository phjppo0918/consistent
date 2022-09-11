package graph.bj1516;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int buildingSize = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new List[buildingSize + 1];
        for (int i = 1; i <= buildingSize ; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] count = new int[buildingSize + 1];
        int selfTime[] = new int[buildingSize + 1];

        for (int i = 1; i <= buildingSize; i++) {
            st = new StringTokenizer(br.readLine());
            selfTime[i] = Integer.parseInt(st.nextToken());
            int temp = Integer.parseInt(st.nextToken());
            while (temp != -1) {
                graph[temp].add(i);
                count[i]++;
                temp = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= buildingSize ; i++) {
            if(count[i] == 0) {
                queue.add(i);
            }
        }

        int answer[] = new int[buildingSize + 1];
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for(int i : graph[now]) {
                count[i]--;

                answer[i] = Math.max(answer[i], answer[now] + selfTime[now]);
                if(count[i] == 0) {
                    queue.add(i);
                }
            }
        }

        for (int i = 1; i <= buildingSize ; i++) {
            result.append(answer[i] + selfTime[i]);
            result.append("\n");
        }


        bw.write(result.toString());
    
        bw.flush();
        br.close();
        bw.close();
    }
}
