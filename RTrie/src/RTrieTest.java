import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class RTrieTest {
    public static void main(String[] args) {
        RTrie rTrie = new RTrie();

        try {
            input(args[0], rTrie);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("apple: " + rTrie.get("apple"));
        System.out.println("banana: " + rTrie.get("banana"));
        rTrie.delete("banana");
        System.out.println(rTrie.get("banana"));

        testFloors(rTrie);
    }

    public static void input(String file, RTrie rTrie) throws Exception {
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line, arr[];

        while((line = br.readLine()) != null) {
            arr = line.split("\\s");
            rTrie.put(arr[0], Integer.parseInt(arr[1]));
        }
    }

    public static void testFloors(RTrie rTrie) {
        Scanner sc = new Scanner(System.in);
        String line;
        while(sc.hasNextLine()) {
            line = sc.nextLine();
            System.out.println(line + " -> floor: " + rTrie.floor(line));
//            System.out.println(line + " -> ceil: " + rTrie.ceil(line) + "\n");
        }
        sc.close();
    }
}
