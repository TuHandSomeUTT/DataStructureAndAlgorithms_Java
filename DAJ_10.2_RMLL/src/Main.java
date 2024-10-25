//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst("Question number 1");
        ll.addFirst("Number 2");
        ll.addLast("Viet Nam");
        ll.insertAfter("Viet Nam", ".vn");
        System.out.println("------------");
        System.out.println(ll.remove("Number 2") ? "Xóa thành công" : "Xóa thất bại");
        System.out.println(ll.isNull() ? "Linked List rỗng" : "Linked List không rỗng");
        System.out.println(ll.size());
        ll.traverse();
    }
}