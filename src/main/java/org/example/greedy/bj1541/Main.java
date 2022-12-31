package greedy.bj1541;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       // StringTokenizer st = new StringTokenizer(br.readLine());

        String[] strSplit = br.readLine().split("-");
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i <strSplit.length ; i++) {
            int sum = Arrays.stream(strSplit[i].split("\\+"))
                    .mapToInt(Integer::parseInt).sum();
            queue.add(sum);
        }

        int answer = queue.poll();

        while (!queue.isEmpty()) {
            answer -= queue.poll();
        }

        result.append(answer);
        result.append("\n");

        bw.write(result.toString());
    
        bw.flush();
        br.close();
        bw.close();
    }
}
