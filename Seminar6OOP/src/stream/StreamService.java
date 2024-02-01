package stream;

import java.util.Collections;
import java.util.List;

public class StreamService {
    private List<Stream> streamList;

    public StreamService(List<Stream> streamList) {
        this.streamList = streamList;
    }

    public void sortStreamsByQtyOfGroups(){
        Collections.sort(this.streamList, new StreamComparator());
    }
}
