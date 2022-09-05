package dfs.bj13023;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static boolean visited[];
    public static short answer = 0;
    public static List<Integer>[] list;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int manSize = Integer.parseInt(st.nextToken());
        int edgeSize = Integer.parseInt(st.nextToken());
        list = new ArrayList[manSize];
        visited = new boolean[manSize];

        for (int i = 0; i < manSize; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < edgeSize; i++) {
            st = new StringTokenizer(br.readLine());
            int f1 = Integer.parseInt(st.nextToken());
            int f2 = Integer.parseInt(st.nextToken());
            list[f1].add(f2);
            list[f2].add(f1);
        }

        for (int i = 0; i < manSize; i++) {
            dfs(i, 1);
        }

        result.append(answer);
        bw.write(result.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    public static void dfs(int index, int grade) {

        if(grade == 5) {
            answer = 1;
            return;
        }

        visited[index] = true;

        list[index].forEach(e -> {
            if (!visited[e]) {
                dfs(e, grade + 1);
            }
        });

        visited[index] = false;
    }
}
