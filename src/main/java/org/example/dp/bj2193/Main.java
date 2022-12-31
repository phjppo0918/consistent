package org.example.dp.bj2193;

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
        result.append(getCountPinaryNumber(Integer.parseInt(st.nextToken())));

        bw.write(result.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    public static long getCountPinaryNumber(int num) {
        long[] arr = new long[num + 1];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < num; i++) {
            arr[i] = arr[i -1] + arr[i - 2];
        }

        return arr[num - 1];
    }
}

/**
 *
 * 3 이상인 N 자리수에서
 *
 * N 번째 자리수가 0일 때 [N - 1] 케이스와 경우의 수 동일
 * N 번째 자리수가 1일 때 [N - 2] 케이스와 경우의 수 동일
 * 즉, N 자리수의 케이스는 N - 1의 경우의 수와 n - 2의 경우의 수의 합 : 피보나치
 * N이 90일때 값이 댕 큼! Long 처리
 */
/*
class MainTest {
    @Test
    @DisplayName("이친수를 출력하는가")
    void mainTest() throws Exception {
        compareResult(1, 1);
        compareResult(2, 1);
        compareResult(3, 2);
        compareResult(4, 3);
        compareResult(5, 5);
        compareResult(6, 8);
        compareResult(90, 2880067194370816120L);
    }

    @Test
    @DisplayName("2 자리 이하일 때 이친수가 1인가")
    void getLimitDigit() throws Exception {
        compareResult(2, 1);
        compareResult(1, 1);
    }

    void compareResult(int testCase, long expected) {
        assertThat(Main.getCountPinaryNumber(testCase)).isEqualTo(expected);
    }
}
*/