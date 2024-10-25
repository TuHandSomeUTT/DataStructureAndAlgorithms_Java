public class Main {
    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList();
        ll.addFirst("Van Tu Nguyen");
        ll.addFirst("Anh Tuan Nguyen");
        ll.addLast("Viet Nam");
        ll.insertAfter("Viet Nam", "Vô Địch");
        ll.traverse();

        System.out.println("-----------");
        System.out.println(ll.remove("Viet Nam") ? "Xóa Thành Công" : "Xóa Thất Bại");
        System.out.println(ll.size());
        ll.traverse();
    }

}
