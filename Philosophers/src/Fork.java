public class Fork {
    public int number = 1 + counter;
    private static int counter = 0;
    public boolean isFree = true;

    public Fork(){
        counter++;
    }
}
