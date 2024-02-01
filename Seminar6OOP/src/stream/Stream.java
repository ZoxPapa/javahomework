package stream;

import group.StudentsGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Stream implements Iterable<StudentsGroup> {
    private List<StudentsGroup> groupList;

    public Stream(StudentsGroup ... k) {
        this.groupList =  new ArrayList<>();
        Collections.addAll(groupList, k);
    }

    @Override
    public Iterator<StudentsGroup> iterator() {
        return new StreamIterator(this.groupList);
    }

    public List<StudentsGroup> getGroupList() {
        return groupList;
    }

    @Override
    public String toString() {
        return "Stream with " + groupList.size() + " groups.";
    }
}
