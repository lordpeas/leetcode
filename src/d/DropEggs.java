package d;

public class DropEggs {


    public int superEggDrop(int k, int n) {
        int dp[][] = new int[k+1][n+1];

        for(int i =1;i<=n;i++){
            //0个鸡蛋
            dp[0][i] = 0;
            //1个鸡蛋
            dp[1][i] = i;
        }

        for(int i =1;i<=k;i++){
            //0层都是0
            dp[i][0] = 0;
        }

        for(int i = 2;i<=k;i++){
            for(int j = 1;j<=n;j++){
                int l =1;
                int h = j;
                int res = n*n;
                while(l<=h){
                    int mid = l+(h-l)/2;
                    int breaked = dp[i-1][mid-1];
                    int not_break = dp[i][j-mid];
                    if(breaked>not_break){
                        h = mid-1;
                        res = Math.min(res,breaked+1);
                    }else{
                        l = mid+1;
                        res = Math.min(res,not_break+1);
                    }
                }
                dp[i][j] = res;
                System.out.println("res:"+res);
            }
        }
        return dp[k][n];
    }

    public static void main(String[] args) {
        DropEggs dropEggs = new DropEggs();
        int i = dropEggs.superEggDrop(3, 14);
        System.out.println(i);
    }
}
