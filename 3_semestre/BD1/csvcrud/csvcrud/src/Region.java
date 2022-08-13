public class Region {
    private int id;
    private String name;
    private boolean isOpen = false;

    public Region() {
    }

    public Region(int id, String name, boolean isOpen) {
        this.id = id;
        this.name = name;
        this.isOpen = isOpen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = "\"" + name + "\"";
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

    @Override
    public String toString() {
        return name + "(" + id + ")";
    }
}
