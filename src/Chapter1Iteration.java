import java.util.ArrayList;
import java.util.List;

public class Chapter1Iteration {
    static int findLongestBinaryGapWithString(int n){
        //First, find all index of 1 in binary string
        String s = Integer.toBinaryString(n);
        List<Integer> oneIndices = new ArrayList<>();
        int index = s.indexOf('1');
        while (index >= 0){
            oneIndices.add(index);
            index = s.indexOf('1', index + 1);
        }
        //Compare all gaps:
        if (oneIndices.size() < 2) return 0;
        int biggestGap = 0;
        for (int i = 1; i < oneIndices.size(); i++) {
            int gap = oneIndices.get(i) - oneIndices.get(i-1) - 1;
            if (gap > biggestGap) biggestGap = gap;
        }
        return biggestGap;
    }

    //Using Integer directly
    static int findLongestBinaryGap(int N) {
        int binaryGap = 0;
        // remove trailing zeroes if not counted; credit to Peter Taylor
        while (N % 2 == 0) {
            N /= 2;
        }
        for (int j = 0; N > 0; N /= 2) {
            if (N % 2 == 0) {
                j++;
            } else {
                if (j > binaryGap) {
                    binaryGap = j;
                }

                j = 0;
            }
        }
        return binaryGap;
    }

    //Using bit manipulation
    static int findLongestBinaryGapBit(int n) {
        while (n % 2 == 0) {
            n /= 2; // remove trailing zeroes
        }
        int maxGap = 0;
        int priorIndex1 = 0;
        while (n != 0) {
            int index1 = Integer.numberOfTrailingZeros(n);
            int zeroGap = index1 - priorIndex1 - 1;
            if (zeroGap > maxGap) {
                maxGap = zeroGap ;
            }
            priorIndex1 = index1;
            n &= n - 1; // Remove the lowest 1 bit;
            //How: if the last bit is 1, it is turned into 0: 101001 & 101000 = 101000
            //     if the last bit is 0, that bit till next 1 bit is turned to 1;
            //          the next 1 bit is 0: 101000 & 100111 = 100000
        }
        return maxGap;
    }

    // Let’s print a triangle made of asterisks (‘*’) separated by spaces and consisting
    // of n rows again, but this time upside down, and make it symmetrical. Consecutive rows should
    // contain 2n − 1, 2n − 3, . . . , 3, 1 asterisks and should be indented by 0, 2, 4, . . . , 2(n − 1)
    // spaces. For example, for n = 4 the triangle should appear as follows:
    // * * * * * * *
    //   * * * * *
    //     * * *
    //       *
    static void printTriangle(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * i; j++) {
                System.out.print(" ");
            }
            for (int j = 2 * n - 2 * i - 1; j > 0; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    //print Fibonacci numbers : 0, 1, 1, 2, 3, 5, 8, 13
    static void printFibonacciNumbers (int max){
        int secondToLastNum = 0;
        int lastNum = 1;
        System.out.print(secondToLastNum + ", ");
        while (lastNum <= max){
            System.out.print(lastNum + ", ");
            lastNum += secondToLastNum;
            secondToLastNum = lastNum - secondToLastNum;
        }
    }
}
