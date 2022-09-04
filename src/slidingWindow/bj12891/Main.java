package slidingWindow.bj12891;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int totalLength = Integer.parseInt(st.nextToken());
        int partLength = Integer.parseInt(st.nextToken());
        char[] arr = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());
        int aNeed = Integer.parseInt(st.nextToken());
        int cNeed = Integer.parseInt(st.nextToken());
        int gNeed = Integer.parseInt(st.nextToken());
        int tNeed = Integer.parseInt(st.nextToken());

        int[] count = new int[88];
        for (int i = 0; i < partLength; i++) {
            count[arr[i]]++;
        }
        int firstPivot = 0;
        int lastPivot = partLength - 1;

        int answer = 0;

        while (true) {

            if (count['A'] >= aNeed &&
                    count['C'] >= cNeed &&
                    count['G'] >= gNeed &&
                    count['T'] >= tNeed) {
                answer++;
            }

            lastPivot++;

            if(lastPivot >= totalLength) {
                break;
            }
            count[arr[firstPivot]]--;
            firstPivot++;
            count[arr[lastPivot]]++;
        }



        result.append(answer);

        bw.write(result.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}