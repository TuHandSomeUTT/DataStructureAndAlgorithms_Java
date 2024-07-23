import java.util.Random;

public class TwoDimensionalArrayInJava {
    int n; // Element quantity of array
    int [][] matrixA, matrixB; // Initialize MatrixA and MatrixB(Two dimensional array)

    public TwoDimensionalArrayInJava(int n){
        this.n = n;
        matrixA = new int[n][n]; // Initialize matrixA include n rows and n columns
        matrixB = new int[n][n];
        initValue();
    }

    public void initValue(){
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
        int[][] matrixSum = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrixSum[i][j] = matrixA[i][j] + matrixB[i][j];
                /* Đầu tiên cần hiểu matrixSum (đây giống như một bình chứa)
                * Đoạn này hiểu đơn giản là: Tại hàng thứ i, cột thứ j của matrixSum
                * Lấy giá trị của ma trận A tại vị trí thứ i, cột j và cộng cho ma trận B tại vị trí thứ i, cột j
                * Cuối cùng được kết quả bao nhiêu lại gán nó cho matrixSum
                */
            }
        }
        return matrixSum;
    }

    public int[][] multiplyMatrix(){
        int [][] matrixResult = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrixResult[i][j] = 0;
                for (int k = 0; k < n; k++) {
                    matrixResult[i][j] += (matrixA[i][k] * matrixB[k][j]);
                }
            }
        }
        return matrixResult;
    }

    public static void main(String[] args) {
        TwoDimensionalArrayInJava arr = new TwoDimensionalArrayInJava(3);
        arr.printMatrixA();
        arr.printMatrixB();
//        System.out.println(" Matrix A + Matrix B = ");
//        arr.printMatrix(arr.sumMatrix());
        System.out.println("Matrix A * Matrix B = ");
        arr.printMatrix(arr.multiplyMatrix());
    }
}
