package stack.bj1874;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numSize = Integer.parseInt(st.nextToken());
        Queue<Integer> inputNums = new LinkedList<>();
        for (int i = 0; i < numSize; i++) {
            inputNums.add(Integer.parseInt(br.readLine()));
        }
        Stack<Integer> stack = new Stack<>();

        for (int i = 1; i <= numSize; i++) {

            stack.push(i);
            result.append("+\n");

            while (!stack.isEmpty() && Objects.equals(stack.peek(), inputNums.peek())) {
                result.append("-\n");
                inputNums.poll();
                stack.pop();
            }
        }

        if(stack.isEmpty()) {
            bw.write(result.toString());
        }else {
            bw.write("NO");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}