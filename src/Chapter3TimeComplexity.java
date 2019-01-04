public class Chapter3TimeComplexity {
    static int tapeEquilibrium(int[] A) {
        int total = 0;
        for (int a : A) {
            total += a;
        }
        int sumPart1 = A[0];
        int sumPart2 = total - sumPart1;
        int difference = Math.abs(sumPart1 - sumPart2);
        for (int i = 2; i < A.length; i++) {
            sumPart1 += A[i - 1];
            sumPart2 -= A[i - 1];
            int newDifference = Math.abs(sumPart1 - sumPart2);
            if (newDifference < difference) difference = newDifference;
        }
        return difference;
    }

    static int permMissingElem(int[] A) {
        long length = A.length;
        long sumWithMissingElem = (length + 2) * (length + 1) / 2;
        int sumWithoutMissingElem = 0;
        for (int a : A) {
            sumWithoutMissingElem += a;
        }
        return (int) (sumWithMissingElem - sumWithoutMissingElem);
    }

    static int frogJump(int X, int Y, int D) {
        return (Y - X) / D + ((Y - X) % D == 0 ? 0 : 1);
    }
}
