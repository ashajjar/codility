import java.util.Arrays;

/**
 * @author Ahmad Hajjar <ash852006@gmail.com>
 * Created on 03/11/2018
 */
public class PermMissingElem {
    public static void main(String[] args) {
        int[][] testsArrays = new int[][]{
                {2, 3, 1, 5},
                {},
                {1},
                {12}
        };
        for (int i = 0; i < testsArrays.length; i++) {
            int result = new PermMissingElem().solution(testsArrays[i]);
            System.out.println(result);
        }
    }

    public int solution(int[] A) {
        int N = A.length;
        if (N == 0) {
            return 1;
        }
        Arrays.sort(A);
        for (int i = 0; i < N; i++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }
        return A[N - 1] + 1;
    }
}
