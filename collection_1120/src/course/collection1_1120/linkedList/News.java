package course.collection1_1120.linkedList;

public class News {
    private String ID;
    private String name;
    private String creator;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public News() {
    }

    public News(String ID, String name, String creator) {
        this.ID = ID;
        this.name = name;
        this.creator = creator;
    }

}
