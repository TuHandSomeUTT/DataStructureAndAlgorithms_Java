public class LinkedList<T> {
    private Node<T> head;

    public LinkedList() {
        this.head = null;
    }

    // Traverse method
    public void traverse() { //traverse: trəˈvərs: đi qua, duyệt qua
        Node<T> temp = head;
        while (temp != null) {
            System.out.println(temp.getData());
            // Chuyen den phan tu tiep theo
            temp = temp.getNext();
            if (temp == null) break;
        }
    }

    /* Add node in linked list. Ideal:
     *  Create a new node, set tham chiếu của nút mới này cho nó trỏ đến head
     *  Set head để head trỏ đến nút mới này
     */

    public void addFrist(T item) {
        // Bước 1: Cách 1
        // Node<T> newNode = new Node<>(item, this.head);
        /* Đoạn này có nghĩa là: tham số item kia là data người dùng nhập, tham số thứ 2 là để thiết lập tham chiếu
         node mới này cho nó trỏ tới head (để set nó làm node head luôn)
         */
        // Cách 2: 3 dòng này tương đương 1 dòng bên trên
        Node<T> newNode = new Node<>(); // Tạo node mới
        newNode.setData(item); // Thiết lập data cho node là data người dùng nhập vào
        newNode.setNext(this.head); // Thiết lập tham chiếu next cho node này trỏ đến head

        // Bước 2: Gán newNode = head. Thiết lập head trỏ đến node mới này
        this.head = newNode;
    }

    /* Thêm một phần tử vào cuối linked list
     * B1: Create an new node, gán tham chiếu next của node này trỏ đến đối tượng null
     * B2: Duyệt qua danh sách và dừng lại tại node cuối cùng
     * B3: Set tham chiếu next của nút cuối cùng trỏ đến new node
     * */
    public void addLast(T item) {
        if (head == null) {
            addFrist(item);
        } else {
            // B1: Create an new node, gán tham chiếu next của node này trỏ đến đối tượng null
            Node<T> newNode = new Node<>(item, null);
        /* 3 this line tương đương 1 line above
        Node<T> newNode = new Node<>();
        newNode.setData(item);
        newNode.setNext(null);
        */
            // B2: Duyệt qua danh sách và dừng lại tại node cuối cùng
            Node<T> tmp = head; //Tạo 1 node tạm và cho nó chaỵ từ đầu danh sách
            while (tmp.getNext() != null){ //Khi mà phía sau nó còn node nào (Tức là nó khác null) thì ta next cho đến khi gặp the last node (Node cuối cùng là node mà sau nó trỏ vào null)
                tmp = tmp.getNext();
            } // Next cho đến khi nào gặp node mà next của nó là null thì điều kiện sai -> Thoát khỏi while
            // B3: Cài tham chiếu của node cuối này trỏ đến nút mới ta vừa tạo (Nút ta vừa tạo đã gán sẵn phía sau là null rồi nha)
            tmp.setNext(newNode);
        }
    }

    /* Chèn một phần tử sau một nút: Tìm nút chứa key và chèn 1 nút mới sau nút đó, nút mới sẽ trỏ đến nút tiếp theo
    B1: Duyệt qua linked list để tìm nút chứa khóa
    B2: Khi tìm thấy nút chứa khóa, cần tạo 1 nút mới chứa data mình muốn chèn
    B3: Điều chỉnh con trỏ của nút trước nút chứa "khóa" để trỏ đến nút mới và nút mới trỏ đến nút chứa khóa
    */
    public void insertAfter(T key, T toInsert){
        // B1: Duyệt qua linked list để tìm nút chứa khóa
        Node<T> tmp = head; //Tạo ra biến temp chứa head để tránh làm ảnh hưởng tới nút head ban đầu của linked list
        // Tìm node chứa key
        while (tmp != null && !tmp.getData().equals(key)){ //Đoạn này hiểu là khi mà head(tmp) nó có phần tử trong list và đồng thời không tìm thấy phần tử chứa key thì
            tmp = tmp.getNext(); //thì tiếp tục next
        }
        /* Khi mà 1 trong 2 điều kiện trên bị vi phạm thì ctrinh sẽ đi xuống dưới
        * Sau khi thực hiện xong while sẽ xảy ra 2 trường hợp:
        * 1 là tìm ra được node chứa key
        * 2 là không có ông nào trong list giống với key thì nó vẫn đúng điều kiện !tmp.getData().equals(key) và next liên tục cho đến khi gặp phần tử cuối cùng*/

        // Thực hiện chèn vào vị trí bất kỳ khi linked list khác rỗng
        if (tmp != null){
            // 1) Cần khởi tạo 1 node mà người dùng nhập vào để tránh trường hợp số 2 là không có key nào trùng với nó thì nó sẽ không biết thêm vào đâu
//            Node<T> newNode = new Node<>();
//            newNode.setData(toInsert);
//
//            // 2)
//            newNode.setNext(tmp.getNext());

            // Hoặc
            Node<T> newNode = new Node<>(toInsert, tmp.getNext());

            // 3)
            tmp.setNext(newNode);
        }
    }

    /* Xóa 1 node trong list*/
    public boolean delete(T key){
        // TH 1: Không có node nào trong list
        if (this.head == null){
            System.out.println("Can not delete");
            return false;
        }

        // TH2: Khi node head(đầu tiên) là node cần xóa
        if (this.head.getData().equals(key)){
            this.head = head.getNext();
            return true;
        }

        // TH3: Node cần xóa không nằm ở đầu
        Node<T> prev = null;
        Node<T> cur = this.head;

        while (cur != null && !cur.getData().equals(key)){
            prev = cur;
            cur = cur.getNext();
        }

        // Di chuyển cả 2 node cho đến khi xuống cuối list hoặc đã tìm thấy node có data trùng với key
        if (cur == null){
            System.out.println("Can not delete");
            return false;
        }

        // tìm được node key thì ta sẽ lấy node đứng trước node key và trỏ tới node sau node key là node cur sẽ bị xóa
        prev.setNext(cur.getNext());
        return true;
    }

    /* 6) Kiểm tra xem list có bị rỗng hay không*/
    public boolean isEmpty(){
        return this.head == null;
    }

    /* 7) Kiểm tra số lượng phần tử của list. Tạo 1 biến count và mỗi lần duyệt qua 1 phần tử trong list, ta thực hiện tăng count lên
     * 1 đơn vị, duyệt xong trả về số lượng phần tử*/
    public int size(){
        int count = 0;
        Node<T> tmp = this.head;
        while(tmp != null){
            count ++;
            tmp = tmp.getNext();
        }
        return count;
    }
}
