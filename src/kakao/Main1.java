package kakao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main1 {
    public static void main(String [] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int[] solution = solution("2022.05.19", new String[]{"A 6", "B 12", "C 3"}, new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2021.02.20 C"});
        Arrays.stream(solution).forEach(System.out::println);

        bw.write(result.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    public static int[] solution(String today, String[] terms, String[] privacies) {
        int[] date = Arrays.stream(today.split("\\.")).mapToInt(Integer::parseInt).toArray();
        long dateTotal = (long)date[0] *10000 + date[1] * 100 + date[2];
        Map<Character, Integer> types = new HashMap<>();
        List<Integer> answerIndex = new ArrayList<>();
        for (int i = 0; i < terms.length; i++) {
            String[] temp = terms[i].split(" ");
            char key = temp[0].charAt(0);
            int value = Integer.parseInt(temp[1]);
            types.put(key, value);
        }

        for (int i=0;i<privacies.length;i++) {
            String [] divideStrTemp = privacies[i].split(" ");
            char nowType = divideStrTemp[1].charAt(0);
            int nowAddMonth = types.get(nowType);

            int[] pre = Arrays.stream(divideStrTemp[0].split("\\.")).mapToInt(Integer::parseInt).toArray();
            pre[1] += nowAddMonth;

            while (pre[1] > 12) {
                pre[1] -= 12;
                pre[0]++;
            }

            long nowTotal = (long)pre[0] *10000 + pre[1] * 100 + pre[2];

            if(nowTotal <= dateTotal) {
                answerIndex.add(i + 1);
            }

        }



        int[] answer = new int[answerIndex.size()];
        for (int i = 0; i < answerIndex.size(); i++) {
            answer[i] = answerIndex.get(i);
        }
        return answer;
    }
}

