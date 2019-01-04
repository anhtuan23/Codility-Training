class Chapter5PrefixSums {

    //Somehow this return wrong answer on Codility test with double value,
    //  however I cannot replicate that
    static int passingCars(int[] A) {
        final int firstCar = A[0];
        int numberOfFirstCar = 1;
        long totalPassingCars = A.length - 1;//assumed all of the rest is other car
        for (int i = 1; i < A.length; i++) {
            if (A[i] == firstCar) {
                totalPassingCars -= numberOfFirstCar;//remove from assumption
                numberOfFirstCar++;
                totalPassingCars += A.length - 1 - i;//the rest of unvisited elements
            }
        }
        return totalPassingCars > 1000000000 ? -1 : (int)totalPassingCars;
    }

    //Much Simpler solution
    static int passingCars2(int[] A) {
        int countOfZeros = 0, count = 0;

        for (int a : A) {
            if (a == 0) countOfZeros++;
            if (a == 1) count += countOfZeros;//only these cars cross the passed 0s
            if (count > 1000000000) return -1;
        }
        return count;
    }
}
