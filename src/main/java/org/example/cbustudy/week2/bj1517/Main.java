package org.example.cbustudy.week2.bj1517;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static List<Integer> nums;
    static long ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        nums = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        sort(0, size - 1);

        sb.append(ans);
        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    private static void sort(int start, int end) {
        if (start >= end) {
            return;
        }
        int center = (end-start) / 2 + start;

        sort(start, center);
        sort(center + 1, end);
        int lIndex = start;
        int rIndex = center + 1;
        List<Integer> numTemp = new ArrayList<>();
        while (lIndex <= center && rIndex <= end) {
            if (nums.get(lIndex) <= nums.get(rIndex)) {
                numTemp.add(nums.get(lIndex));
                lIndex++;
            } else {
                int next = rIndex - start - numTemp.size();
                ans += next;
                numTemp.add(nums.get(rIndex));
                rIndex++;
            }
        }
        while (lIndex <= center) {
            numTemp.add(nums.get(lIndex));
            lIndex++;
        }
        while (rIndex <= end) {
            numTemp.add(nums.get(rIndex));
            rIndex++;
        }

        for (int i = 0; i < numTemp.size(); i++) {
            nums.set(i + start, numTemp.get(i));
        }
    }
}

