package tukorea2019.greedy.car;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String [] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        List<Lent> lents = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lents.add(new Lent(start, start + end));
        }
        Collections.sort(lents);
        int answerCount = 0;
        int time = 0;
        for (int i = 0; i < size; i++) {
            if(lents.get(i).start < time) {
                continue;
            }
            answerCount++;
            time = lents.get(i).end + 1;
        }
        System.out.println(answerCount);

        br.close();
    }
}

class Lent implements Comparable<Lent>{
    int start;

    int end;

    public Lent(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Lent o) {
        if( end == o.end ) {
            return  start - o.start;
        }
        return end - o.end;
    }
}
