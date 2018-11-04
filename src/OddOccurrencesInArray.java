import java.util.Arrays;

/**
 * @author Ahmad Hajjar <ash852006@gmail.com>
 * Created on 03/11/2018
 */
public class OddOccurrencesInArray {
    public static void main(String[] args) {
        int[][] testsArrays = new int[][]{
                {9, 3, 9, 3, 9, 7, 9},
        };
        for (int i = 0; i < testsArrays.length; i++) {
            int result = new OddOccurrencesInArray().solution(testsArrays[i]);
            System.out.println(result);
        }
    }

    public int solution(int[] A) {
        int N = A.length;
        if (N == 1) {
            return A[0];
        }
        Arrays.sort(A);
        for (int i = 1; i < N; i += 2) {
            if (A[i] != A[i - 1]) {
                return A[i - 1];
            }
        }
        return A[N-1];
    }
}
