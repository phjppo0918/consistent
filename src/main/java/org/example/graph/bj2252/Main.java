package graph.bj2252;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static List<Integer>[] graph;
    public static int[] count;
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int manSize = Integer.parseInt(st.nextToken());
        int caseSize = Integer.parseInt(st.nextToken());

        graph = new ArrayList[manSize + 1];
        count = new int[manSize + 1];
        for (int i = 1; i <= manSize; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < caseSize; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            graph[num1].add(num2);
            count[num2]++;
        }

        List<Integer> answer = new ArrayList<>();
        while (answer.size() != manSize) {
            for (int i = 1; i <= manSize; i++) {
                if(count[i] == 0) {
                    answer.add(i);
                    count[i]--;
                    graph[i].forEach(k -> count[k]--);
                }
            }
        }

        answer.forEach(i -> {
            result.append(i);
            result.append(" ");
        });

        result.append("\n");

        bw.write(result.toString());
    
        bw.flush();
        br.close();
        bw.close();
    }
}
