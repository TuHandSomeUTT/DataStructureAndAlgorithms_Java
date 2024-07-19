import java.util.Random;
import java.util.Scanner;

public class BaiTapVeMangMotChieu {
    // Khai báo mảng số thực
    float a[];
    // Số lượng phần tử trong mảng
    int n;

    // Constructor
    public BaiTapVeMangMotChieu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào số lượng phần tử của mảng: ");
        n = sc.nextInt();
        a = createFloatArray(n);
        printArray();
    }

    // 1) Viết phương thức in ra mảng
    private void printArray() {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " | ");
        }
    }

    // 2) Viết phương thức trả về mảng số thực gồm n phần tử ngẫu nhiên (Tạo mảng -> Đi từng phần tử -> Gán cho nó một giá trị ngẫu nhiên -> Trả về mảng)
    private float[] createFloatArray(int n) {
        Random rd = new Random();
        float temp[] = new float[n];
        for (int i = 0; i < n; i++) {
            temp[i] = rd.nextFloat();
        }
        return temp;
    }

    // 3) Thêm một phần tử x vào cuối mảng
    private void AddElementInTheLastOfArray(float x) {
        // Mảng a ban đầu(ví dụ có 5 phần tử): | 1 | 2 | 3 | 4 | 5 |
        // Bước 1: Phải tăng giá trị n lên để mở rộng mảng
        n = n + 1;
        // Bước 2: Tạo 1 mảng tạm có giá trị phần tử = với giá trị n mới
        // Mảng tạm khi này sẽ trông như sau: |  |  |  |  |  |  | (Có 5 phần tử trong mảng, tính từ 0 đến n)
        float[] temp = new float[n];
        // Bước 3: Copy dữ liệu từ mảng cũ sang mảng mới
        // Khi này mảng tạm sẽ trông như sau: | 1 | 2 | 3 | 4 | 5 |  | (Còn trống 1 vị trí cuối vì nó chưa được gán giá trị)
        for (int i = 0; i < a.length; i++) {
            temp[i] = a[i];
        }
        // Bước 4: Thêm x vào cuối mảng (thêm vào vị trí thứ n-1 vì mảng bắt đầu từ 0 và kết thúc tại vị trí thứ n-1)
        // Khi này mảng tạm sẽ trông như sau: | 1 | 2 | 3 | 4 | 5 | x |
        temp[n-1] = x;
        // Bước 5: Gán lại cho mảng a (Mảng a là mảng ta đang làm việc)
        a = temp;
    }
// 4) Cộng hai phần tử đầu tiên trong mảng lại với nhau
    private void printSum2Element(){
        float sum = 0;
        for (int i = 0; i < 2 && i < a.length; i++) {
            sum += a[i];
        }
        System.out.println("a[0] : " + a[0] + " + " + "a[1] : " + a[1] + " = " + sum);
    }
// 5) Cộng tất cả các phần tử có trong mảng lại với nhau (Tính tổng mảng).
// Đặt tổng ban đầu = 0, duyệt qua tất cả các phần tử trong mảng
// Tại mỗi phần tử trong mảng a ta cộng nó vào sum, đầu tiên sum = 0, sau đó 0 + với giá trị thứ nhất
// Tiếp tục lặp rồi lại cộng phần tử tiếp theo vào sum, cứ lặp đi lặp lại cho đến khi giá trị i lớn hơn hoặc = chiều dài của mảng -> stop
    private void sumAllElementInArray(){
        float sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum+=a[i];
        }
        System.out.println("Sum of all element: " + sum);
    }
// 6) Tìm giá trị min trong mảng. Cách làm: Khởi tạo 1 biến min tại vị trí thứ a[0], duyệt qua tất cả các phần tử trong mảng
// Nếu min > a[i] thì gán a[i] cho min luôn (min = a[i])
    private void detectedMin(){
        float min = a[0];
        for (int i = 0; i < a.length; i++) {
            if (min > a[i]){
                min = a[i];
            }
        }
        System.out.println("Min = " + min);
    }
// 7) In ra giá trị ngẫu nhiên index < n (tức là số ngẫu nhiên này chỉ giới hạn nằm bên trong mảng thôi, cũng có thể hiểu là
// index < a.length - 1, khi random ra giá trị nó sẽ không vượt ra ngoài khoảng a.length - 1)
    public void printRandomLessThanN(){
        Random rd = new Random();
        int index = rd.nextInt(a.length - 1);
        System.out.println("Random index: " + " A[" + index + "] = " + a[index]);
    }

    public static void main(String[] args) {
        BaiTapVeMangMotChieu bt = new BaiTapVeMangMotChieu();
        bt.AddElementInTheLastOfArray(1.5f);
        System.out.println();
        bt.printArray();
        System.out.println();
        bt.printSum2Element();
        bt.sumAllElementInArray();
        System.out.println();
        bt.detectedMin();
        bt.printRandomLessThanN();

        // Dùng Array Initializer để khởi tạo một mảng với các giá trị là: 3.5, 5.5, 4.52, 5.6
        float arr[] = {3.5f, 5.5f, 4.52f, 5.6f};
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " | ");
        }
    }
}
