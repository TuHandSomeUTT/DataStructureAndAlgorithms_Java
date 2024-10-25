public class LinkedList <T>{
    private Node<T> head;

    public LinkedList() {
        this.head = null;
    }

//    1) Phương thức duyệt qua từng phẩn tử trong Linked List. In ra data của 1 node rồi tiếp tục next, sau đó tiến hành lặp cho đến khi Linked List null
    public void traverse(){
        Node<T> temp = head;
        while(temp != null){
            // In ra tat ca cac data co trong node
            System.out.println(temp.getData());
            // Move to next element in Linked List
            temp = temp.getNext();
        }
    }

    /* 2) Phương thức add 1 phần tử vào đầu Linked List
    * 1) Thiết lập tham chiếu của node mới cho nó trỏ đến head
    * 2) Thiết lập head trỏ đến node mới này.
    * Hiểu đơn giản thì node mới sẽ nối vào node head cũ, và head sẽ được chuyển sang cho node mới nắm giữ, khi đó node cũ
    * sẽ tự động được hủy làm head mà thay vào đó node mới sẽ được làm head*/
    public void addFirst(T item){
        /* Cách 1:
         Node<T> newNode = new Node<>(item, this.head);
        this.head = newNode;
         * Đoạn này hiểu đơn giản là item tức là data người dùng truyền vào sẽ được lấy làm data của node mới
         * this.head sẽ là node next của node mới này, sau đó gán newNode này cho nó trở head (node đầu)
         */
        /* Cách 2: Vẫn các bước tương tự cách 1
        Bước 1:*/
        Node<T> newNode = new Node<>();
        newNode.setData(item);
        newNode.setNext(this.head);
        // Bước 2: cài đặt newNode làm node head
        this.head = newNode;
    }

    /*
    * Thêm một phần tử vào cuối danh sách:
    * 1) Tạo 1 node mới, gán tham chiếu next của nó trỏ đến null
    * 2) Duyệt qua danh sách và dừng lại ở vị trí cuối cùng
    * 3) Thiết lập tham chiếu next của node cuối cùng để trỏ đến newNode*/

    /*
    public void addLast(T item){
        if(head == null){
            addFirst(item);
        } else {
            // Bước 1: Tạo node mới, data là item người dùng nhập, next node set là null
            Node<T> newNode = new Node<>(item, null);

            // Bước 2: Duyệt qua danh sách và dừng lại ở vị trí kế cuối (vì cuối là null)
            Node<T> temp = head;
            while (temp.getNext() != null){ // Khi nào còn phần tử thì tiếp tục next cho đến khi gặp null thì out
                temp = temp.getNext();
            }
            // Bước 3: Từ node next (đang ở vị trí kế cuối) trỏ đến newNode (Next của new node là null rồi)
            temp.setNext(newNode);
        }
    }
     */

    public void addLast(T item){
        if (head == null){
            addFirst(item);
        } else {
            // Bước 1: Tạo node mới, data là item người dùng nhập, next node set là null
            Node<T> newNode = new Node<>(item, null);

            // Bước 2: Duyệt qua danh sách và dừng lại ở vị trí kế cuối (vì cuối là null)
            Node<T> temp = head;
            while (temp.getNext() != null){
                temp = temp.getNext();
            }

            // Bước 3: Từ node next (đang ở vị trí kế cuối) trỏ đến newNode (Next của new node là null rồi)
            temp.setNext(newNode);
        }
    }

    /*
    Chèn vào sau một node bất kỳ.
    1) Duyệt qua danh sách liên kết để tìm nút chứa khóa
    2) Khi tìm thấy nút chứa khóa, tạo 1 nút chứa dữ liệu bạn muốn chèn
    3) Điều chỉnh con trỏ của nút trước nút chứa khóa để trỏ đến nút mới, và nút mới trỏ đến nút chứa khoóa
     */
    public void insertAfter(T key, T item){
        // Bước 1: Đi tìm vị trí cuả key
        Node<T> temp = head;
        // Bước tìm node chứa key
        while(temp != null && !temp.getData().equals(key)){
            /*
            Tức là muốn tìm key thì điều kiện đầu tiên là LL không được null và khi node hiện tại không trùng key người dùng
            nhập vào thì tiếp tục next
             */
            temp = temp.getNext();
        }
        /*
        Khi thoát khỏi vòng lặp thì sẽ xảy ra 2 trường hợp là:
        1) Tìm ra được node chứa key
        2) Hoặc là đi đến cuối LL mà không tìm ra key trùng với người dùng nhập
        Bài toán đặt ra là ta sẽ phải thêm sau một node chứa key nào đó, nếu ta không tìm thấy thì tức là node temp == null
        là không thể thêm được nhưng nếu nó khác null tức là nó có node đó.
         */
        if (temp != null){ // Thêm vào khi temp <> null
            /* Bước 2: Tạo node mới và set next cho node mới đó là node next của node key ta tìm được. Tức là khi ta tìm thấy key thì
            ta cần chèn new node vào sau key, thì cái node ở đằng sau key lúc đầu nó sẽ được node mới nối vào, nó không được key
            ban đầu nối đến nữa, thay vào đó nó được node mới nối vào, còn key sẽ nối vào node mới
             */

            // Cách viết 1
            //Node<T> newNode = new Node<>(item, temp.getNext());//Chỉ khi nào có phát hiện key thì ta mới tạo node, nếu tạo trước thì trường hợp không tìm thấy key mà vẫn tạo node sẽ dẫn đến code không tối ưu

            // Cách viết 2
            Node<T> newNode = new Node<>();
            newNode.setData(item);
            newNode.setNext(temp.getNext());


            /*Bước 3: Set tham chiếu của node chứa key cho nó nối vào newNode*/
            temp.setNext(newNode);
        }
    }

    /*Hàm xóa node tại vị trí bất kỳ*/
    public boolean deleteNode(T key){
        if(head == null){
            return false;
        }

        /* Nếu key ở vị trí đầu tiên thì chỉ cần set head làm một node tiếp theo và cho nó làm node head và node head cũ sẽ bị xóa đi */
        if(head.getData().equals(key)){
            this.head = head.getNext();
            return true;
        }

        // Tạo biến tạm
        Node<T> previous = null;
        Node<T> current = head;

        /*Xoa o vi tri bat ky. Khi vị trí hiện tại khác null (tức là vẫn có thể đi tiếp) và data của nút hiện tại khác key người dùng nhập*/
        while(current != null && !current.getData().equals(key)){
            // Nút hiện tại nếu nó không phải node ta cần tìm thì tiếp tục next
            previous = current; // Di chuyển node trước cho nó nhảy vị trí lên node hiện tại
            current = current.getNext(); // Node hiện tại thì tiếp tục next
        }
        /*Cứ lặp cho đến khi nào phạm vào 1 trong 2 điều kiện là node hiện tại == null hoặc là node hiện tại bằng với key người
        * dùng nhập vào thì thoát khỏi vòng lặp while*/

        if (current == null){
            return false;
        }

        /*Tức là nếu tìm thấy node cần xóa thông qua key thì ta sẽ set cho node previous nối trực tiếp vào nút phía sau node current
        * có nghĩa là thay vì nối vào node current thì nó nối vào node next của current, bỏ qua node current là lập tức node cur bị
        * biến mất. Phía trước là node pre | giữa là node cur | sau là node next cur | Chỉ cần nối từ pre vào next cur là ở giữa
        * next cur sẽ bị mất*/
        previous.setNext(current.getNext());
        return true;
    }

    /*Kiểm tra xem LL có rỗng không*/
    public boolean isEmpty(){
        /* Cách 1:
        if (head == null){
            return true;
        } else {
            return false;
        } */

        // Cách 2:
        return head == null;
        /*Tức là khi nào Linked List bị null? Là khi head (node đầu) của nó == null thì nó là list rỗng*/
    }

    /*Kiểm tra số lượng của LL*/
    public int size(){
        int count = 0;

        Node<T> temp = head;
        while(temp != null){
            // Tăng giá trị
            count++;
            //Nhảy đến phần tử kế tiếp
            temp = temp.getNext();
        }
        return count;
    }
}
