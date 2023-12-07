public class GamblingMachine {
 
    private int value = 0;

    GamblingMachine() {
        value = 0;
    }

    public void inserCoins(int insert) {
        getValue(value);
        value = insert;
    }

    public int  getValue(int value) {
        return value;
    }

    public void withdraw() {
        getValue(value);
        System.out.println("Withdraw: " + value);
        value = 0;
    }

    public void play() {
        getValue(value);
        if ((int) Math.random() * 6 == (int) Math.random() * 6) {
            value = value * 3;
        } else {
            value = 0;
        }
    }



}
