package primeNumber.bj1747;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int minNum = Integer.parseInt(st.nextToken());

        final int MAX_NUM = 10000000;
        boolean[] isNotSosu = new boolean[MAX_NUM + 1];
        for (int i = 2; i <= MAX_NUM; i++) {
            if(!isNotSosu[i]) {
                int temp = 2;
                while (temp * i <= MAX_NUM) {
                    isNotSosu[temp * i] = true;
                    temp++;
                }
            }
        }

        int answer = 0;
        for (int i = minNum; i < MAX_NUM; i++) {
            if(!isNotSosu[i] && isPD(i)) {
                answer = i;
                break;
            }
        }
        if(minNum == 1) {
            answer = 2;
        }

        result.append(answer);
        result.append("\n");
        
        bw.write(result.toString());
    
        bw.flush();
        br.close();
        bw.close();
    }

    public static boolean isPD(Integer n) {
        char[] arr = n.toString().toCharArray();
        int leftPivot = 0;
        int rightPivot = arr.length - 1;

        while (leftPivot < rightPivot) {
            if(arr[leftPivot] != arr[rightPivot]) {
                return false;
            }
            leftPivot++;
            rightPivot--;
        }

        return true;
    }
}
