package structure.queue.bj2164;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    
        int cardCount = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= cardCount; i++) {
            queue.add(i);
        }
        while (queue.size() > 1) {
            queue.poll();
            int temp = queue.poll();
            queue.add(temp);
        }

        result.append(queue.poll());
        
        bw.write(result.toString());
    
        bw.flush();
        br.close();
        bw.close();
    }
}
