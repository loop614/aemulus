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
    private ListNodeAe<T> root = null;
    private ListNodeAe<T> last = null;
    private int count = 0;

    public void PushBack(T newMemeber) {
        if (root == null) {
            root = new ListNodeAe<T>();
            last = root;
            last.val = newMemeber;
            count = 1;
            return;
        }
        last.next = new ListNodeAe<T>();
        last = last.next;
        last.val = newMemeber;
        count++;
    }

    public void PushFront(T newMemeber) {
        ListNodeAe<T> temp = root;
        root = new ListNodeAe<T>();
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
        ListNodeAe<T> temp = root;
        ListNodeAe<T> prev = null;
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
        ListNodeAe<T> temp = root;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}

class ListNodeAe<T> {
    public T val;
    public ListNodeAe<T> next;
    public void SetVal(T val) {
        this.val = val;
    }
    public void SetNext() {
        this.next = null;
    }
}
