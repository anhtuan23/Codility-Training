import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int[] A1 = new int[]{3, 4, 5, 4};//2
        int[] A2 = new int[]{4, 5, 2, 3, 4};//0
        int[] A3 = new int[]{1, 2, 1, 3, 4, 5};//2
        int[] A4 = new int[]{2, 1, 3, 4, 5};//2
        int[] A5 = new int[]{3, 1, 5, 9, 10};//2
        int[] A6 = new int[]{3, 1, 2, 9, 10};//1
        int[] A7 = new int[]{1, 2, 3, 1, 2, 9, 10};//0
        int[] A8 = new int[]{4, 5, 2, 3, 4};//0
        System.out.print(RealTest.cutTrees(A8));
    }


    private static int[] randomFill(int n, int X) {
        int[] arr = new int[n];
        Random rand = new Random();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(X) + 1;
        }

        return arr;
    }
}
