import java.util.Arrays;

/**
 * @author Ahmad Hajjar <ash852006@gmail.com>
 * Created on 01/11/2018
 */
public class PermCheck {
    public static void main(String[] args) {
        int[][] testsArrays = new int[][]{
                {4, 1, 3, 2},
                {4, 1, 3}
        };
        for (int i = 0; i < testsArrays.length; i++) {
            int result = new PermCheck().solution(testsArrays[i]);
            System.out.println(result);
        }
    }

    public int solution(int[] A) {
        Arrays.sort(A);
        int N = A.length;
        for (int i = 0; i < N; i++) {
            if (A[i] != i + 1) {
                return 0;
            }
        }
        return 1;
    }
}
