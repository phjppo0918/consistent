package sort.selection.bj1427;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] ints = br.readLine().chars().sorted().map(c -> c - '0').toArray();
        for (int i = ints.length-1; i >=0 ; i--) {
            result.append(ints[i]);
        }
        result.append("\n");

        bw.write(result.toString());

        bw.flush();
        br.close();
        bw.close();
    }
}
