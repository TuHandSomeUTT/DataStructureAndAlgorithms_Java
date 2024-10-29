public class Main {
    public static void main(String[] args) {
        StudentMS sms = new StudentMS();

        Student student1 = new Student("1","Van Tu Nguyen", 21, 9.8f );
        Student student2 = new Student("2","Adam Nguyen", 20, 9.8f );
        Student student3 = new Student("3","Nguyễn Văn Tú", 18, 9.8f );
        Student student4 = new Student("4","Leonardo Nguyen", 19, 9.8f );
        Student student5 = new Student("5","Van Tu", 17, 9.8f );

        sms.addStudent(student1);
        sms.addStudent(student2);
        sms.addStudent(student3);
        sms.addStudent(student4);
        sms.addStudent(student5);

        sms.printList();

        System.out.println("----------");

        //Update sinh viên
        Student s1 = new Student("5","Tú Đẹp Trai", 17, 9.8f);
        sms.update(s1);
        System.out.println("---Update---");
        sms.printList();

        //Test đếm sinh viên có tên là ...
        Student s2 = new Student("6","Tú Đẹp Trai", 19, 9.9f);
        Student s3 = new Student("7","Tú Xinh Trai", 25, 9.9f);
        sms.addStudent(s2);
        sms.addStudent(s3);
        System.out.println("---Add student---");
        sms.printList();
        System.out.println("Test sinh viên có cùng tên " + s2.getFullName() + " là: " + sms.count("Tú Đẹp Trai"));

        //Test remove
        sms.remove(s3);
        System.out.println("---Remove---");
        sms.printList();

        //Đếm số lượng sv trong list
        System.out.println("---Size---");
        System.out.println("Size of linked list: " + sms.size() + " Cháu");
    }
}
