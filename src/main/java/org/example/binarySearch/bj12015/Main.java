package org.example.binarySearch.bj12015;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());

        int[] arr = new int[size];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[0]);

        for (int i = 1; i < size; i++) {
            int tail = list.get(list.size() - 1);
            if (tail < arr[i]) {
                list.add(arr[i]);
            } else {
                int start = 0;
                int end = list.size() - 1;
                int center = 0;
                while (start <= end) {
                    center = (start + end) / 2;
                    int centerElement = list.get(center);
                    if (arr[i] < centerElement) {
                        end = center - 1;
                    } else if (arr[i] > centerElement) {
                        start = center + 1;
                        center++;
                    } else {
                        break;
                    }
                }
                list.set(center, arr[i]);
            }
        }


        sb.append(list.size()).append("\n");


        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
