import java.util.LinkedList;

class RadixQuick {

    public static void sort(String[] arr) {
        sort(arr, 0, arr.length - 1, 0);
    }

    private static void sort(String[] arr, int from,
                             int to, int ind) {

        // base case
        if(to <= from)
            return;

        int lt = from,
                i = from + 1,
                gt = to,
        piv = charAt(arr[from], ind);

        // Need the equals because we decrement gt every time
        // we add something to that subarray. So, the latest
        // addition has moved gt into the "equals".
        while(i <= gt) {
            //Generic.printArray(arr);
            int comp = charAt(arr[i], ind);
            if(comp < piv)
                swap(arr, i, lt++);
            else {
                if(comp > piv)
                    swap(arr, i, gt--);
                else
                    i++;
            }
        }

        // Recursively sort everything less than, greater than
        // and equal to
        sort(arr, from, lt - 1, ind);
        if(piv != -1)
            sort(arr, lt, gt, ind + 1);
        sort(arr, gt + 1, to, ind);
    }

    public static void sort(LinkedList<String> ll) {
        sort(ll, 0, ll.size() - 1, 0);
    }

    private static void sort(LinkedList<String> ll, int from,
                             int to, int ind) {

        if(to <= from)
            return;

        int lt = from, gt = to, i = from + 1,
            piv = charAt(ll.get(from), ind);

        while(i <= gt) {
            int comp = charAt(ll.get(i), ind);
            if(comp < piv)
                swap(ll, i, lt++);
            else {
                if(comp > piv)
                    swap(ll, i, gt--);
                else
                    i++;
            }
        }

        sort(ll, from, lt - 1, ind);
        if(piv != -1)
            sort(ll, lt, gt, ind + 1);
        sort(ll, gt + 1, to, ind);
    }

    private static void swap(LinkedList<String> ll, int one, int two) {
//        String temp = ll.remove(one);
        ll.add(two, ll.remove(one));
    }

    private static int charAt(String s, int i) {
        return i < s.length() ? s.charAt(i) : -1;
    }

    private static void swap(String[] arr, int one, int two) {
        System.out.println("swapping " + arr[one] + " at " + one + " and " + arr[two] + " at " + two);
        String temp = arr[one];
        arr[one] = arr[two];
        arr[two] = temp;
        Generic.printArray(arr);
    }
}
