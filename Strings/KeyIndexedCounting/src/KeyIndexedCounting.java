class KeyIndexedCounting {

    public static void go(KeyStone[] arr, int r) {
        int n = arr.length;
        KeyStone[] aux = new KeyStone[n];
        int[] count = new int[r + 1];

        // Count the frequencies
        for(int i = 0; i < n; i++)
            count[arr[i].getKey() + 1]++;

        /*
        DEBUG PRINTS
        for(int i = 0; i <= r; i++)
            System.out.println(i + ": " + count[i]);
            */

        // Convert the counts into index info
        for(int i = 0; i < r; i++)
            count[i + 1] += count[i];

        /*
        DEBUG PRINTS
        System.out.println();
        for(int i = 0; i <= r; i++)
            System.out.println(i + ": " + count[i]);
            */

        // Populate aux according to the indices in count
        for(int i = 0; i < n; i++)
            aux[count[(arr[i].getKey())]++] = arr[i];

        // Copy aux back into arr
        // (This function gets arr as an arg, so meaningless?)
        for(int i = 0; i < n; i++)
            arr[i] = aux[i];
    }
}
