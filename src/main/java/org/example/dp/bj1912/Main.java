package org.example.dp.bj1912;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static final int MIN_VALUE = -1001;

    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        String elements = br.readLine();
        sb.append(getMax(elements));
        bw.write(sb.toString());
    
        bw.flush();
        br.close();
        bw.close();
    }

    private static int[] parseArr(String element) {
        return Arrays.stream(element.split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    public static int getMax(String elements) {
        int[] arr = parseArr(elements);

        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Math.max(arr[i] , arr[i] + arr[i-1]);
            max = Math.max(arr[i], max);
        }
        return max;
    }
}
/**
 * 프로세스
 * 이전의 합 + 본인값 과 only 본인값 중 큰 수를 대입
 * 현재 최대값과 본인 값 비교
 */
/*
class MainTest {
    @Test
    @DisplayName("")
    void test() throws Exception {
        compareResult("10 -4 3 1 5 6 -35 12 21 -1", 33);
        compareResult("2 1 -4 3 4 -4 6 5 -5 1", 14);
        compareResult("-1 -2 -3 -4 -5", -1);
    }

    void compareResult(String elements, long expected) {
        assertThat(Main.getMax(elements)).isEqualTo(expected);
    }
}
 */