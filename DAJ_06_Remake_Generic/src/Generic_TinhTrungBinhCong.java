public class Generic_TinhTrungBinhCong {

    public static <T> double tinhTrungBinhCong(T[] arr){
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            double value = Double.valueOf(arr[i] + "");
            sum += value;
        }
        return sum / arr.length;
    }

    public static void main(String[] args) {
        Integer intArr[] = {9, 5, 1, 15};
        System.out.println("Trung bình cộng mảng số nguyên: " + tinhTrungBinhCong(intArr));

        Float floatArr[] = {9f, 5f, 15f, 15f};
        System.out.println("Trung bình cộng mảng số thực: " + tinhTrungBinhCong(floatArr));

        String stringArr[] = {"9", "5", "1", "15"};
        System.out.println("Trung bình cộng mảng string: " + tinhTrungBinhCong(stringArr));
    }
}
