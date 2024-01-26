public class Main {
    public static void main(String[] args) {
        HotDrinkVendingMachine myCoffeMachine = new HotDrinkVendingMachine();
        System.out.println(myCoffeMachine.getProduct("Latte"));
        System.out.println(myCoffeMachine.getProduct("WhiteCoffe"));
        System.out.println(myCoffeMachine.getProduct("WhiteCoffe", 100,40));
        System.out.println(myCoffeMachine.getProduct("WhiteCoffe", 100, 50));
        System.out.println(myCoffeMachine.getProduct("WhiteCoffe", 90,40));
    }
}