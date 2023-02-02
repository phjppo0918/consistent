package org.example.tree.bj2263;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
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
        search(0, size - 1, 0, size - 1);
        pre.forEach(i -> sb.append(i).append(' '));

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    private static void search(int inStart, int inEnd, int postStart, int postEnd) {
        if(inStart > inEnd || postStart > postEnd){
            return;
        }
        pre.add(post[postEnd]);
        int inCenter = 0;
        int nextPostStart = 0;
        for (int i = inStart; i < inStart + size; i++) {
            if(in[i] == post[postEnd]) {
                inCenter = i;
                break;
            }
        }
        int nextPostPivot = postStart + inCenter - 1 - inStart;
        search(inStart, inCenter - 1, postStart, nextPostPivot);
        search(inCenter + 1 , inEnd, nextPostPivot + 1, postEnd - 1);
    }
}
