package org.example.cbustudy.week4.bj1717;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int[] union;
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeCount = Integer.parseInt(st.nextToken());
        int operCount = Integer.parseInt(st.nextToken());

        union = new int[nodeCount + 1];
        for (int i = 0; i <=nodeCount; i++) {
            union[i] = i;
        }

        for (int i = 0; i < operCount; i++) {
            st = new StringTokenizer(br.readLine());
            int oper = Integer.parseInt(st.nextToken());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            if(num2 > num1) {
                int temp = num1;
                num1 = num2;
                num2 = temp;
            }

            if(oper == 0) {
                union[getUnion(num2)] = getUnion(num1);
            }else {
                if(getUnion(num1) == getUnion(num2)) {
                    sb.append("YES");
                }else {
                    sb.append("NO");
                }
                sb.append("\n");
            }
        }

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    static int getUnion(int num) {
        if(num == union[num]) return num;

        union[num] = getUnion(union[num]);
        return union[num];
    }

}
