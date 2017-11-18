class MSD {

    private static String[] aux;
    private static int rad = 256;

    public static void sort(String[] arr) {
        int num = arr.length;
        aux = new String[num];
        sort(arr, 0, num - 1, 0);
    }

    private static void sort(String[] arr, int start, int end, int d) {

        if(end <= start)
            return;

        // -1 is taken for when we're done
        // reading the string
        int[] count = new int[rad + 2];

        // count the frequencies, but only in the
        // range specified by start and end;
        // we need the +2 to cover for the -1 returned
        // by charAt()
        for(int i = start; i <= end; i++)
            count[charAt(arr[i], d) + 2]++;

        // converts the frequencies to "pointers"
        for(int i = 0; i < rad + 1; i++)
            count[i + 1] += count[i];

        // copy the elements from arr to aux
        for(int i = start; i <= end; i++)
            aux[count[charAt(arr[i], d) + 1]++] = arr[i];

        // copy from aux back to arr. we index aux with
        // a "- start" because "end - start" is the
        // highest possible number in count[]
        // (Isn't that imprecise?)
        for(int i = start; i <= end; i++)
            arr[i] = aux[i - start];

        // Recurse away now
        // Since the d element is at the right place,
        // we move on to the (d + 1)st.
        // The start and end pointers are decided by
        // the entries in count[]
        for(int i = 0; i < rad; i++)
            sort(arr, start + count[i], start + count[i + 1] - 1, d + 1);
    }

    private static int charAt(String s, int i) {
        return i < s.length() ? s.charAt(i) : -1;
    }
}
