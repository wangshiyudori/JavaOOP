package course.collections1_1121.genericT;

import java.util.List;

public class School1<T>{
    private List<T> lists;

    public List<T> getLists() {
        return lists;
    }

    public void setLists(List<T> lists) {
        this.lists = lists;
    }
}
