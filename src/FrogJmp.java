/**
 * @author Ahmad Hajjar <ash852006@gmail.com>
 * Created on 03/11/2018
 */
public class FrogJmp {
    public static void main(String[] args) {
        int[][] testsArrays = new int[][]{
                {10, 85, 30},
        };
        for (int i = 0; i < testsArrays.length; i++) {
            int result = new FrogJmp().solution(testsArrays[i][0], testsArrays[i][1], testsArrays[i][2]);
            System.out.println(result);
        }
    }

    public int solution(int X, int Y, int D) {
        return (int) Math.ceil((Y - X) / (double) D);
    }
}
