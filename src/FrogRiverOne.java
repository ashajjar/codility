import java.util.HashSet;
import java.util.Set;

/**
 * @author Ahmad Hajjar <ash852006@gmail.com>
 * Created on 01/11/2018
 */
public class FrogRiverOne {
    public static void main(String[] args) {
        System.out.println(new FrogRiverOne().solution(5, new int[]{1, 3, 1, 4, 2, 3, 5, 4}));
    }

    public int solution(int X, int[] A) {
        Set<Integer> steps = new HashSet<>();
        int N = A.length;
        for (int i = 0; i < N; i++) {
            steps.add(A[i]);
            if (steps.size() == X) {
                return i;
            }
        }
        return -1;
    }
}
