import java.util.*;

public class Main {
    public static void main(String[] args) {
        Notebooks n1 = new Notebooks("Samsung", "White", 16, 500, true);
        Notebooks n2 = new Notebooks("Lenovo", "White", 8, 300, false);
        Notebooks n3 = new Notebooks("LG", "Purple", 1, 32, true);
        Notebooks n4 = new Notebooks("Apple", "White", 16, 256, false);
        Notebooks n5 = new Notebooks("Samsung", "White", 32, 1000, true);
        Notebooks n6 = new Notebooks("Lenovo", "White", 4, 500, true);
        Notebooks n7 = new Notebooks("Baikal", "White", 8, 256, true);
        Notebooks n8 = new Notebooks("Samsung", "Black", 2, 100, true);
        Notebooks n9 = new Notebooks("LG", "White", 16, 500, false);
        Notebooks n10 = new Notebooks("LG", "Red", 32, 1000, false);
        List<Notebooks> db = new ArrayList<>();
        db.add(n1);db.add(n2);db.add(n3);db.add(n4);db.add(n5);db.add(n6);db.add(n7);db.add(n8);db.add(n9);db.add(n10);
        Map<Integer, String> userChoise =  ui();
        List<Notebooks> resulList =  filter(userChoise, db);
        for(Notebooks nb: resulList){
            System.out.println(nb.toString());
        }

//        Scanner mySc = new Scanner(System.in);
//        String smth = mySc.nextLine();
//        System.out.println(smth);
    }

    private static List<Notebooks> filter(Map<Integer, String> userChoise, List<Notebooks> db) {
        List<Notebooks> resultOfSearch = new LinkedList<>();
        for (Notebooks nb : db) {
            if (userChoise.size() > 0) {
                boolean flag = true;
                for (Map.Entry<Integer, String> items : userChoise.entrySet()) {
                    Integer key = items.getKey();
                    switch (key) {
                        case 1:
                            if (nb.mainName.equalsIgnoreCase(items.getValue())) {
                                continue;
                            } else {
                                flag = false;
                                break;
                            }
                        case 2:
                            if (nb.mainColor.equalsIgnoreCase(items.getValue())) {
                                continue;
                            } else {
                                flag = false;
                                break;
                            }
                        case 3:
                            if (nb.mainRAM >= Integer.parseInt(items.getValue())) {
                                continue;
                            } else {
                                flag = false;
                                break;
                            }
                        case 4:
                            if (nb.mainHDD >= Integer.parseInt(items.getValue())) continue;
                            else {
                                flag = false;
                                break;
                            }
                        case 5:
                            if (nb.mainCD == Boolean.parseBoolean(items.getValue())) continue;
                            else {
                                flag = false;
                                break;
                            }
                    }
                }
                if (flag) {
                    resultOfSearch.add(nb);
                }
            } else {
                System.out.println("Filter is empty");
                System.exit(0);
            }
        }
        if (resultOfSearch.size() > 0) {
            return resultOfSearch;
        } else {
            System.out.println("We find nothing.");
            System.exit(0);
        }
        return resultOfSearch;
    }

    static Map<Integer, String> ui(){
        while (true){
            Scanner sc = new Scanner(System.in);
            Map<Integer, String> toFind = new HashMap<>();

            Integer key = 1;
            while(key >0 && key  < 7 ){ //магическое число. Можно ввести глобальную переменную в классе Notebook с количеством параметров. Как лучше это реализовать?
                System.out.println(" Choose your filters, press 5 to see results of search. \n"+
                        "1. Name of company \n"+
                        "2. Color \n"+
                        "3. Min Qty of RAM \n"+
                        "4. Min Qty of HDD, Gb \n"+
                        "5. CDRom \n" +
                        "6. See result \n");
                System.out.println("Choose menu item: ");
                key = sc.nextInt();
                String value;
                switch (key) {
                    case 1:
                        System.out.println("Input name of company: ");
                        value = sc.next(); //не сработал sc.NextLine - почему и правильно ли тут использовать next?
                        toFind.put(key, value);
                        break;
                    case 2:
                        System.out.println("Input color: ");
                        value = sc.next();
                        toFind.put(key, value);
                        break;
                    case 3:
                        System.out.println("Input min Qty of RAM: ");
                        value = sc.next();
                        toFind.put(key, value);
                        break;
                    case 4:
                        System.out.println("Input min Qty of HDD, Gb: ");
                        value = sc.next();
                        toFind.put(key, value);
                        break;
                    case 5:
                        System.out.println("Input is needed CDrom? ");
                        value = sc.next();
                        toFind.put(key, value);
                        break;
                    case 6:
                        return toFind;

//                        System.out.println(toFind.toString());
//                        System.exit(0);
                }
//                System.out.println(toFind.toString());
            }
        }

    }
}