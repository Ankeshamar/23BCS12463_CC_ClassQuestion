import java.io.*;
import java.util.*;

public class CF1795C {

    static void solve(int n, long[] teaAmount, long[] drinkAmount) {
        PriorityQueue<Long> finishTimes = new PriorityQueue<>();
        long[] result = new long[n];
        long totalDrunkTillNow = 0;
        for (int day = 0; day < n; day++) {
            long finishDay = totalDrunkTillNow + teaAmount[day];
            finishTimes.add(finishDay);
            long todayDrink = 0;
            while (!finishTimes.isEmpty() &&
                   finishTimes.peek() <= totalDrunkTillNow + drinkAmount[day]) {
                long endTime = finishTimes.poll();
                todayDrink += (endTime - totalDrunkTillNow);
            }
            todayDrink += (long) finishTimes.size() * drinkAmount[day]
            totalDrunkTillNow += drinkAmount[day];
            result[day] = todayDrink;
        }
        for (long x : result) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long[] teaAmount = new long[n];
            long[] drinkAmount = new long[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                teaAmount[i] = Long.parseLong(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                drinkAmount[i] = Long.parseLong(st.nextToken());
            }n
            solve(n, teaAmount, drinkAmount);
        }
    }
}