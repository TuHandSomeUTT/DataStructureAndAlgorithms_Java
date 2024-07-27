public class SumAvg {

    public static <T> double sumAvg(T []arr){
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            double value = Double.valueOf(arr[i] + "");//cần ép kiểu về string để tránh lỗi
            sum += value;
        }
        return sum/arr.length;
    }

    public static void main(String[] args) {
        Integer intArr[] = {5, 10, 15};
        System.out.println("Trung bình cộng mảng số nguyên: " + sumAvg(intArr));

        Float floatArr[] = {5f, 10f, 15f};
        System.out.println("Trung bình cộng mảng số thực: " + sumAvg(floatArr));

        String stringArr[] = {"5", "10", "20"};
        System.out.println("Trung bình cộng mảng String: " + sumAvg(stringArr));
    }
}
