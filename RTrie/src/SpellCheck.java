import java.io.BufferedReader;
import java.io.FileReader;

class SpellCheck {
    private RTrie words;

    public SpellCheck(String file) throws Exception {

        words = new RTrie(26);

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        int i = 0;

        while((line = br.readLine()) != null)
            words.put(line, i++);
    }

    public boolean isValid(String word) {
        return words.contains(word);
    }
}
