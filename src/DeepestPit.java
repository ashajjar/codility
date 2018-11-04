/**
 * @author Ahmad Hajjar <ash852006@gmail.com>
 * Created on 04/11/2018
 */
public class DeepestPit {
    public static void main(String[] args) {
        int[] a = {1, 2, 1, 1, 1};
        int[] b = {0, 1, 3, -2, 0, 1, 0, -3, 2, 3};
        int[] c = {0, 1};
        int[] d = {0};

        System.out.println(new DeepestPit().solution(a));
        System.out.println(new DeepestPit().solution(b));
        System.out.println(new DeepestPit().solution(c));
        System.out.println(new DeepestPit().solution(d));

//        long time1 = System.currentTimeMillis();
//        for (int i = 0; i < 1000000; i++) {
//            new DeepestPit().solution1(a);
//            new DeepestPit().solution1(b);
//            new DeepestPit().solution1(c);
//            new DeepestPit().solution1(d);
//        }
//        long time2 = System.currentTimeMillis();
//        System.out.println("--------------------------- diff is : " + (time2 - time1));
//
//        long time3 = System.currentTimeMillis();
//        for (int i = 0; i < 1000000; i++) {
//            new DeepestPit().solution(a);
//            new DeepestPit().solution(b);
//            new DeepestPit().solution(c);
//            new DeepestPit().solution(d);
//        }
//        long time4 = System.currentTimeMillis();
//        System.out.println("--------------------------- diff is : " + (time4 - time3));
    }

    public int solution(int[] A) {

        int N = A.length;
        if (N < 3) {
            return -1;
        }

        int lastChange = 0;
        int deepestPit = -1;
        int jump = -1;
        boolean isAscending = true;
        for (int i = 1; i < N; i++) {
            boolean currentDirection = A[i] == A[i - 1] ? isAscending : A[i] > A[i - 1];
            if (currentDirection != isAscending) {
                isAscending = currentDirection;
                jump = isAscending ? (A[lastChange] - A[i - 1]) : -1;
                lastChange = i - 1;
            }

            deepestPit = Math.max(deepestPit, Math.min(jump, A[i] - A[lastChange]));
        }
        return deepestPit;
    }


    public int solution1(int[] A) {
        // write your code in Java SE 7
        int N = A.length;

        int depth = -1;
        int P, Q, R;
        int i = 0, j, k;
        while (i < N - 2) {
            P = A[i];

            j = i + 1;
            int p = P;
            while (j < N - 1 && A[j] < p) {
                p = A[j++];
            }
            if (j == N - 1) {
                break;
            }
            if (j > i + 1) {
                Q = A[j - 1];
            } else {
                i++;
                continue;
            }
            k = j;
            int q = Q;
            while (k < N && A[k] > q) {
                q = A[k++];
            }

            if (k > j) {
                R = A[k - 1];
                depth = Math.max(depth, Math.min(P - Q, R - Q));
                i = k - 1;
            } else {
                i = j - 1;
            }
        }

        return Math.max(depth, -1);
    }

}
