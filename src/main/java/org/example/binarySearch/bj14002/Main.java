package org.example.binarySearch.bj14002;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());

        int[] arr = new int[size+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(Integer.MIN_VALUE);
        int[] indexArr = new int[size + 1];

        for (int i = 1; i <= size; i++) {
            int tail = list.get(list.size() - 1);
            if (tail < arr[i]) {
                list.add(arr[i]);
                indexArr[i] = list.size() - 1;
            } else {
                int num = arr[i];
                int left = 1;
                int right = list.size() - 1;
                int next =0;
                while(left <= right){
                    int mid = (left + right) / 2;
                    if(list.get(mid) >= num) {
                        next = mid;
                        right = mid - 1;
                    }
                    else left = mid + 1;
                }
                list.set(next, num);
                indexArr[i] = next;
            }
        }

        sb.append(list.size()-1).append("\n");
        Stack<Integer> stack = new Stack();

        int index = list.size() - 1;

        for(int i = size; i > 0; i--){
            if(indexArr[i] == index){
                index--;
                stack.push(arr[i]);
            }
        }

        while (!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
