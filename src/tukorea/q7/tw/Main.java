package tukorea.q7.tw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        String s1 = st.nextToken();
        String s2 = st.nextToken();

        int y = -1;
        int x = -1;

        char[][] result = new char[s2.length()][s1.length()];

        for (int i = 0; i < s2.length(); i++) {

            char word = s2.charAt(i); // P가 있나 확인

            for (int j = 0; j < s1.length(); j++) {
                if (word == s1.charAt(j)) {
                    y = i; // i번째 ,j번째 위치값 확인(먼저 처음에 발견하면 break로 나간다.)
                    x = j;
                    break;
                }
            }

            if (x != -1)
                break;
        }

        for (int i = 0; i < s2.length(); i++) {
            for (int j = 0; j < s1.length(); j++) {
                result[i][j] = ‘.’;
            }
        }

        for (int i = 0; i < s2.length(); i++) {
            result[i][x] = s2.charAt(i);
        }

        for (int i = 0; i < s1.length(); i++) {
            result[y][i] = s1.charAt(i);
        }

        for (int i = 0; i < s2.length(); i++) {
            for (int j = 0; j < s1.length(); j++) {
                sb.append(result[i][j]);
            }
            sb.append(“\n”);
        }
    }

        System.out.println(sb);
}

}