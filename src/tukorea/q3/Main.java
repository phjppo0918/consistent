package tukorea.q3;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String [] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int m1 = scanner.nextInt();
        int m2 = scanner.nextInt();
        int sampleLength = scanner.nextInt();
        String message1 = scanner.next();
        String message2 = scanner.next();
        String sample = scanner.next();

        Deque<Character> deque = new ArrayDeque();
        deque.addLast(sample.charAt(0));
        for (int i = 1; i < sampleLength; i++) {
            char c = sample.charAt(i); //e
            if(deque.peekLast() != c) {
                deque.addLast(c);
            }
        }
        StringBuilder sampleBuffer = new StringBuilder();
        while (!deque.isEmpty()) {
            sampleBuffer.append(deque.pollFirst());
        }
        String decoSample = sampleBuffer.toString();
        if(decoSample.contains(message1)) {
            sb.append("YES");
        }else {
            sb.append("NO");
        }
        sb.append("\n");
        if(decoSample.contains(message2)) {
            sb.append("YES");
        }else {
            sb.append("NO");
        }
        sb.append("\n");

        bw.write(sb.toString());

        bw.flush();
        bw.close();

    }
}
