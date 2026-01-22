package DynamicProgramming.Knapsack.Implementation;

public class Main {

    public static void main(String[] args) {

        //System.out.println(knapsackRecursion(new int[] {1,2,3},new int[] {5,2,3},1,0));


        /*int weight[] = {1,2,3};
        int value[] = {4,6,5};
        int w = 5;
        int dp[][] = new int[w + 1] [weight.length + 1];

        for(int[] row : dp){
            Arrays.fill(row,-1);
        }

        System.out.println(knapsackMemoization(weight,value,w,0,dp));*/


        int weight[] = {1,2,3};
        int value[] = {4,6,5};
        int w = 5;
        int dp[][] = new int[weight.length + 1] [w + 1];

        System.out.println(knapsackTabulation(weight,value,w,dp));

    }

    public static int knapsackRecursion(int[] weight,int val[],int w,int idx){
        if (idx == weight.length || w == 0){
            return 0;
        }

        if (weight[idx] > w) return knapsackRecursion(weight,val,w,idx+1);

        else return Math.max(
                knapsackRecursion(weight,val,w,idx + 1),
                val[idx]+knapsackRecursion(weight,val,w - weight[idx],idx + 1)
        );

    }

    public static int knapsackMemoization(int[] weight,int val[],int w,int idx,int[][] dp){
        if (idx == weight.length || w == 0){
            return 0;
        }

        if (dp[w][idx] != -1) return dp[w][idx];

        if (weight[idx] > w) return dp[w][idx] = knapsackMemoization(weight,val,w,idx + 1,dp);

        else return dp[w][idx] = Math.max(
                val[idx] + knapsackMemoization(weight,val,w - weight[idx],idx + 1,dp),
                knapsackMemoization(weight,val,w,idx + 1,dp)
        );

    }

    public static int knapsackTabulation(int[] weight,int val[],int w,int[][] dp) {

        for (int i = 1; i <= weight.length; i++){

            for (int j = 1; j <= w; j++){

                if (weight[i - 1] <= j) {

                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - weight[i - 1]], dp[i - 1][j]);

                } else {

                    dp[i][j] = dp[i - 1][j];

                }

            }

        }

        return dp[weight.length][w];

    }

}
