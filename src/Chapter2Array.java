import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Chapter2Array {

    //ODD_OCCURRENCES_IN_ARRAY
    //https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/
    //A non-empty array A consisting of N integers is given. The array contains an odd number of elements,
    // and each element of the array can be paired with another element that has the same value,
    // except for one element that is left unpaired.
    static int findTheOddOne(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : A) {
            if (map.containsKey(a)) {
                map.remove(a);
            } else {
                map.put(a, null);
            }
        }
        Map.Entry<Integer, Integer> entry = map.entrySet().iterator().next();
        return entry.getKey();
    }

    //Using Bit Manipulation
    static int findTheOddOne2(int[] A) {
        int oddOne = 0;
        for (int aA : A) {
            //basically smashing everything together
            // since a number xor itself equals 0, the Odd one is the only remain
            oddOne ^= aA;
        }
        return oddOne;
    }

    //    An array A consisting of N integers is given.
//    Rotation of the array means that each element is shifted right by one index,
//    and the last element of the array is moved to the first place. For example,
//    the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] (elements are shifted right by one index and
//    6 is moved to the first place).
//    The goal is to rotate array A K times; that is, each element of A will be shifted to the right K times.
    static int[] rotateArray(int[] A, int K) {
        if (A.length == 0) return A;
        K = K % A.length;
        int[] B = new int[A.length];
        for (int i = 0; i < A.length - K; i++) {
            B[i + K] = A[i];
        }
        for (int i = 0; i < K; i++) {
            B[i] = A[A.length - K + i];
        }
        return B;
    }

    //More clever with modulus
    static int[] rotateArray2(int[] A, int K) {
        if (A == null) return null;
        int arrayLength = A.length;

        int[] sol = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            sol[(i + K) % arrayLength] = A[i];
        }
        return sol;
    }
}
