package org.example.binarySearch.bj1365;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int size = Integer.parseInt(st.nextToken());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Integer> search = new ArrayList<>();
        search.add(arr[0]);
        for (int i = 1; i < size; i++) {
            if (arr[i] > search.get(search.size() - 1)) {
                search.add(arr[i]);
            }else {
                int start = 0;
                int end = search.size() -1;
                int targetPivot = -1;
                while (start <= end) {
                    int mid = (start + end) / 2;
                    if(search.get(mid) > arr[i]) {
                        targetPivot = mid;
                        end = mid - 1;

                    }else {
                        start = mid + 1;
                    }
                }
                if(targetPivot != -1) {
                    search.set(targetPivot, arr[i]);
                }
            }
        }
        int answer = size - search.size();
        search.clear();
        sb.append(answer);


        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
