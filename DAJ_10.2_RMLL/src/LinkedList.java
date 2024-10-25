import javax.lang.model.type.MirroredTypeException;

public class LinkedList <T>{
    private Node<T> head;

    public LinkedList() {
        this.head = null;
    }

    //1) In ra các giá trị trong list
    public void traverse(){
        Node<T> tmp = this.head; // Gán giá trị head cho newNode -> newNode trở thành node đầu tiên
        while (tmp != null){
            System.out.println(tmp.getData());
            tmp = tmp.getNext();
        }
    }

    /*2) Thêm 1 nút mới vào đầu danh sách
     * B1: Tạo 1 node mới và set tham chiếu next của nó trỏ đến head
     * B2: Set head trỏ vào node mới này*/
    public void addFirst(T item){
        Node<T> newNode = new Node<>(item, this.head);
        this.head = newNode; // Gán newNode cho(là) head thì head sẽ trỏ vào newNode -> newNode sẽ là node đầu trong LL
    }

    /* 3) Thêm 1 node vào cuối danh sách
     * B1: Thêm 1 node mới và set next cho nó trỏ tới null
     * B2: Duyệt qua danh sách và dừng lại tại node cuối cùng
     * B3: Set next của node cuối cùng cho nó trỏ đến new node*/
    public void addLast(T item){
        if (this.head == null){
            addFirst(item);
        } else {
            Node<T> newNode = new Node<>(item, null);
            Node<T> tmp = this.head;
            while (tmp.getNext() != null){
                tmp = tmp.getNext();
            }
            tmp.setNext(newNode);
         }
    }

    /* 4) Thêm vào phía sau 1 node
     * B1: Khởi tạo 1 node mới
     * B2: Set next của node mới là node tiếp theo của node hiện tại
     * B3: Set next của node hiện tại cho nó nối vào newNode.*/
    public void insertAfter(T key, T toInsert){//key là node mà ta cần chèn node mới vào phía sau nó, toInsert là node mà ta muốn thêm vào
        // B2: Đi tìm vị trí của key
        Node<T> tmp = this.head;
        // Đi tìm node chứa key
        while(tmp != null && !tmp.getData().equals(key)){ // Khi node tạm khác null và node tạm không tìm được key thì tiếp tục next cho đến khi gặp thì break ra khỏi while
            tmp = tmp.getNext();
        }
        // Khi out ra khỏi while thì sẽ xảy ra 1 trong 2 tình huống: là tmp == null(thực ra khi out ra khỏi while thì chương trình đã không thể bằng null vì ta đã đặt điều kiện && bên trên rồi) hoặc là tìm thấy key
        if (tmp != null){
            Node<T> newNode = new Node<>(toInsert, tmp.getNext());
            tmp.setNext(newNode);
        }
            /* Bước 1: Khi này mới tạo node mới, nếu ta tạo node mới ngay từ đầu mà không tìm thấy key thì node đó sẽ không
             * được chèn vào, gây ra sự dư thừa và lãng phí.*/
             //node mới này data sẽ do người dùng nhập vào và next của nó là node tiếp theo của node key

    }

    /* Xóa một node
    * Linked list không được rỗng thì mới xóa được.
    * Nếu node ta cần xóa ở đầu linked list, Chỉ cần set next làm node khác là tự khắc node ban đầu sẽ bị loại bỏ
    * */
    public boolean remove(T key){
        if (this.head == null){
            System.out.println("Không xóa được vì List đang trống");
            return false;
        }
        if (this.head.getData().equals(key)){
            this.head = this.head.getNext();
            return true;
        }
        Node<T> prev = null;
        Node<T> cur = this.head;
        while (cur != null && !cur.getData().equals(key)){
            prev = cur;
            cur = cur.getNext();
        }
        if (cur == null){
            System.out.println("Can not delete");
            return false;
        }
        prev.setNext(cur.getNext());
        return true;
    }

    public boolean isNull(){
        return this.head == null;
        // Đoạn này được hiểu rằng: Khi nào thì 1 linked list == null? Thì là khi phần tử đầu tiên của nó là null (tức là ko có phần tử đầu). Mà phép so sánh thì mặc định trả về true or false rồi
    }

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
