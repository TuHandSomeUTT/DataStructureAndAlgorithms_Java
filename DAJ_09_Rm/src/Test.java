public class Test {
    public static void main(String[] args) {
        Person p1 = new Person("Van Tu Nguyen", "Poland");
        Person p2 = new Person("Tu Nguyen", "VietNam");
        Person p3 = new Person("Van Tu", "Espana");
        Person p4 = new Person("Adam Nguyen", "Portugal");
        Person p5 = new Person("Leonardo Nguyen", "USA");

        Node<Person> node1 = new Node<>();
        node1.setData(p1);

        Node<Person> node2 = new Node<>();
        node2.setData(p2);

        Node<Person> node3 = new Node<>();
        node3.setData(p3);

        Node<Person> node4 = new Node<>();
        node4.setData(p4);

        Node<Person> node5 = new Node<>();
        node5.setData(p5);

        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);

        Node<Person> next = node1;
        while(true){
            System.out.println(next.getData());
            next = next.getNext();
            if (next == null) break;
        }
    }
}
