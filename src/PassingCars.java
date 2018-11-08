import java.util.ArrayList;

/**
 * @author Ahmad Hajjar <ash852006@gmail.com>
 * Created on 08/11/2018
 */
public class PassingCars {

    public static void main(String[] args) {
        int[][] tests = new int[][]{
                {1},
                {0},
                {0, 1, 0, 1, 1,}
        };

        for (int[] test : tests) {
            System.out.println(new PassingCars().solution(test));
        }
    }

    public int solution(int[] A) {
        int N = A.length;
        if (N == 1) {
            return 0;
        }
        ArrayList<Integer> sums = new ArrayList<Integer>();
        int currentSum = 0;
        int finalSum = 0;
        for (int i = N - 1; i > -1; i--) {
            if (A[i] == 1) {
                currentSum++;
            } else {
                finalSum += currentSum;
                if (finalSum > 1000000000) {
                    return -1;
                }
            }
        }

        return finalSum;
    }
}
