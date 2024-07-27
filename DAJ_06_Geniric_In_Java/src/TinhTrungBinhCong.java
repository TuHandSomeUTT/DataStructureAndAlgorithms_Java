public class TinhTrungBinhCong {
    public static <T> double sumAverage(T[] arr) {
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            double value = Double.valueOf(arr[i] + "");
            sum += value;
        }
        return sum/arr.length;
    }

    // Phương thức tính trung bình cộng giới hạn với các số
    public static <T extends Number> double sumAverage2(T[] arr){
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            double value = Double.valueOf(arr[i] + "");
            sum += value;
        }
        return sum / arr.length;
    }

    public static void main(String[] args) {
        Integer intArr[] = {5, 10, 15};
        System.out.println("Tổng Trung Bình Cộng Của Mảng Integer: " + sumAverage(intArr));

        Float[] floatArr = {1.5f, 4.5f};
        System.out.println("Tổng Trung Bình Cộng Của Mảng Float: " + sumAverage(floatArr));

        Double[] doubleArr = {1.5, 4.5, 6.0};
        System.out.println("Tổng Trung Bình Cộng Của Mảng Double: " + sumAverage(doubleArr));

        /*
        String[] arrString = {"1.5", "4.5", "6.0"};
        System.out.println("Tổng Trung Bình Cộng Của Mảng String: " + sumAverage2(arrString));
        Chương trình báo lỗi do phương thức sumAverage2 chỉ được giới hạn ở class Number, khi truyền String và nó không hiểu được
         */

        String[] arrString = {"1.5", "4.5", "6.0"};
        System.out.println("Tổng Trung Bình Cộng Của Mảng String: " + sumAverage(arrString));
        // Khi áp dụng nó với phương thức không giới hạn kiểu thì OK
    }
}
