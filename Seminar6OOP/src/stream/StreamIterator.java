package stream;

import group.StudentsGroup;

import java.util.Iterator;
import java.util.List;

public class StreamIterator implements Iterator<StudentsGroup> {
    private List<StudentsGroup> groupList;
    int counter;

    public StreamIterator(List<StudentsGroup> groupList) {
        this.groupList = groupList;
        this.counter = 0;
    }

    @Override
    public boolean hasNext() {
        return counter < groupList.size();
    }

    @Override
    public StudentsGroup next() {
        if(!hasNext()) return null;
        else{
            counter++;
            return groupList.get(counter-1);
        }
    }
}
