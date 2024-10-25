public class Tester {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst("Van Tu Nguyen");
        ll.addFirst("Van Tu");
        ll.addFirst("Tu Nguyen");

        ll.addLast("VietNamse");
        ll.insertAfter("Van Tu", "Dep Trai");
        ll.traverse();

        System.out.println("---------");
        System.out.println(ll.deleteNode("Van Tu")); //True
        System.out.println(ll.deleteNode("Van Tu1")); //False
        ll.traverse();

        System.out.println("Check empty: " + ll.isEmpty());
        System.out.println("Linked List Size: " + ll.size());
    }
}
