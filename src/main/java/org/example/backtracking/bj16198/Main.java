package org.example.backtracking.bj16198;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    private static int size;
    private static int max = 0;
    private static  List<Integer> list;
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        size = Integer.parseInt(st.nextToken());
        list = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).boxed()
                .collect(Collectors.toList());
        dfs(0);
        result.append(max);



        bw.write(result.toString());
    
        bw.flush();
        br.close();
        bw.close();
    }

    private static void dfs(int sum) {
        if(list.size() <= 2) {
            max = Math.max(max, sum);
            return;
        }
        for (int i = 1; i < list.size() - 1; i++) {
            int temp = list.get(i);
            int mul = list.get(i - 1) * list.get(i + 1);
            list.remove(i);
            dfs(sum + mul);
            list.add(i, temp);
        }
    }
}
