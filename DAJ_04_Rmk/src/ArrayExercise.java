import java.util.Random;
import java.util.Scanner;

public class ArrayExercise {
    /*
0) Viết phương thức in ra mảng
1) Viết phương thức để trả về một mảng số thực gồm n phần tử
2) Viết phương thức để gán giá trị x cho phần tử cuối cùng
3) Viết phương thức trả về tổng của 2 phần tử đầu tiên
4) Viết phương thức sử dụng vòng lặp tính tổng tất cả phần tử trong mảng
5) Viết phương thức dùng vòng lặp để tìm min
6) Tự động tạo ra một số ngẫu nhiên index < n và hiển thị giá trị của phần tử tại vị trí index
7) Dùng array initializer để tạo 1 mảng với giá trị khởi tạo là 3.5, 5.5, 4.52, 5.6
     */

    // Khởi tạo mảng
    float[] a;

    // Số lượng phần tử của mảng
    int n;

    public ArrayExercise() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào số lượng phần tử của mảng: ");
        n = sc.nextInt();
        a = createFloatArray(n);
    }

    // 1)Viết phương thức in ra mảng
    private void printArray() {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " | ");
        }
    }

    // 2)Viết phương thức để trả về một mảng số thực gồm n phần tử
    private float[] createFloatArray(int n) {
        Random random = new Random();
        float[] temp = new float[n];
        for (int i = 0; i < n; i++) {
            temp[i] = random.nextFloat();
        }
        return temp;
    }

    // 3) Viết phương thức để gán giá trị x cho phần tử cuối cùng
    private void addAnElementInTheLastArray(float x){
        n+=1;

        float []temp = new float[n];

        for (int i = 0; i < a.length; i++) {
            temp[i] = a[i];
        }

        temp[temp.length-1] = x; // hoặc tem[n-1] = x cũng ook (do mảng bắt đầu từ 0 và kết thúc tại vị trí thứ n-1), hiểu đơn giản là x sẽ được gán cho vị trí cuối cùng trong mảng

        a = temp;
    }

    // 4) Viết phương thức trả về tổng của 2 phần tử đầu tiên
    private void printSum2Element(){
        float sum = 0;

        for (int i = 0; i < 2 && i < a.length; i++) { // muốn cộng bao nhiêu phần tử thì đặt i < từng đó số
            sum+=a[i];
        }
        System.out.println("Sum = " + "a[0] : " + a[0] + " + " + "a[1] : " + a[1] + " = " + sum);
    }

    // 5) Viết phương thức sử dụng vòng lặp tính tổng tất cả phần tử trong mảng
    private void printSumAll(){
        float sum = 0;

        for (int i = 0; i < a.length; i++) {
            sum+=a[i];
        }

        System.out.println("Sum = " + sum);
    }

    // 6) Viết phương thức dùng vòng lặp để tìm min (Dùng phương pháp đặt cờ tại index đầu tiên, cho chạy qua tất cả các phần tử, phần tử nào nhỏ hơn thì thực hiện gán phần tử index[0] đó cho vị trí index[i])
    private void detectedMinElement(){
        float min = a[0];

        for (int i = 0; i < a.length; i++) {
            if (min > a[i]){
                min = a[i];
            }
        }
        System.out.println("Detected min: " + min);
    }

    // Bonus thêm phương thức tìm max :))))
    private void detectedMaxElement(){
        System.out.println();
        float max = a[0];

        for (int i = 0; i < a.length; i++) {
            if (max < a[i]){
                max = a[i];
            }
        }
        System.out.println("Detected max: " + max);
    }

    // 7) Tự động tạo ra một số ngẫu nhiên index < n và hiển thị giá trị của phần tử tại vị trí index
    private void taoSoNgauNhien(){
        System.out.println();
        Random rd = new Random();
        int index = rd.nextInt(a.length); // đoạn này được hiểu là giá trị index ngẫu nhiên chỉ nằm trong khoảng từ a.length -1
        System.out.println("Random index value: " + "a[ " + index + " ]" + " = " + a[index]);
    }

    public static void main(String[] args) {
        ArrayExercise arr = new ArrayExercise();
        arr.printArray();
        arr.addAnElementInTheLastArray(2.5f);
        System.out.println();
        arr.printArray();
        System.out.println();
        arr.printSum2Element();
        System.out.println();
        arr.printSumAll();
        System.out.println();
        arr.detectedMinElement();
        arr.detectedMaxElement();
        arr.taoSoNgauNhien();

        // 7) Dùng array initializer để tạo 1 mảng với giá trị khởi tạo là 3.5, 5.5, 4.52, 5.6
        float []array = {3.5f, 5.5f, 4.52f, 5.6f};
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
    }
}
