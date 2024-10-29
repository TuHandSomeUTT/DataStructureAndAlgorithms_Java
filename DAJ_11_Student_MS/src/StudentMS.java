public class StudentMS {
        private LinkedList<Student> linkedList;

    public StudentMS() {
        this.linkedList = new LinkedList<Student>();
    }

    public void addStudent(Student student){
        this.linkedList.addLast(student);
    }

    public void printList(){
        this.linkedList.traverse();
    }

    public boolean findItem(Student student){
        return this.linkedList.findItem(student);
    }

    /*Update 1 đối tượng trong list:
    * Ý tưởng:
    * Cho 1 biến tạm chạy qua list
    * So sánh nếu student người dùng truyền vào trùng id với id student đã có thì thực hiện set cho các trường còn lại*/
    public void update(Student student){
        Node<Student> tmp = linkedList.getHead();
        while(tmp != null){
            Student s1 = tmp.getData(); //Tạo 1 student và gán giá trị của student hiện tại mà tmp đang duyệt cho s1(Tức là đang duyệt đến ông nào trong list thì gán luôn dữ liệu của ông đó cho s1)
            if (s1.getId().equals(student.getId())){//Dữ liệu trong đối tượng hiện tại mà có id trùng với id người dùng nhập vào
                s1.setFullName(student.getFullName()); //setFullName người dùng nhập vào thay thế data của đối tượng student hiện tại
                s1.setGpa(student.getGpa());
                s1.setAge(student.getAge());
            }
            tmp = tmp.getNext(); //Nếu không trùng id thì tiếp tục next
        }
    }

    public boolean remove(Student student){
        return this.linkedList.remove(student);
    }

    /* Đếm xem có bao nhiêu thằng tên x trong list.
    * Ý tưởng: Tạo 1 biến count. Duyệt qua linked list và check điều kiện. Nếu mà full name của đối tượng hiện tại
    * mà list đang duyệt nó == full name của người dùng nhập vào thì tiến hành tăng count lên 1 đơn vị. Nếu không gặp
    * thì tiếp tục next. Cuối cùng trả về số lượng đếm được.*/
    public int count(String fullName){
        int count = 0;
        Node<Student> tmp = this.linkedList.getHead();
        while(tmp != null){
            Student st = tmp.getData();
            if (st.getFullName().equals(fullName)){
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
