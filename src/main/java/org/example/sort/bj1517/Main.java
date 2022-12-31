package sort.bj1517;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static Integer[] arr;
    public static Integer[] temp;
    public static long answer = 0;
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int numSize = Integer.parseInt(st.nextToken());
        arr = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        temp = new Integer[numSize];
        mgSort(0, numSize-1);
        result.append(answer);
        result.append("\n");
        bw.write(result.toString());
    
        bw.flush();
        br.close();
        bw.close();
    }

    public static void mgSort(int start, int end) {
        if(end - start <= 0) {
            return;
        }
        int center = (end - start)/2 + start;
        mgSort(start, center);
        mgSort(center + 1, end);

        int leftPivot = start;
        int rightPivot = center + 1;
        int tempPivot = start;
        while (tempPivot <= end) {
            if(leftPivot > center) {
                temp[tempPivot] = arr[rightPivot];
                rightPivot++;
            }else if(rightPivot > end) {
                temp[tempPivot] = arr[leftPivot];
                leftPivot++;
            }else if(arr[leftPivot] <= arr[rightPivot]) {
                temp[tempPivot] = arr[leftPivot];
                leftPivot++;
            }else {
                temp[tempPivot] = arr[rightPivot];
                answer += (center - leftPivot + 1);
                rightPivot++;
            }

            tempPivot++;
        }

        for (int i = start; i <= end; i++) {
            arr[i] = temp[i];
        }

    }
}


