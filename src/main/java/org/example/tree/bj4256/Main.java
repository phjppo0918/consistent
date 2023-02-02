package org.example.tree.bj4256;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static Queue<Integer> pre;
    private static int[] in;
    private static StringBuilder sb;
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testCase = Integer.parseInt(st.nextToken());
        for (int i = 0; i < testCase; i++) {
            int size = Integer.parseInt(br.readLine());
            pre = new LinkedList<>();
            Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).forEach(pre::add);
            in = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            search(0, size - 1);
            sb.append("\n");
        }

        
        bw.write(sb.toString());
    
        bw.flush();
        br.close();
        bw.close();
    }
    public static void search(int inStart, int inEnd) {
        if(inStart > inEnd) {
            return;
        }
        int head = pre.poll();
        if(inStart == inEnd) {
            sb.append(head).append(" ");
            return;
        }
        int inCenterPivot = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if(in[i] == head) {
                inCenterPivot = i;
            }
        }
        search(inStart, inCenterPivot -1);
        search(inCenterPivot + 1, inEnd);

        sb.append(head).append(" ");
    }
}
