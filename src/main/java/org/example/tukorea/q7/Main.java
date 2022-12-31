package tukorea.q7;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {

    public static void main(String [] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String w1 = scanner.next();
        String w2 = scanner.next();
        char[][] arr = new char[w2.length() + 1][w1.length() + 1];
        int w1Point = 0;
        int w2Point = 0;
        for (int i = 0; i < w1.length(); i++) {
            if(w2.contains(w1.charAt(i) + "")) {
                w1Point = i;
                w2Point = w2.indexOf(w1.charAt(i) + "");
                break;
            }
        }

        for (int i = 0; i < w1.length(); i++) {
            arr[w2Point][i] = w1.charAt(i);
        }
        for (int i = 0; i < w2.length(); i++) {
            arr[i][w1Point] = w2.charAt(i);
        }

        for (int i = 0; i < w2.length(); i++) {
            for (int j = 0; j < w1.length(); j++) {
                if(arr[i][j] == 0) {
                    sb.append(".");
                }else {
                    sb.append(arr[i][j]);
                }
            }
            sb.append("\n");
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();

    }
}
