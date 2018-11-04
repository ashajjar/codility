/**
 * @author Ahmad Hajjar <ash852006@gmail.com>
 * Created on 03/11/2018
 */
public class BinaryGap {
    public static void main(String[] args) {
        int[] tests = new int[]{1041, 15, 32};
        for (int i : tests) {
            System.out.println(new BinaryGap().solution(i));
        }
    }

    public int solution(int N) {
        int maxGap = 0;
        int count = 0;
        boolean isCounting = false;
        while (N > 0) {
            int mod = N % 2;
            N = N / 2;
            if (mod == 1) {
                if (count > maxGap) {
                    maxGap = count;
                }
                isCounting = true;
                count = 0;
                continue;
            }
            if (isCounting)
                count++;
        }
        return maxGap;
    }
}
