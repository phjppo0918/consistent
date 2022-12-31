package dp.bj14501;

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
    
        int totalEndDay = Integer.parseInt(st.nextToken());
        List<Plan> plans = new ArrayList<>();
        int [] dp = new int[totalEndDay * 2];
        for (int i = 0; i < totalEndDay; i++) {
            st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int money = Integer.parseInt(st.nextToken());
            plans.add(new Plan(i+1, day, money));
        }

        Plan lastPlan = plans.get(plans.size() - 1);
        if(lastPlan.endDay == totalEndDay) {
            dp[totalEndDay - 1] = lastPlan.money;
        }
        for (int i = totalEndDay - 2; i >= 0; i--) {
            Plan now = plans.get(i);
            if(now.endDay > totalEndDay) {
                dp[i] = dp[i + 1];
                continue;
            }
            dp[i] = Math.max(dp[i + 1], now.money + dp[now.endDay]);
        }
        result.append(dp[0]);
        
        bw.write(result.toString());
    
        bw.flush();
        br.close();
        bw.close();
    }
}

class Plan {
    int startDay;
    int endDay;

    public Plan(int startDay, int day, int money) {
        this.startDay = startDay;
        this.endDay = startDay + day - 1;
        this.money = money;
    }

    int money;
}
