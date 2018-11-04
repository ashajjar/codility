import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Thanks to the authors of https://www.geeksforgeeks.org/radix-sort/ for the implementation of Radix Sort in java that
 * was used in this code to enhance the effiency of the code.
 *
 * @author Ahmad Hajjar <ash852006@gmail.com>
 * Created on 03/11/2018
 */
public class MissingInteger {
    public static void main(String[] args) {
        MissingInteger missingInteger = new MissingInteger();
        System.out.println(missingInteger.solution(new int[]{1, 3, 6, 4, 1, 2}));
        System.out.println(missingInteger.solution(new int[]{1, 2, 3}));
        System.out.println(missingInteger.solution(new int[]{1, 2, 5}));
        System.out.println(missingInteger.solution(new int[]{1, 2}));
        System.out.println(missingInteger.solution(new int[]{1, 11, 2, 3, 4, 5, 7, 8, 9, 10, 12}));
        System.out.println(missingInteger.solution(new int[]{1, 11, 3, 4, 5, 7, 8, 9, 10, 12}));
        System.out.println(missingInteger.solution(new int[]{-1, -3}));
        System.out.println(missingInteger.solution(new int[]{2}));
        System.out.println(missingInteger.solution(new int[]{1}));
        System.out.println(missingInteger.solution(new int[]{4, 5, 6, 2}));
    }


    public int solution(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int i : A) {
            if (i <= 0) {
                continue;
            }
            set.add(i);
        }
        if (set.isEmpty()) {
            return 1;
        }

        Integer[] B = new Integer[set.size()];
        set.toArray(B);
        radixsort(B);

        if (set.size() == B[set.size() - 1]) {
            return B[set.size() - 1] + 1;
        }
        if (B[0] != 1) {
            return 1;
        }

        return findMissingInt(B, 0, B.length - 1);
    }

    private int findMissingInt(Integer[] B, int first, int last) {
        int length = last - first + 1;
        if (length == 2) {
            if (B[last] - B[first] == 1)
                return B[last] + 1;
            else
                return B[first] + 1;
        }
        int midIndex = length % 2 == 0 ? (length / 2) - 1 : length / 2;
        if (B[first + midIndex] != first + midIndex + 1) {
            return findMissingInt(B, first, first + midIndex);
        }
        return findMissingInt(B, first + midIndex, last);
    }


    // A utility function to get maximum value in arr[]
    private int getMax(Integer[] arr) {
        int mx = arr[0];
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    private void countSort(Integer[] arr, int exp) {
        int n = arr.length;
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to curent digit
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }

    // The main function to that sorts arr[] of size n using
    // Radix Sort
    private void radixsort(Integer arr[]) {
        // Find the maximum number to know number of digits
        int m = getMax(arr);

        // Do counting sort for every digit. Note that instead
        // of passing digit number, exp is passed. exp is 10^i
        // where i is current digit number
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort(arr, exp);
    }


    public int solution1(int[] A) {
        TreeSet<Integer> tree = new TreeSet<>();
        for (int i : A) {
            if (i <= 0) {
                continue;
            }
            tree.add(i);
        }
        if (tree.isEmpty()) {
            return 1;
        }
        if (tree.size() == tree.last()) {
            return tree.last() + 1;
        }
        int counter = 0;
        for (int i : tree) {
            counter++;
            if (i != counter) {
                return counter;
            }
        }
        return counter + 1;
    }
}
