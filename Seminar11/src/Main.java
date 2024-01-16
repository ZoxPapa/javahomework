public class Main {
    public static void main(String[] args) {
        HotDrinkVendingMachine myCoffeMachine = new HotDrinkVendingMachine();
        System.out.println(myCoffeMachine.getProduct("WhiteCoffe", 40));
        System.out.println(myCoffeMachine.getProduct("WhiteCoffe", 50));
    }
}