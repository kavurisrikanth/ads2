import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

class Generic {

    public static void printArray(String[] arr) {
        int n = arr.length;
        System.out.println();
        for(int i = 0; i < n; i++)
            System.out.println(arr[i] != null ? arr[i] : "null");
        //System.out.println("\n");
    }

    public static void printLinkedList(LinkedList<String> ll) {
        int n = ll.size();
        System.out.println();
        for(int i = 0; i < n; i++)
            System.out.println(ll.get(i));
        System.out.println();
    }

    public static String readFromFile(String path) {
        try {
            StringBuilder s = new StringBuilder();
            String line = null;

            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);

            while((line = br.readLine()) != null && line != "\n")
                s.append(line.toLowerCase().trim() + " ");
//            System.out.println("returning '" + s.toString().trim() + "'");
            return s.toString().trim();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
