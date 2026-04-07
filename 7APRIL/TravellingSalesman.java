import java.util.*;
class TravellingSalesman{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int dist[][] = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dist[i][j] = sc.nextInt();
            }
        }
        int dp[][] = new int[n][1<<n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        dp[0][1] = 0;
        for(int mask=1;mask<(1<<n);mask++){
            for(int i=0;i<n;i++){
                if((mask&(1<<i))!=0){
                    for(int j=0;j<n;j++){
                        if((mask&(1<<j))==0){
                            dp[j][mask|(1<<j)] = Math.min(dp[j][mask|(1<<j)],dp[i][mask]+dist[i][j]);
                        }
                    }
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            ans = Math.min(ans,dp[i][(1<<n)-1]+dist[i][0]);
        }
        System.out.println(ans);
    }
}