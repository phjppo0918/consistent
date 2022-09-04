package structure.queue.bj11286;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> {
            int n1Abs = Math.abs(n1);
            int n2Abs = Math.abs(n2);
            if (n1Abs == n2Abs) {
                return n1 > n2 ? 1 : -1;
            } else {
                return n1Abs - n2Abs;
            }
        });

        int actionCount = Integer.parseInt(st.nextToken());
        for (int i = 0; i < actionCount; i++) {
            int action = Integer.parseInt(br.readLine());
            if (action == 0) {
                if (pq.isEmpty()) {
                    result.append(0);
                } else {
                    result.append(pq.remove());
                }
                result.append("\n");
            }else {
                pq.add(action);
            }
        }


        bw.write(result.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
