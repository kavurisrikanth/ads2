/*
A String along with a Key. Something like this: Apple 6.
The keys are assumed to be small integers.
 */

class KeyStone {
    private String stone;
    private int key;

    public KeyStone(String stone, int key) {
        this.stone = stone;
        this.key = key;
    }

    public String getStone() {
        return stone;
    }

    public void setStone(String stone) {
        this.stone = stone;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
