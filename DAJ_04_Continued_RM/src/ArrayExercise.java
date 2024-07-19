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

    float a[];
    int n;
    public ArrayExercise(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào số lượng phần tử của mảng: ");
        n = sc.nextInt();
        a = randomArray(n);
        printArray();
    }

//    0) Viết phương thức in ra mảng
    private void printArray(){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " | ");
        }
    }

//    1) Viết phương thức để trả về một mảng số thực gồm n phần tử
    private float[] randomArray(int n){
        Random rd = new Random();
        float temp[] = new float[n];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = rd.nextFloat();
        }
        return temp;
    }

//    2) Viết phương thức để gán giá trị x cho phần tử cuối cùng
    private void addElementInTheLastOfArray(float x){
        n+=1;

        float temp[] = new float[n];

        for (int i = 0; i < a.length; i++) {
            temp[i] = a[i];
        }

        temp[n-1] = x;

        a = temp;
    }

//    3) Viết phương thức trả về tổng của 2 phần tử đầu tiên
    private void sum2ElementInArray(){
        float sum = 0;
        for (int i = 0; i < 2 && i < a.length; i++) {
            sum+=a[i];
        }
        System.out.println("Sum: a[0] : " + a[0] + " + " + "a[1] : " + a[1] + " = " + sum);
    }

//    4) Viết phương thức sử dụng vòng lặp tính tổng tất cả phần tử trong mảng
    private void sumAllElementInArray(){
        float sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum+=a[i];
        }
        System.out.println("Sum: " + sum);
    }

//    5) Viết phương thức dùng vòng lặp để tìm min
    private void detectedMinValue(){
        float min = a[0];

        for (int i = 0; i < a.length; i++) {
            if (min > a[i]){
                min = a[i];
            }
        }
        System.out.println("Detected min value: " + min);
    }

//    5.1) Tìm max
    private void detectedMaxValue(){
        float max = a[0];

        for (int i = 0; i < a.length; i++) {
            if (max < a[i]){
                max = a[i];
            }
        }
        System.out.println("Detected max value: " + max);
    }
//    6) Tự động tạo ra một số ngẫu nhiên index < n và hiển thị giá trị của phần tử tại vị trí index
    private void randomIndexLessThanN(){
        Random rd = new Random();
        int index = rd.nextInt(a.length-1);
        System.out.println("Random index value [a" + index + "]" + a[index]);
    }
//    7) Dùng array initializer để tạo 1 mảng với giá trị khởi tạo là 3.5, 5.5, 4.52, 5.6
    public static void main(String[] args) {
        ArrayExercise btm = new ArrayExercise();
        System.out.println();
        btm.addElementInTheLastOfArray(2.5f);
        btm.printArray();
        System.out.println();
        btm.sum2ElementInArray();
        System.out.println();
        btm.sumAllElementInArray();
        System.out.println();
        btm.detectedMaxValue();
        System.out.println();
        btm.detectedMinValue();
        System.out.println();
        btm.randomIndexLessThanN();
        System.out.println();

        float init[] = {3.5f, 5.5f, 4.52f, 5.6f};
        for (int i = 0; i < init.length; i++) {
            System.out.print(init[i] + " | ");
        }
    }
}
