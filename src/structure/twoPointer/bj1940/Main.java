package structure.twoPointer.bj1940;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int itemCount = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int reqValue = Integer.parseInt(st.nextToken());

        //st = new StringTokenizer(br.readLine());
        Integer list[] = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt)
                .sorted(Comparator.comparing(x -> x))
                .toArray(Integer[]::new);

        int firstPivot = 0;
        int endPivot = itemCount - 1;
        int answer = 0;

        while (firstPivot < endPivot) {
            if(list[firstPivot] + list[endPivot] < reqValue) {
                firstPivot++;
            }else if(list[firstPivot] + list[endPivot] > reqValue) {
                endPivot--;
            }else {
                answer++;
                firstPivot++;
            }
        }

        result.append(answer);

        bw.write(result.toString());
    
        bw.flush();
        br.close();
        bw.close();
    }
}
