
class Node<KeyType> {

    // Data
    private KeyType key;
    private Node next;

    // Constructors
    public Node() {
        key = (KeyType)null;
        next = null;
    }

    public Node(KeyType key) {
        this.key = key;
    }

    // Setters and getters
    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    public void setKey(KeyType key) {
        this.key = key;
    }

    public KeyType getKey() {
        return key;
    }

    public boolean equals(Node other) {
        if(other == null)
            return false;

        if(this == other)
            return true;

        if(this.key.equals(other.getKey()))
            return true;

        return false;
    }

    public String toString() {
        String ans = "";
        ans += key + ", ";
        return ans;
    }

    /*
    public int compareTo(Node other) throws Exception {
        if(other == null)
            throw new Exception("Null Node");

        if()
    }
    */
}
