import java.util.Scanner;

public class kicTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt(), r = 0, key = 0;
        KeyStone[] data = new KeyStone[num];
        String line, arr[];

        // Ignore the \n
        sc.nextLine();

        for(int i = 0; i < num; i++) {
            line = sc.nextLine();
            arr = line.split("\\s");
            key = Integer.parseInt(arr[1]);
            r = (key > r) ? key : r;
            data[i] = new KeyStone(arr[0], key);
        }
        sc.close();

        KeyIndexedCounting.go(data, r + 1);
        printArray(data);
    }

    public static void printArray(KeyStone[] arr) {
        int n = arr.length;
        for(int i = 0; i < n; i++)
            System.out.println(arr[i].getStone() + " " + arr[i].getKey());
    }
}
