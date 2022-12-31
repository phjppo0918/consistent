package sort.bubble.bj1377;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int arrSize = Integer.parseInt(st.nextToken());

        Element[] arr = new Element[arrSize];
        for (int i = 0; i < arrSize; i++) {
            arr[i] = new Element(i, Integer.parseInt(br.readLine()));
        }
        Arrays.sort(arr);
        int max = 0;

        for (int i = 0; i < arrSize; i++) {
            if(arr[i].index - i > max) {
                max = arr[i].index - i;
            }
        }
        result.append(max + 1);
        bw.write(result.toString());

        bw.flush();
        br.close();
        bw.close();
    }

}

class Element implements Comparable<Element> {
    int index;
    int value;

    public Element(int index, int value) {
        this.index = index;
        this.value = value;
    }

    @Override
    public int compareTo(Element o) {
        return this.value - o.value;
    }
}
