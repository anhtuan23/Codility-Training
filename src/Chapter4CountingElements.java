import java.util.Arrays;
import java.util.HashSet;

class Chapter4CountingElements {
    //Not fast enough
    //Array is divided into section with N + 1 as boundary
    //  find the max occurrence in each section
    //  finally add all elements to the total max occurrence of all sections
    static int[] maxCounters(int N, int[] A) {
        int totalBase = 0;
        int biggestSectionOccurrence = 0;
        int[] counter = new int[N];
        for (int a : A) {
            if (a != N + 1) {
                int occurrence = counter[a-1] + 1;
                counter[a-1] = occurrence;
                if (occurrence > biggestSectionOccurrence) {
                    biggestSectionOccurrence = occurrence;
                }
            } else {//reset to count on new section
                totalBase += biggestSectionOccurrence;
                biggestSectionOccurrence = 0;
                counter = new int[N];//this is inefficient
            }
        }
        for (int i = 0; i < counter.length; i++) {
            counter[i] += totalBase;
        }
        return counter;
    }

    //Faster because do not need to create new Arrays
    static int[] maxCounters2(int N, int[] A) {
        int max = 0;//tracking max occurrence of current sections
        int lastMax = 0;//tracking max occurrence of previous sections
        int[] counters = new int[N];

        for (int a : A) {
            if (a >= 1 && a <= N) {
                //counters position is set to lastMax if it is larger
                counters[a - 1] = Math.max(counters[a - 1], lastMax);
                counters[a - 1] += 1;
                //recording the current max
                max = Math.max(max, counters[a - 1]);
            } else if (a == N + 1) {
                lastMax = max;
            }
        }

        //counters is traversed the final time to update all element to at least lastMax
        for(int i = 0 ; i < counters.length; i++) {
            counters[i] = Math.max(counters[i], lastMax);
        }

        return counters;
    }

    static int missingInteger(int[] A) {
        //A.length + 1 because we do not mark 0 but mark till A.length instead
        boolean[] markings = new boolean[A.length + 1];
        for (int a : A) {
            if (a > 0 && a < A.length + 1) {
                markings[a] = true;
            }
        }
        for (int i = 1; i < markings.length; i++) {
            if (!markings[i]) return i;
        }
        return A.length + 1; //in case all position is there,
        //   the next element A.length +1 will be the answer
    }

    static int missingInteger2(int[] A) {
        Arrays.sort(A);
        int min = 1;
        // Starting from 1 (min), compare all elements, if it does not match
        // that would the missing number.
        for (int i : A) {
            if (i == min) {
                min++;
            }
        }
        return min;
    }

    static int permCheck(int[] A) {
        HashSet<Integer> marking = new HashSet<>();
        for (int a : A) {
            if (a >= 1 && a <= A.length) {
                if (!marking.add(a)) {//if the set already contains this element
                    return 0;
                }
            } else {
                return 0;
            }
        }
        return marking.size() == A.length ? 1 : 0;
    }

    //Only check for duplicate and out of bound elements
    //  do not care whether all of necessary elements show up
    static int permCheck2(int[] A) {
        // write your code in Java SE 8
        boolean[] seen = new boolean[A.length + 1];

        // repeated elements
        for (int a : A) {
            if (a < 1 || a > A.length) return 0;
            if (seen[a]) return 0;
            else seen[a] = true;
        }

        return 1;
    }

    static int frogRiverOne(int X, int[] A) {
        HashSet<Integer> marking = new HashSet<>();
        for (int i = 1; i <= X; i++) {
            marking.add(i);
        }
        for (int i = 0; i < A.length; i++) {
            marking.remove(A[i]);
            if (marking.size() == 0) return i;
        }
        return -1;
    }

    //Quicker, only add valid values into set
    static int frogRiverOne2(int X, int[] A) {
        HashSet<Integer> fallen = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] <= X)
                fallen.add(A[i]);

            if (fallen.size() == X)
                return i;
        }

        return -1;
    }

    //Not using HashSet
    static int frogRiverOne3(int X, int[] A) {
        int steps = X;
        boolean[] bitmap = new boolean[steps + 1];
        for (int i = 0; i < A.length; i++) {
            if (!bitmap[A[i]]) {
                bitmap[A[i]] = true;
                steps--;
            }
            if (steps == 0) return i;
        }
        return -1;
    }


}
