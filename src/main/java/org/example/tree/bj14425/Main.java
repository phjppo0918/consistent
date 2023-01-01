package tree.bj14425;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int strSize = Integer.parseInt(st.nextToken());
        int testSize = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        for (int i = 0; i < strSize; i++) {
            set.add(br.readLine());
        }

        int count = 0;
        for (int i = 0; i < testSize; i++) {
            if (set.contains(br.readLine())) {
                count++;
            }
        }

        result.append(count);

        bw.write(result.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
