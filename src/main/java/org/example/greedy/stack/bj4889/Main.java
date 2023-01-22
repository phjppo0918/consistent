package org.example.greedy.stack.bj4889;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int time = 1;
        while (true) {
            String line = br.readLine();
            if (line.contains("-")) {
                break;
            }

            char[] chars = line.toCharArray();
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < chars.length; i++) {
                if(chars[i] == '{') {
                    stack.push('{');
                }else {
                    if (!stack.isEmpty() && stack.peek() == '{') {
                        stack.pop();
                    }else {
                        stack.push('}');
                    }
                }
            }
            int count = 0;
            while (!stack.isEmpty()) {
                char c1 = stack.pop();
                char c2 = stack.pop();
                if(c1 == c2) {
                    count++;
                }else {
                    count+=2;
                }
            }

            sb.append(time).append(". ").append(count).append("\n");
            time++;
        }

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
