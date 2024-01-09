public class AemLinkedList {
    public static void main(String[] args) {
        LinkedList<Character> helloworld = new LinkedList<Character>();
        helloworld.PushBack('d');
        helloworld.DeleteIndex(0);
        helloworld.DeleteIndex(69);
        System.out.println(helloworld.getCount());

        helloworld.PushFront('e');
        helloworld.PushBack('l');
        helloworld.PushFront('l');
        helloworld.PushBack('r');
        helloworld.DeleteIndex(2);
        helloworld.PushFront('l');
        helloworld.PushBack('o');
        helloworld.PushFront('o');
        helloworld.PushBack('w');
        helloworld.DeleteIndex(0);
        helloworld.PushBack(' ');
        helloworld.PushFront('h');
        helloworld.PushFront('!');
        helloworld.Print();
    }
}

class LinkedList<T> {
    private ListNode<T> root = null;
    private ListNode<T> last = null;
    private int count = 0;

    public void PushBack(T newMemeber) {
        if (root == null) {
            root = new ListNode<T>();
            last = root;
            last.val = newMemeber;
            count = 1;
            return;
        }
        last.next = new ListNode<T>();
        last = last.next;
        last.val = newMemeber;
        count++;
    }

    public void PushFront(T newMemeber) {
        ListNode<T> temp = root;
        root = new ListNode<T>();
        root.val = newMemeber;
        if (temp != null) {
            root.next = temp;
        }
        if (last == null) {
            last = temp;
        }
        if (last == null) {
            last = root;
        }
        count++;
    }

    public boolean DeleteIndex(int indexToDelete) {
        ListNode<T> temp = root;
        ListNode<T> prev = null;
        int index = 0;
        boolean removed = false;
        if (indexToDelete == 0 && count <= 1) {
            root = null;
            last = null;
            count = 0;
            return true;
        }

        if (indexToDelete == 0) {
            root = root.next;
            count--;
            return true;
        }

        while (temp != null) {
            if (index == indexToDelete) {
                prev.next = temp.next;
                removed = true;
            }
            prev = temp;
            temp = temp.next;
            index++;
        }
        if (removed) {count--;}

        return removed;
    }

    public int getCount() {
        return count;
    }

    public void Print() {
        ListNode<T> temp = root;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}

class ListNode<T> {
    public T val;
    public ListNode<T> next;
    public void SetVal(T val) {
        this.val = val;
    }
    public void SetNext() {
        this.next = null;
    }
}
