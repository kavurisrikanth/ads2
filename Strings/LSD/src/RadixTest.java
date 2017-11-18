import java.util.LinkedList;
import java.util.Scanner;

public class RadixTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String line, arr[] = new String[n];
        LinkedList<String> strs = new LinkedList<>();
        sc.nextLine();
        for(int i = 0; i < n; i++) {
            line = sc.nextLine();
            arr[i] = line;
            strs.add(0, line);
        }

        sc.close();

        RadixQuick.sort(arr);
        Generic.printArray(arr);

        /*
        System.out.println();
        RadixQuick.sort(strs);
        Generic.printLinkedList(strs); */
    }
}
