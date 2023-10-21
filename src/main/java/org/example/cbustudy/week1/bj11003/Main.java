package org.example.cbustudy.week1.bj11003;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int targetLength = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        List<Element> elements = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            elements.add(new Element(i, Integer.parseInt(st.nextToken())));
        }

        Deque<Element> deque = new ArrayDeque<>();

        for (int i = 0; i < targetLength; i++) {
            Element next = elements.get(i);

            while (!deque.isEmpty() && deque.peekLast().value > next.value) {
                deque.removeLast();
            }
            deque.addLast(next);
            sb.append(deque.peekFirst().value).append(" ");
        }
        for (int i = targetLength; i < size; i++) {
            if (deque.peekFirst().index <= i - targetLength) {
                deque.removeFirst();
            }

            Element next = elements.get(i);
            while (!deque.isEmpty() && deque.peekLast().value > next.value) {
                deque.removeLast();
            }
            deque.addLast(next);

            sb.append(deque.peekFirst().value).append(" ");
        }

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}

class Element {
    int index;
    int value;

    public Element(int index, int value) {
        this.index = index;
        this.value = value;
    }
}
