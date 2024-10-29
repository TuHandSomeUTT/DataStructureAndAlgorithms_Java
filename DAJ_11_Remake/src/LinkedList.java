public class LinkedList<T> {
    private Node<T> head;

    public LinkedList() {
        this.head = null;
    }

    //1) In ra các giá trị trong list
    public void traverse() {
        Node<T> tmp = this.head;
        while (tmp != null) {
            System.out.println(tmp.getData());
            tmp = tmp.getNext();
        }
    }

    /*2) Thêm 1 nút mới vào đầu danh sách
     * B1: Tạo 1 node mới và set tham chiếu next của nó trỏ đến head
     * B2: Set head trỏ vào node mới này*/
    public void addFirst(T item) {
//        Node<T> newNode = new Node<>(item, this.head);
        Node<T> newNode = new Node<>();
        newNode.setData(item);
        newNode.setNext(this.head);
        this.head = newNode; // Cho newNode làm head thì sẽ đúng với đề bài là chèn 1 node vào đầu LL
    }

    /* 3) Thêm 1 node vào cuối danh sách
     * B1: Thêm 1 node mới và set next cho nó trỏ tới null
     * B2: Duyệt qua danh sách và dừng lại tại node cuối cùng
     * B3: Set next của node cuối cùng cho nó trỏ đến new node*/
    public void addLast(T item) {
        if (this.head == null) {
            addFirst(item);
        } else {
            Node<T> newNode = new Node<>(item, null);
            Node<T> tmp = this.head;
            while (tmp.getNext() != null) {
                tmp = tmp.getNext();
            }
            tmp.setNext(newNode);
        }
    }

    /* 4) Thêm vào phía sau 1 node
     * B1: Khởi tạo 1 node mới
     * B2: Set next của node mới là node tiếp theo của node hiện tại
     * B3: Set next của node hiện tại cho nó nối vào newNode.*/
    public void insertAfter(T key, T toInsert) {//key là node mà ta cần chèn node mới vào phía sau nó, toInsert là node mà ta muốn thêm vào
        // B2: Đi tìm vị trí của key
        Node<T> tmp = this.head;
        // Đi tìm node chứa key
        while (tmp != null && !tmp.getData().equals(key)) {
            // Khi node tạm khác null và node tạm không tìm được key thì tiếp tục next cho đến khi gặp thì break ra khỏi while
            tmp = tmp.getNext();
        }
        // Khi out ra khỏi while thì sẽ xảy ra 1 trong 2 tình huống: là tmp == null hoặc là tìm thấy key
        if (tmp != null) {
            /* Bước 1: Khi này mới tạo node mới, nếu ta tạo node mới ngay từ đầu mà không tìm thấy key thì node đó sẽ không
             * được chèn vào, gây ra sự dư thừa và lãng phí.*/
            Node<T> newNode = new Node<>(toInsert, tmp.getNext()); //node mới này data sẽ do người dùng nhập vào và next của nó là node tiếp theo của node key
            tmp.setNext(newNode);
        }
    }

    /* Xóa một node*/
    public boolean remove(T key){
        if (this.head == null){
            System.out.println("You can't delete it");
            return false;
        } else{
            if (this.head.getData().equals(key)){ // Nếu node ta cần xóa ở đầu linked list
                this.head = this.head.getNext(); // Chỉ cần set next làm node khác là tự khắc node ban đầu sẽ bị loại bỏ
                return true;
            } else {
                // Tạo biến tạm
                Node<T> prev = null;
                Node<T> cur = this.head;

                // Đi tìm key để xóa
                while (cur != null && !cur.getData().equals(key)){
                    prev = cur;
                    cur = cur.getNext();
                }
                if (cur == null){
                    throw new RuntimeException("Can not delete it");
                } else {
                    prev.setNext(cur.getNext());
                }
            }
        }
        return true;
    }

    /* 6: isNull*/
    public boolean isNull(){
        return this.head == null;
        /*Giải thích: Khi nào LL rỗng? Khi mà this.head == null. Mà phép so sánh thì mặc trả về true or false rồi*/
    }

    public int size(){
        Node<T> tmp = this.head;
        int count = 0;
        while(tmp != null){
            count++;
            tmp = tmp.getNext();
        }
        return count;
    }

    /* Tim 1 phan tu trong list. Cho 1 vong lap duyet qua list. Neu phan tu do bang voi item ta can tim thi in no ra.
     * Neu khong trung thi tiep tuc next*/
    public boolean find(Student student){
        Node<T> tmp = this.head;
        while(tmp != null){
            if (tmp.getData().equals(student)){
                System.out.println("Đã tìm thấy phần tử");
                return true;
            }
            tmp = tmp.getNext();
        }
        System.out.println("Không tìm thấy phần tử");
        return false; //Di tu dau den cuoi ma khong tim thay thi return false
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }
}
