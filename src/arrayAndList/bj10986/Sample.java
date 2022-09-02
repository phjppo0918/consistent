package arrayAndList.bj10986;

import java.io.IOException;
import java.util.Scanner;
public class Sample {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] S = new int[N+1];
        int[] C = new int[M];
        long answer = 0;
        //S[0] = sc.nextInt();
        for (int i = 1; i < N+1; i++) { // 수열 합배열 만들기
            S[i] = (S[i - 1] + sc.nextInt())%M;
            C[S[i]]++;
        }
        answer = C[0];

        for (int i = 0; i < M; i++) {
            if (C[i] > 1) {
                answer = answer + (C[i] * (C[i] - 1) / 2); // 같은 나머지를 가진 인덱스들중 2개를 뽑는 경우의 수를 더해주기
            }
        }

        System.out.println(answer);
    }
}