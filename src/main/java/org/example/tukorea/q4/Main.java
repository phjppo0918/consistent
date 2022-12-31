package tukorea.q4;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int b = scanner.nextInt();
        int a1Count = scanner.nextInt();
        int a2Count = scanner.nextInt();
        int[] a1 = new int[a1Count];
        int[] a2 = new int[a2Count];
        int[] total = new int[1_000_000];
        for (int i = 0; i < a1Count; i++) {
            a1[i] = scanner.nextInt();
        }
        for (int i = 0; i < a2Count; i++) {
            a2[i] = scanner.nextInt();
        }

        for (int i = a2Count - 1; i > -1; i--) {
            int totalPiv = 1_000_000 -1 - a2Count + i;
            for (int j = a1Count - 1; j > -1; j--) {
                total[totalPiv] += a2[i] * a1[j];
                total[totalPiv - 1] +=  total[totalPiv]/b;
                total[totalPiv] %=b;
                totalPiv--;
            }
        }
        int pivot = 0;
        while (total[pivot] == 0) {
            pivot++;
        }
        sb.append(1_000_000 - pivot -1);
        sb.append("\n");

        for (int i = pivot; i < total.length - 1; i++) {
            sb.append(total[i]);
            sb.append(" ");
        }
        sb.append("\n");

        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }
}
