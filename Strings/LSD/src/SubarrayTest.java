import java.util.Scanner;

public class SubarrayTest {
    public static void main(String[] args) {
        String lcs = getLCS(Generic.readFromFile(args[0]), Generic.readFromFile(args[1]));
        System.out.println("LCS: '" + lcs + "', length: " + lcs.length());
    }

    public static void readOneString() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String line, arr[] = new String[n];
        sc.nextLine();
        for(int i = 0; i < n; i++) {
            line = sc.nextLine();
            arr[i] = line;
        }

        sc.close();

        Generic.printArray(Subarray.getSubArrays(arr[0]));
    }

    public static String getLCS(String one, String two) {
        // Pick a character that doesn't appear
        // in either string and create substrings for
        // one ^ two, where ^ is that character.

        /*
        int[] chars = new int[128];
        char ans;

        for(int i = 0; i < one.length(); i++)
            chars[one.charAt(i)] = 1;

        for(int i = 0; i < two.length(); i++)
            chars[two.charAt(i)] = 2;

        int i = 0;
        for(i = 0; i < chars.length; i++)
            if(chars[i] == 0)
                break;

        // All characters are present in either one
        // string or both.
        // Nothing to do
        if(i == chars.length)
            return null;

        one += (char)chars[i]; */

        return Subarray.lcs(one, two);
    }
}
