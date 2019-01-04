class RealTest {
    static int cutTrees(int[] A) {
        if (A.length <= 2) {
            return A.length;
        }
        int cuttables = A.length;
        for (int i = 0; i < A.length - 2; i++) {
            if (A[i] > A[i + 1]) {//there is a drop
                if (A[i + 2] < A[i] && A[i + 2] < A[i + 1]) {
                    cuttables = 0;
                } else if (A[i + 2] < A[i]) {
                    cuttables = 1;
                } else {
                    cuttables = 2;
                }
            }
        }
        //for the 2 last tree, min length must be 3
        if (A[A.length - 1] >= A[A.length - 2]) {
            cuttables = 2;
        } else if (A[A.length - 1] >= A[A.length - 3]) {
            cuttables = 2;
        } else if (A[A.length - 1] < A[A.length - 2]){
            cuttables = 1;
        }
        return cuttables;
    }
}
