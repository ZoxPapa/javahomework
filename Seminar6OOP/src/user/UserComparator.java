package user;

import java.util.Comparator;

public class UserComparator<T extends User> implements Comparator<T> {

    @Override
    public int compare(T o1, T o2) {
        if(o1.getName().compareTo(o2.getName()) == 0
        && o1.getAge() == o2.getAge()){
            return 0;
        }
        return Integer.compare(o1.getAge(), o2.getAge());

    }
}
