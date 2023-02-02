package org.example.tree.bj2263;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main2 {
    static int size;
    static int[] in;
    static int[] post;
    static List<Integer> pre = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        size = Integer.parseInt(st.nextToken());
        in = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        post = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        search(size -1, size);
        pre.forEach( i -> sb.append(i).append(' '));

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    private static void search(int pivot, int size) {
        if(size == 0 || pivot < 0) return;
        pre.add(post[pivot]);
        int nextSize = (size -1)/2;
        search(pivot - nextSize - 1, nextSize);
        search(pivot-1, nextSize);
    }
}
