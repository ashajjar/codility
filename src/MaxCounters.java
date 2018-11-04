import java.util.HashMap;

/**
 * @author Ahmad Hajjar <ash852006@gmail.com>
 * Created on 03/11/2018
 */
public class MaxCounters {
    public static void main(String[] args) {
        int[] result = new MaxCounters().solution(5, new int[]{3, 4, 4, 6, 1, 4, 4});
        for (int i : result) {
            System.out.print(i + ",");
        }
    }

    public int[] solution(int N, int[] A) {
        int[] result = new int[N];
        int currentMax = 0;
        boolean isSetToMax = false;
        HashMap<Integer, Integer> map = new HashMap<>();
        int base = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == N + 1) {
                map = new HashMap<>();
                base = currentMax;
                continue;
            }
            Integer counter = map.get(A[i] - 1);
            if (counter == null) {
                map.put(A[i] - 1, 1);
                counter = 1;
            } else {
                map.put(A[i] - 1, ++counter);
            }
            if (base + counter > currentMax) {
                currentMax = base + counter;
            }
        }

        for (int i = 0; i < N; i++) {
            Integer finalCounterValue = map.get(i);
            if (finalCounterValue == null) {
                finalCounterValue = 0;
            }
            result[i] = base + finalCounterValue;
        }
        return result;
    }
}
