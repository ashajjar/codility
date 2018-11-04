public class TapeEquilibrium {


    public static void main(String[] args) {
        System.out.println("Hello World!");
        TapeEquilibrium m = new TapeEquilibrium();
        int[][] ints = {
                {3, 1, 2, 4, 3},
                {1, 7, 9, 8, 5},
                {-1000, 1000}
        };
        for (int[] x : ints) {
            System.out.println(m.solution(x));
        }
    }

    public int solution(int[] A) {
        int N = A.length;
        int[] runningSums = new int[N];
        int runningSum = 0;

        for (int i = 0; i < N; i++) {
            runningSum += A[i];
            runningSums[i] = runningSum;
        }
        int minAbsDiff = Integer.MAX_VALUE;
        int sum = runningSum;

        for (int i = 1; i < N; i++) {
            int diff = Math.abs(sum - (2 * runningSums[i - 1]));
            if (diff < minAbsDiff) {
                minAbsDiff = diff;
            }
        }
        return minAbsDiff;
    }

}
