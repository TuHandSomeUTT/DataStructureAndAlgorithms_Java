import java.util.Random;

public class PracticeMakePerfect {
    int n;

    int [][]matrixA, matrixB;

    public PracticeMakePerfect(int n){
        this.n = n;
        matrixA = new int[n][n];
        matrixB = new int[n][n];
        initValue();
    }

    private void initValue() { // hàm này khởi tạo giá trị ngẫu nhiên cho 2 ma trận
        Random rd = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrixA[i][j] = rd.nextInt(10);
                matrixB[i][j] = rd.nextInt(10);
            }
        }
    }

    public void printMatrix(int matrix[][]){
        System.out.println("Matrix: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("------");
    }

    public void printMatrixA(){
        printMatrix(matrixA);
    }

    public void printMatrixB(){
        printMatrix(matrixB);
    }

    public int[][] sumMatrix(){
        int [][] matrixResult = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrixResult[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }
        return matrixResult;
    }

    public int[][] multiplyMatrix(){
        int[][]matrixResult = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrixResult[i][j] = 0;
                for (int k = 0; k < n; k++) {
                    matrixResult[i][j] += (matrixA[i][k]*matrixB[k][j]);
                }
            }
        }
        return matrixResult;
    }

    public static void main(String[] args) {
        PracticeMakePerfect arr = new PracticeMakePerfect(3);
        arr.printMatrixA();
        System.out.println();
        arr.printMatrixB();
//        System.out.println("Matrix A + Matrix B = ");
//        arr.printMatrix(arr.sumMatrix());
        System.out.println("Multiply matrix: ");
        arr.printMatrix(arr.multiplyMatrix());
    }
}
