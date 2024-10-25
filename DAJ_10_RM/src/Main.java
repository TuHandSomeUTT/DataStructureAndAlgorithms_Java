public class Main {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();

        ll.addFirst("Nguyen Van Tu");
        ll.addFirst("Data Structure And Algorithm");
        ll.addFirst("UTT");

        ll.addLast("Nguyen Van Tu HandSome");
        ll.insertAfter("UTT", ".vn");

        System.out.println(ll.delete(".VN"));
        System.out.println(ll.delete(".vn"));
        System.out.println("----------");
        System.out.println("Check is empty: " + ll.isEmpty());
        System.out.println("Số lượng phần tử trong list: " + ll.size());
        ll.traverse();
    }
}
