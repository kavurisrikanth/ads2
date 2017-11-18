import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class lsdTest {

    public static void main(String[] args) {
        //testInput();
        myInput();
    }

    public static void testInput() {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> strs = new ArrayList<>();
        while(sc.hasNext()) {
            strs.add(sc.next());
        }
        sc.close();

        String[] bla = new String[strs.size()];
        int i = 0;
        for(String s: strs)
            bla[i++] = s;

        int len = bla[0].length();
        LSD.sort(bla, len);
        Generic.printArray(bla);

        System.out.println("\n");
        Collections.shuffle(Arrays.asList(bla));
        MSD.sort(bla);
        Generic.printArray(bla);
    }

    public static void myInput() {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        String line, data[] = new String[num];

        sc.nextLine();
        for(int i = 0; i < num; i++) {
            line = sc.nextLine();
            data[i] = line;
        }
        sc.close();

        LSD.sort(data, data[0].length());
        Generic.printArray(data);

        System.out.println("\n");
        Collections.shuffle(Arrays.asList(data));
        MSD.sort(data);
        Generic.printArray(data);
    }
}
