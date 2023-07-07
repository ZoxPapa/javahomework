import java.util.*;

public class Main2 {
    /*
    Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина,
    Анна Крутова, Иван Юрин, Петр Лыков, Павел Чернов, Петр Чернышов,
    Мария Федорова, Марина Светлова, Мария Савина, Мария Рыкова,
    Марина Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов.
     */
    public static void main(String[] args) {
        String data = "Иван Иванов, Мария Федорова,Павел Чернов, Иван Ежов, Светлана Петрова, Мария Федорова, " +
                "Павел Чернов, Кристина Белова, Анна Мусина, Иван Ежов, Иван Ежов, " +
                "Анна Крутова, Иван Юрин, Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова," +
                "Мария Федорова, Марина Светлова, Мария Савина, Мария Рыкова, Мария Федорова," +
                "Марина Лугова, Мария Федорова, Иван Ежов, Анна Владимирова, Петр Петин, Иван Мечников, Петр Петин, Иван Ежов.";
        data = data.replace(".", "");
        data = data.replace(" ", "");
        String[] dataList = data.split(",");
        List myList = Arrays.asList(dataList);
        Map<Integer, List<String>> qtyNames= new TreeMap<>(Collections.reverseOrder());

        for(String name: dataList){
            Integer qty = Collections.frequency(myList, name);
            if(qty==1){
                continue;
            }else{
                if(!qtyNames.containsKey(qty)){
                    List<String> names = new LinkedList<>();
                    names.add(name);
                    qtyNames.put(qty, names);
                }
                else if (!qtyNames.get(qty).contains(name)){
                    qtyNames.get(qty).add(name);
                }
            }
        }
        for (Map.Entry items: qtyNames.entrySet()){
            System.out.println(items);
        }

    }
}
