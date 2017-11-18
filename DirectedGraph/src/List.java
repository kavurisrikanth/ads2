import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.security.Key;
import java.util.Iterator;

class List<KeyType> implements Iterable<KeyType> {

    private int numNodes;
    private Node<KeyType> head, tail;

    public List() {
        numNodes = 0;
        head = null;
        tail = null;
    }

    public void insert(KeyType key) {

        Node<KeyType> temp = head;

        // Look through the list and check if the current key
        // exists
        while(temp != null) {
            if(temp.getKey().equals(key)) {
                return;
            }
            temp = temp.getNext();
        }

        // Node doesn't exist. Add it.
        /* System.out.println("Fresh insert"); */
        temp = new Node<KeyType>(key);
        temp.setNext(head);
        head = temp;
        if(tail == null)
            tail = temp;

        numNodes++;
    }

    public void remove(KeyType key) {

        if(head == null)
            return;

        if(head.getKey().equals(key)) {
            head = head.getNext();
            return;
        }

        Node<KeyType> temp = head;
        while(temp.getNext() != null && !temp.getNext().getKey().equals(key)) {
            temp = temp.getNext();
        }

        if(temp.getNext() == null) return;

        temp.setNext(temp.getNext().getNext());
    }

    public boolean contains(KeyType key) {
        Node<KeyType> temp = head;

        // Look through the list and check if the current key
        // exists
        while(temp != null) {
            if(temp.getKey().equals(key)) {
                return true;
            }
            temp = temp.getNext();
        }

        return false;
    }

    public Iterator<KeyType> iterator() {
        Iterator<KeyType> it = new Iterator<KeyType>() {

            private Node<KeyType> temp = head;

            @Override
            public boolean hasNext() {
                //System.out.println("Checking");
                return temp != null;
            }

            @Override
            public KeyType next() {
                KeyType retVal = temp.getKey();
                temp = temp.getNext();
                return retVal;
            }
        };

        return it;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public String toString() {
        String ans = "";
        Node<KeyType> temp = head;
        while(temp != null) {

            ans += temp.toString();
            if(temp.getNext() != null)
                ans += ", ";

            temp = temp.getNext();
        }
        ans.trim();
        return ans;
    }
}
