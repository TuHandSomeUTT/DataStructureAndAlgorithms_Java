public class Tester {
    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<>();

        ll.addFrist("Van Tu Nguyen");
        ll.addFrist("Data Structure And Algorithm");
        ll.addFrist("Tu HandSome");

        /*
        * LinkedList của ta tạo ra in theo cơ chế Last In First Out (LIFO). Cháu nào vào cuối thì in ra đầu. Do addFrist
        * method của ta cứ add vào đầu List nên cháu nào vào cuối thì cháu đấy sẽ là head
        * Tu HandSome -> Data Structure And Algorithm -> Van Tu Nguyen */

//        ll.traverse();
        ll.addLast("This is a last element");

        ll.insertAfter("Tu HandSome", "After");
        System.out.println(ll.delete("after"));
        System.out.println(ll.delete("After"));
        System.out.println("Null linked list? " + ll.isEmpty());
        System.out.println("Size of ll: " + ll.size());
        System.out.println("------------------");
        ll.traverse();
    }
}
