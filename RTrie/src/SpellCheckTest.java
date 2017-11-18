import java.io.File;
import java.util.Scanner;

public class SpellCheckTest {
    public static void main(String[] args) throws Exception {
        SpellCheck spellCheck = new SpellCheck(args[0]);
//        Scanner sc = new Scanner(new File("tinyOut.txt"));
        Scanner sc = new Scanner(System.in);
        String line;

        while(sc.hasNextLine()) {
            line = sc.nextLine();
            System.out.println(spellCheck.isValid(line) ? line + " is a valid word" : line + " is not a valid word");
        }
        sc.close();
    }
}
