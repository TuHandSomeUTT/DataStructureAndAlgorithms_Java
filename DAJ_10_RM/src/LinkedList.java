public class LinkedList<T> {
    private Node<T> head;

    public LinkedList(){
        this.head = null;
    }

    // 1) Duyệt qua từng phần tử trong linked list
    public void traverse(){
        Node<T> tmp = this.head; // gán node đầu tiên vào biến tạm
        while(tmp != null){ // Nếu biến tạm có giá trị
            System.out.println(tmp.getData().toString()); // In ra giá trị node hiện thời
            tmp = tmp.getNext(); // Cho biến tạm next sang một node khác và cứ thế là có 1 linkedlist
        }
    }

    /* 2) Thêm 1 nút mới vào đầu danh sách.
    * B1: Tạo 1 node mới và set tham chiếu next của nó trỏ đến head
    * B2: Set head trỏ vào node mới này*/
    public void addFirst(T item){
        // Bước 1:
        /* Node<T> newNode = new Node<>(item, this.head); Cách 1
         Data của node sẽ là data người dùng nhập, next của node sẽ là head
         Cách 2:*/
        Node<T> newNode = new Node<>();
        newNode.setData(item);
        newNode.setNext(this.head);

        // Bước 2
        this.head = newNode;
    }

    /* 3) Thêm 1 node vào cuối danh sách
    * B1: Thêm 1 node mới và set next cho nó trỏ tới null
    * B2: Duyệt qua danh sách và dừng lại tại node cuối cùng
    * B3: Set next của node cuối cùng cho nó trỏ đến new node*/
    public void addLast(T items){
        if (this.head == null){
            addFirst(items);
        } else {
            // Bước 1: Tạo 1 node mới và set next cho nó là null vì phần tử cuối cùng sẽ không có node nào sau nữa(còn mỗi null)
            Node<T> newNode = new Node<>(items, null);

            // Bước 2:
            Node<T> temp = this.head; // Gán vị trí head cho node tạm để nó không ảnh hưởng đến node head
            while(temp.getNext() != null){ // Khi mà next của node tạm còn phần tử nào khác ngoài null thì nó tiếp tục next cho đến khi phía trước nó là null thì dừng
                temp = temp.getNext();
            }

            // Bước 3:
            temp.setNext(newNode);
        }
    }

    /* 4) Chèn 1 phần tử sau 1 node bất kỳ
    * B1: Duyệt qua danh sách liên kết để tìm nút chứa key
    * B2: Khi tìm thấy nút chứa key, tạo 1 nút mới chứa dữ liệu muốn chèn
    * B3: Set con trỏ của nút đứng trước nút trước key và cho nút đó trỏ vào new node và new node sẽ trỏ đến nút chứa key*/
    public void insertAfter(T key, T toInsert){
        Node<T> temp = this.head; // Bước 1: Đi tìm key node
        /* Tìm node chứa key. Khi mà list không rỗng và không tìm thấy key người dùng truyền vào thì tiếp tục next */
        while (temp != null && !temp.getData().equals(key)){
            temp = temp.getNext();
        }
        /* Lặp xong sẽ có 2 trường hợp. 1 là tìm thấy và 2 là không tìm thấy thì nó sẽ chạy đến cuối list*/
        if (temp != null){
            // Bước 2: Tạo 1 nút mới chứa dữ liệu muốn chèn
            Node<T> newNode = new Node<>(toInsert, temp.getNext());
            /* Node mới sẽ nhận dữ liệu là cái người dùng truyền vào và node next của nó là node phía sau node key ta tìm thấy
            * Có nghĩa là ta sẽ nối next của new node vào note phía sau của node key và node key sẽ nối với new node */

            // Bước 3:
            temp.setNext(newNode);
        }
    }

    /* 5) Xóa 1 nút: Nhận vào 1 key, chạy từ đầu cho đến cuối list để tìm key.
     +) Nếu node cần xóa nằm ngay ở đầu thì chỉ cần set head của list là vị trí sau node head hiện tại(head.getNext) và node head
    ban đầu sẽ tự bị xóa đi
     +) Trường hợp còn lại thì sẽ đi tìm key, nếu tìm thấy thì ta set vị trí trước của key trỏ đến node sau của node key.
     Tự động node key sẽ bị xóa khỏi list
     */
    public boolean delete(T key){
        // TH 1: Không có node nào trong list
        if (head == null){
            System.out.println("Can not delete");
            return false;
        }

        // TH2: Khi node head(đầu tiên) là node cần xóa
        if (head.getData().equals(key) == true){
            this.head = head.getNext();
            return true;
        }

        // TH3: Tìm thấy key nằm trong list
        Node<T> prev = null;
        Node<T> cur = head;

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
        // Cách 1:
//        if (this.head == null){
//            return true;
//        }else{
//            return false;
//        }
        // Cách 2:
        return this.head == null;
        // Tức là: Khi nào thì list rỗng? Khi head==null thì khi đó list rỗng. Mà phép so sánh thì mặc định trả về true hoặc false rồi.
    }

    /* 7) Kiểm tra số lượng phần tử của list. Tạo 1 biến count và mỗi lần duyệt qua 1 phần tử trong list, ta thực hiện tăng count lên
    * 1 đơn vị, duyệt xong trả về số lượng phần tử*/
    public int size(){
        int count = 0;
        Node<T> tmp = this.head;
        while (tmp != null){
            count++;
            tmp = tmp.getNext();
        }
        return count;
    }

}