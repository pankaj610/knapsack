package algo;

public class Knapsack {

    int max_profit;
    boolean[] item_pick;

    public int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public int knapsackAlgo(int[] profit, int[] weight, int W, int n) {
        int[][] K = new int[n + 1][W + 1];
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    K[i][w] = 0;
                } else if (w >= weight[i - 1]) {
                    K[i][w] = max(profit[i - 1] + K[i - 1][w - weight[i - 1]], K[i - 1][w]);
                } else {
                    K[i][w] = K[i - 1][w];
                }
            }
        }

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                System.out.print(K[i][w] + ",");
            }
            System.out.println();
        }
        return K[n][W];
////        item_pick = new boolean[n];
//        int[][] matrix = new int[n+1][capacity+1];
////        for(int w = 0; w<=capacity; w++){
//////            System.out.println(w);
////            matrix[0][w] = 0;
////        }
////        for(int i = 1; i<=n; i++){
////            matrix[i][0] = 0;
////        }
//        for(int i=1; i<n; i++){
//            for(int w=0; w<capacity; w++){
//                if(weight[i]<w){
//                    if(profit[i] + matrix[i-1][w-profit[i]] > matrix[i-1][w])
//                        matrix[i][w] = profit[i] + matrix[i-1][w-profit[i]];
//                    else
//                        matrix[i][w] = matrix[i-1][w];
//                }
//                else
//                    matrix[i][w] = matrix[i-1][w];
//            }
//        }
//        for(int i=1; i<=n; i++){
//            for(int w=0; w<=capacity; w++){
//                System.out.print(matrix[i][w]);
//            }
//            System.out.println();
//        }

    }

    public static void main(String[] args) {
        int[] profit = {60, 100, 120};
        int[] weight = {10, 20, 30};
        int knapsack = 50;
        int n = profit.length;
        Knapsack knp = new Knapsack();
        System.out.println(knp.knapsackAlgo(profit, weight, knapsack, n));
    }
}
