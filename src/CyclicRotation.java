import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author Ahmad Hajjar <ash852006@gmail.com>
 * Created on 03/11/2018
 */
public class CyclicRotation {
    public static void main(String[] args) {
        int[][] testsArrays = new int[][]{
                {-1, -2, -3, -4, -5, -6},
                {3, 8, 9, 7, 6},
                {0, 0, 0},
                {1, 2, 3, 4}
        };
        int[] testK = new int[]{
                5, 3, 1, 4
        };
        for (int i = 0; i < testsArrays.length; i++) {
            int[] result = new CyclicRotation().solution2(testsArrays[i], testK[i]);
            for (int j : result) {
                System.out.print(j + ",");
            }
            System.out.println();
        }
    }

    public int[] solution1(int[] A, int K) {
        int N = A.length;
        if (K == 0 || N == K || N == 0 || N == 1) {
            return A;
        }

        int[] A1 = Arrays.copyOfRange(A, 0, N - K);
        int[] A2 = Arrays.copyOfRange(A, N - K, N);
        return IntStream.concat(Arrays.stream(A2), Arrays.stream(A1)).toArray();
    }

    /**
     * This is more efficient version
     *
     * @param A
     * @param K
     * @return
     */
    public int[] solution2(int[] A, int K) {
        int N = A.length;
        if (K == 0 || N == K || N == 0 || N == 1) {
            return A;
        }

        if (K > N) {
            K = K % N;
        }
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            if (i + K >= N) {
                result[i - (N - K)] = A[i];
            } else {
                result[i + K] = A[i];
            }
        }
        return result;
    }
}