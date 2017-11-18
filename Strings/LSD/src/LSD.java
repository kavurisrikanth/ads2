/*
Least Significant Digit sort for strings.
We move from right to left, sorting the strings based on
the "digit" at that particular index
 */
public class LSD {

    public static void sort(String[] arr, int len) {
        int num = arr.length,
            rad = 256;
        String[] aux = new String[num];

        for(int x = len - 1; x >= 0; x--) {

            // counts. separate for each index (x)
            int[] count = new int[rad + 1];

            // count frequencies
            for(int i = 0; i < num; i++)
                count[arr[i].charAt(x) + 1]++;

            /* DEBUG PRINTOUT
            for(int i = 97; i <= 122; i++)
                System.out.println(i + ": " + Character.toString((char)(i - 1)) + ": " + count[i]);
            System.out.println();
            */

            // turn counts into index "pointers"
            for(int i = 0; i < rad; i++)
                count[i + 1] += count[i];

            /* DEBUG PRINTOUT
            for(int i = 97; i <= 122; i++)
                System.out.println(i + ": " + Character.toString((char)(i)) + ": " + count[i]);
            System.out.println();
            */

            // populate aux using counts
            for(int i = 0; i < num; i++) {
                aux[count[arr[i].charAt(x)]++] = arr[i];
            }

            // copy aux back into the original
            for(int i = 0; i < num; i++)
                arr[i] = aux[i];

            //Generic.printArray(arr);
        }
    }
}
