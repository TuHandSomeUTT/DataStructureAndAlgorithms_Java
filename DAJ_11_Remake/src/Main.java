//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        StudentMS sms = new StudentMS();

        Student sv1 = new Student("1","Hưng", 22, 8.0f);
        Student sv2 = new Student("2","Tấn", 21, 8.0f);
        Student sv3 = new Student("3","Hoàng", 21, 8.0f);
        Student sv4 = new Student("4","Đạt", 20, 8.0f);
        Student sv5 = new Student("5","Tú", 21, 9.9f);

        sms.addItem(sv1);
        sms.addItem(sv2);
        sms.addItem(sv3);
        sms.addItem(sv4);
        sms.addItem(sv5);

        System.out.println("-----Add------");
        sms.printList();

        System.out.println("---Find---");
        Student sv6 = new Student("5","Tú", 21, 9.9f);
        sms.find(sv6);

        System.out.println("---Update---");
        Student sv7 = new Student("5","Văn Tú Nguyễn", 21, 9.9f);
        sms.update(sv7);
        sms.printList();

        System.out.println("---Count by name---");
        Student sv8 = new Student("6","Văn Tú Nguyễn", 21, 9.9f);
        sms.addItem(sv8);
        sms.count("Văn Tú Nguyễn");
        System.out.println("Test sinh viên có cùng tên " + sv8.getFullName() + " là: " + sms.count("Văn Tú Nguyễn"));

        System.out.println("---Size---");
        System.out.println("Size of list: " + sms.size());
    }
}