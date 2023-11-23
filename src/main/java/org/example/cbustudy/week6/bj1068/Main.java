package org.example.cbustudy.week6.bj1068;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        int size = Integer.parseInt(st.nextToken());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Map<Integer, List<Integer>> tree = new HashMap<>();
        int root = -1;
        for (int i = 0; i < size; i++) {

            tree.put(i, new ArrayList<>());
        }
        int target = Integer.parseInt(br.readLine());
        for (int i = 0; i < size; i++) {
            if(arr[i] == -1) {
                root = i;
            }else {
                if(i == target) {
                    continue;
                }
                tree.get(arr[i]).add(i);
            }
        }
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            final Integer now = queue.poll();
            if(tree.get(now).isEmpty()) {
                answer++;
            }
            queue.addAll(tree.get(now));
        }


        if(root == target) {
            answer = 0;
        }

        sb.append(answer);
        
        bw.write(sb.toString());
    
        bw.flush();
        br.close();
        bw.close();
    }
}
