public class Test {
    public static void main(String[] args) {
        Person p1 = new Person("Van Tu Nguyen", "France");
        Person p2 = new Person("Nguyễn Văn Tú", "Việt Trì");
        Person p3 = new Person("Adam Nguyen", "Spain");
        Person p4 = new Person("Leonardo Nguyen", "Mexico");
        Person p5 = new Person("Tu HandSome", "Wales");

        p1.setNext(p2);
        p2.setNext(p3);
        p3.setNext(p4);
        p4.setNext(p5);

        Person currently = p1;
        while(true){
            System.out.println(currently);
            currently = currently.getNext();
            if (currently == null) break;
        }
    }
}
