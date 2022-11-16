package tukorea.q6;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {

    public static void main(String [] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int value = scanner.nextInt();
        int answer = 0;
        while (value < 999_999_999) {
            value++;
            char [] check = new char[10];
            String valueStr = String.valueOf(value);
            for (int i = 0; i < valueStr.length(); i++) {
                check[valueStr.charAt(i) - '0']++;
            }
            if(check[0] > 0) {
                continue;
            }
            boolean isContinue = false;
            for (int i = 1; i < 10; i++) {
                if(check[i] > 1) {
                    isContinue = true;
                    break;
                }
            }

            if(isContinue) {
                continue;
            }
            answer = value;
            break;
        }
        sb.append(answer);

        sb.append("\n");

        bw.write(sb.toString());

        bw.flush();
        bw.close();

    }
}
