import java.util.Random;

public class BaiTapVeMangHaiChieu {
//  Bài tập nhân 2 ma trận

//  Element quantity of array
    int n;

//  Initialize two dimensional array
    int [][] matrixA, matrixB;

// Contructor
    public BaiTapVeMangHaiChieu(int n){
        this.n = n;
        matrixA = new int[n][n]; // Khởi tạo mảng 2 chiều với n hàng và n cột
        matrixB = new int[n][n]; // Như trên
        initValue();
    }

    public void initValue(){
        // Vòng for bên ngoài để duyệt qua tất cả các hàng, vòng for bên trong để duyệt qua tất cả các cột trong mảng
        Random rd = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrixA [i][j] = rd.nextInt(10);
                matrixB [i][j] = rd.nextInt(10);
            }
        }
    }
// Hai phương thức này đã được giải trong vở web-php, giải bằng tay một cách bài bản, mở lại để xem nếu quên nhé
    public void printMatrix(int [][]matrix){
        System.out.println("Matrix: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("------");
    }

// Phương thức cộng hai ma trận
    public int[][] sumMatrix(){
        // Cần có 1 mảng sum
        int [][] matrixSum = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrixSum[i][j] = matrixA[i][j] + matrixB[i][j];
                /*
                 * i = 0; i < n => TM => Tiến vào vòng for con
                 * j = 0; j < n => TM => Tiến vào thân vòng for
                 * matrixSum[i][j] = matrixA[i][j] + matrixB[i][j];
                 * nghĩa là matrixSum[0][0] = matrixA[0][0] + matrixB[0][0]
                 * ma trận Sum tại hàng thứ 0, cột thứ 0 sẽ bằng ma trận A + ma trận B tại hàng thứ 0 và cột thứ 0
                 * tạo ra matrixSum để chứa kết quả cộng của hai mảng matrixA và matrixB
                 * Cộng ma trận chỉ đơn giản là lấy vị trí hàng, cột của ma trận a cộng với vị trí hàng, cột của ma trận B lại với nhau (Đang xét ở ma trận cùng cấp)
                 */
            }
        }
        return matrixSum;
    }
// Phương thức nhân hai ma trận(Phương thức này mới là khoai chó nè)
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

    public void printMatrixA(){
        printMatrix(matrixA);
    }

    public void printMatrixB(){
        printMatrix(matrixB);
    }

    public static void main(String[] args) {
        BaiTapVeMangHaiChieu m = new BaiTapVeMangHaiChieu(3);
        m.printMatrixA();
        m.printMatrixB();
//        System.out.println("A + B = ");
//        m.printMatrix(m.sumMatrix());
        System.out.println("Multiply Matrix: ");
        m.printMatrix(m.multiplyMatrix());
    }
}
