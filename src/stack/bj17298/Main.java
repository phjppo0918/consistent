package stack.bj17298;

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
        Stack<Element> elementStack = new Stack<>();
        Queue<Element> inputQueue = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numSize; i++) {
            inputQueue.add(new Element(i, Integer.parseInt(st.nextToken())));
        }
        int[] ansArr = new int[numSize];

        elementStack.push(inputQueue.poll());

        while (!inputQueue.isEmpty()) {
            while (!inputQueue.isEmpty() && elementStack.peek().value >= inputQueue.peek().value) {
                elementStack.push(inputQueue.poll());
            }

            if (inputQueue.isEmpty()) {
                break;
            }

            while (!elementStack.isEmpty() && elementStack.peek().value < inputQueue.peek().value) {
                ansArr[elementStack.pop().index] = inputQueue.peek().value;
            }
            elementStack.push(inputQueue.poll());
        }

        elementStack.forEach(e -> ansArr[e.index] = -1);

        Arrays.stream(ansArr).forEach(e -> {
            result.append(e);
            result.append(" ");
        });

        result.append(" ");

        bw.write(result.toString());

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
