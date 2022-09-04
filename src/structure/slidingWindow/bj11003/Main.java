package structure.slidingWindow.bj11003;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numSize = Integer.parseInt(st.nextToken());
        int slideSize = Integer.parseInt(st.nextToken());

        Element[] arr = new Element[numSize];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numSize; i++) {
            arr[i] = new Element(Integer.parseInt(st.nextToken()), i);
        }

        Deque<Element> deque = new ArrayDeque<>();
        for (int i = 0; i < slideSize; i++) {
            inputDeque(deque, arr[i]);
            result.append(deque.peekFirst().value);
            result.append(" ");
        }

        for (int i = slideSize; i < numSize; i++) {
            if(deque.peekFirst().index <= i-slideSize) {
                deque.removeFirst();
            }
            inputDeque(deque, arr[i]);
            result.append(deque.peekFirst().value);
            result.append(" ");
        }

        bw.write(result.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    public static void inputDeque(Deque<Element> deque, Element element) {
        while (!deque.isEmpty() && deque.peekLast().value > element.value) {
            deque.removeLast();
        }

        deque.addLast(element);
    }
}

class Element {
    int value;
    int index;

    public Element(int value, int index) {
        this.value = value;
        this.index = index;
    }
}
