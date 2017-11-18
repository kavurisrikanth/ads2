import java.util.Stack;

class RTrie {

    private class Node {
        //private Character key;
        private Integer val;
        private Node[] next;

        private Node() {
            //key = null;
            val = null;
            next = new Node[rad];
        }
    }

    private int rad = 256;
    private Node root;
    private int num;

    public RTrie(int rad) {
        this.rad = rad;
        root = new Node();
        num = 0;
    }

    public RTrie() {
        root = new Node();
        num = 0;
    }

    public void put(String key, int val) {
        int ind;

        Node temp = root;

        for(int i = 0; i < key.length(); i++) {
            // Get the char at index i
            ind = key.charAt(i) % rad;

            if(temp.next[ind] == null) {
                // Nothing exists there, so create it
                temp.next[ind] = new Node();
                //(temp.next[ind]).key = (char)ind;
                //System.out.println("Created new node w/ key: " + temp.next[ind].key);
            }

            // We have reached the end of the string, so put the value
            if(i == key.length() - 1) {
                temp.next[ind].val = val;
                //System.out.println("Set val " + temp.next[ind].val + " for key " + temp.next[ind].key);
            }

            temp = temp.next[ind];
        }

        num++;
    }

    public Integer get(String key) {
        /*
        Returns the value associated with key, if key exists
         */

        if(root == null)
            return null;

        int ind;

        Node temp = root, ac = null;

        for(int i = 0; i < key.length(); i++) {
            ind = key.charAt(i) % rad;

            //System.out.println("key at temp: " + temp.key);

            ac = temp.next[ind];

            if(ac == null)
                return null;

//            if(i != key.length() - 1)
                temp = ac;
        }

        return ac == null ? null : ac.val;
    }

    public boolean contains(String key) {
        return get(key) != null;
    }

    public int getNumKeys() {
        return num;
    }

    public void delete(String key) {

        if(root == null)
            return;

        int ind;
        Node temp = root, ac;
        Stack<Node> nodes = new Stack<>();

        for(int i = 0; i < key.length(); i++) {
            ind = key.charAt(i) % rad;

            ac = temp.next[ind];

            // Key does not exist
            if(ac == null && i != key.length() - 1)
                return;

            nodes.push(ac);
            temp = ac;
        }

        while(!nodes.isEmpty()) {
            ac = nodes.pop();
            ac = null;
        }
    }

    /*
        probably usable....

    floor - the largest key that is smaller than the given
    key
    In this case, we keep an upper bound on the character
    that can be picked.
    A key point is that once we stray from the string itself,
    we always pick the largest available option.


    public String floor(String key) {
        StringBuilder s = new StringBuilder();

        System.out.println("key: " + key);

        Node temp = root;
        char bound;
        int i = 0, ind;
        boolean boundChanged = false, done = false;

        while(i < key.length() && !done) {
            if(i < 0)
                i = 0;

            bound = key.charAt(i);

            // if the bound itself is available, take it
            if(temp.next[bound] != null && !boundChanged) {
                i++;
                s.append((char)bound);
                temp = temp.next[bound];
            } else {
                // look for a smaller bound
                ind = bound;

                if(!boundChanged)
                    boundChanged = true;

                while (temp.next[ind] == null) {
                    ind--;
                    if(ind < 0)
                        break;
                }

                if(ind < 0) {
                    i--;
//                    s = new StringBuilder();
                } else {
                    s.append((char)ind);
                    i++;
                    temp = temp.next[ind];
                }
            }

            if(temp.val != null)
                done = true;
        }

        return s.toString();
    } */


    /*
    public String toString() {
        StringBuilder s = new StringBuilder();

        Node temp = root;
        for(int i = 0; i < )

        return s.toString();
    } */

    /* WORKING. COMMENTED OUT TO LOOK FOR BETTER ALTERNATIVE
    Smallest element in the trie that's greater than key */

    public String floor(String key) {
        // Break this down into pieces.
        // If key exists in the trie, then it is its own floor
        // If not, then look further.
        // There could be a partial match for one of the words...
        // If there is only a partial match, meaning we reach the null
        // links without completing a word, then go back and try another letter
        // one level above

        Node temp = root;
        int ind = 0, i = 0;
        boolean stop = false,
                change = false;
        StringBuilder s = new StringBuilder();

        while(!stop) {

            if(!change) {
                ind = key.charAt(i);
                if (temp.next[ind] == null)
                    change = true;

                while(temp.next[ind] == null) {
                    ind--;
                    if (ind < 0) {
                        i--;
                        change = false;
                        break;
                    }
                }
            } else {
                ind = rad - 1;

                while(temp.next[ind] == null) {
                    ind--;
                    if (ind < 0) {
                        i--;
                        change = false;
                        break;
                    }
                }
            }

            if(i < 0)
                return null;

            if(ind >= 0) {
                s.append((char) ind);
                temp = temp.next[ind];
                i++;
            }

            System.out.println("testing string " + s.toString());

            if(this.contains(s.toString()))
                stop = true;


        }

        return s.toString();
    }


    /*
    Largest element in the trie that's smaller than key
    */
    public String ceil(String key) {
        // Break this down into pieces.
        // If key exists in the trie, then it is its own floor
        // If not, then look further.
        // There could be a partial match for one of the words...
        // If there is only a partial match, meaning we reach the null
        // links without completing a word, then go back and try another letter
        // one level above

        Node temp = root;
        int ind = 0, i = 0;
        boolean stop = false,
                change = false;
        StringBuilder s = new StringBuilder();

        while(!stop) {

            // get the ith character of the key
            ind = key.charAt(i);

            
        }

        return s.toString();
    }
}
