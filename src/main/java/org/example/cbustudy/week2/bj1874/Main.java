package org.example.cbustudy.week2.bj1874;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());

        List<Integer> target = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            final int next = Integer.parseInt(br.readLine());
            target.add(next);

        }

        Stack<Integer> stack = new Stack<>();
        List<Character> answer = new ArrayList<>();
        int pivot = 0;
        stack.add(1);
        answer.add('+');
        int stackElement = 1;
        boolean isFail = false;
        while (pivot < size) {
            int next = target.get(pivot);
            if(!stack.empty() && stack.peek().equals(next)) {
                stack.pop();
                answer.add('-');
                pivot++;
            }else {
                stackElement++;
                stack.add(stackElement);
                answer.add('+');
                if(stackElement > size) {
                    isFail = true;
                    break;
                }
            }
        }

        if(isFail) {
            sb.append("NO");
        }else {
            answer.forEach(i -> sb.append(i).append("\n"));
        }

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
