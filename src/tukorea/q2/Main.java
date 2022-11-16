package tukorea.q2;

import java.util.Scanner;

public class Main {
    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);

        short round = scanner.nextShort();

        int readPoint = 0;
        int maxLead = 0;

        for (short i = 0; i < round; i++) {
            readPoint += scanner.nextShort();
            readPoint -= scanner.nextShort();

            if(Math.abs(maxLead) < Math.abs(readPoint)) {
                maxLead = readPoint;
            }
        }
        if(maxLead > 0) {
            System.out.println("1 " + maxLead);
        }else {
            System.out.println("2 " + maxLead * -1);
        }
    }
}
