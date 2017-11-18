import java.util.ArrayList;
import java.util.Arrays;

class Subarray {

    public static String[] getSubArrays(String str) {
        int n = str.length();
//        System.out.println("Recd str: " + str +
//                "bla, n = " + n);
        String[] ans = new String[n];
        for(int i = 0; i < n; i++) {
            ans[i] = (str.substring(i));
//            System.out.println(i + ": " + str.substring(i));
        }

//        Generic.printArray(ans);
        return ans;
    }

    /*
     * Find the longest common substring between two
     * strings.
    */
    public static String lcs(String one, String two) {
        int n = one.length() + two.length();

        /*
        CODE RETIRED
        StringBuilder s = new StringBuilder();
        s.append(one);
        s.append(two);


        String[] subs = getSubArrays(s.toString());
        Generic.printArray(subs);
        RadixQuick.sort(subs);
        */

        String[] subs_one = getSubArrays(one),
                 subs_two = getSubArrays(two);
        Arrays.sort(subs_one);
        Arrays.sort(subs_two);

//        Generic.printArray(subs_one);
//        Generic.printArray(subs_two);

        int i = 0, j = 0,
            len_one = subs_one.length,
            len_two = subs_two.length,
            max = 0;
        String ans = "", temp;

        while(i < len_one && j < len_two) {
            temp = lcp(subs_one[i], subs_two[j]);
            if(temp.length() > max) {
                max = temp.length();
                ans = temp;
            }
            if(compareStrings(subs_one[i], subs_two[j]) <= 0)
                i++;
            else
                j++;
        }

        return ans;
    }

    public static int compareStrings(String one, String two) {
        int i = 0, target = one.length() <= two.length() ? one.length() : two.length();
        while(i < target) {
            if(one.charAt(i) < two.charAt(i))
                return -1;
            if(one.charAt(i) > two.charAt(i))
                return 1;
            i++;
        }
        return 0;
    }

    /*
    Finds and returns the longest common prefix between
    two strings.
    Basically compare characters until the smaller of the
    strings is exhausted and stop when the chars are
    not the same.
     */
    private static String lcp(String one, String two) {
        //System.out.println("\nFind lcp between '" + one + "' and '" + two + "'\n");
        StringBuilder ans = new StringBuilder();

        // smaller of the two strings
        int x = one.length() <= two.length() ? one.length() : two.length();

        for(int i = 0; i < x; i++) {
            if(one.charAt(i) != two.charAt(i))
                break;
            ans.append(one.charAt(i));
        }
        return ans.toString();
    }
}
