package tukorea.q1;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main{

    public static void main(String [] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        final int NUMBER_OF_SEAT = scanner.nextInt();
        String seat = scanner.next();
        int numberOfS = 0;
        int numberOfL = 0;
        for(int i=0;i<NUMBER_OF_SEAT;i++) {
            if(seat.charAt(i) == 'S') {
                numberOfS++;
            }else {
                numberOfL++;
            }
        }
        int answer = 0;
        if(numberOfL == 0) {
            answer = numberOfS;
        }else {
            answer = (NUMBER_OF_SEAT + 1) - (numberOfL/2);
        }

        sb.append(answer);
        sb.append("\n");

        bw.write(sb.toString());

        bw.flush();
        bw.close();

    }
}


