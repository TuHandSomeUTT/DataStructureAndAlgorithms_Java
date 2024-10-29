public class StudentMS {
    private LinkedList<Student> linkedList;

    public StudentMS() {
        this.linkedList = new LinkedList<>();
    }

    public void addItem(Student student){
        this.linkedList.addLast(student);
    }

    public void printList(){
        this.linkedList.traverse();
    }

    public boolean find(Student student){
        return this.linkedList.find(student);
    }

    /*Update 1 đối tượng trong list:
     * Ý tưởng:
     * Cho 1 biến tạm chạy qua list
     * So sánh nếu student người dùng truyền vào trùng id với id student đã có thì thực hiện set cho các trường còn lại*/
    public void update(Student student){
        Node<Student> tmp = this.linkedList.getHead();
        while (tmp != null){
            Student sv = tmp.getData();
            if (sv.getId().equals(student.getId())){
                sv.setFullName(student.getFullName());
                sv.setAge(student.getAge());
                sv.setGpa(student.getGpa());
            }
            tmp = tmp.getNext();
        }
    }

    /* Đếm xem có bao nhiêu thằng tên x trong list.
     * Ý tưởng: Tạo 1 biến count. Duyệt qua linked list và check điều kiện. Nếu mà full name của đối tượng hiện tại
     * mà list đang duyệt nó == full name của người dùng nhập vào thì tiến hành tăng count lên 1 đơn vị. Nếu không gặp
     * thì tiếp tục next. Cuối cùng trả về số lượng đếm được.*/
    public int count(String fullName){
        int count = 0;
        Node<Student> tmp = this.linkedList.getHead();
        while(tmp != null){
            Student sv = tmp.getData();
            if (sv.getFullName().equals(fullName)){
                count++;
            }
            tmp = tmp.getNext();
        }
        return count;
    }

    public int size(){
        return this.linkedList.size();
    }
}
