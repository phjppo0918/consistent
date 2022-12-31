package tukorea2019.palindrome;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        final int MAX = 2_000_000;
        boolean[] arr = new boolean[MAX + 1];
        List<Integer> sosu = new ArrayList<>();
        for (int i = 2; i <= MAX ; i++) {
            if(arr[i]) {
                continue;
            }
            sosu.add(i);
            for (int j = 2; i * j <= MAX; j++) {
                arr[j * i] = true;
            }
        }
        int pivot = 0;
        while (sosu.get(pivot) < n) {
            pivot++;
        }

        for (int i = pivot; i < sosu.size(); i++) {
            if(ispd(sosu.get(i))) {
                result.append(sosu.get(i)).append("\n");
                break;
            }
        }

        bw.write(result.toString());

        bw.flush();
        br.close();
        bw.close();
    }
    public static boolean ispd(Integer n) {
        char[] array = n.toString().toCharArray();

        for (int i = 0; i < array.length/2; i++) {
            if(array[i] != array[array.length -1 - i]) {
                return false;
            }
        }
        return true;
    }
}
