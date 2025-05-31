package bases;

public abstract class shape {
    private String name;

    public shape() {

    }

    public void setName(String inputName) {
        this.name = inputName;
    }

    public String getName() {
        return name;
    }

    public abstract void printInfo();

}
