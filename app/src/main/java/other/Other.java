package other;

public class Other {

    private String name;
    private int age;
    private int color;

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Other(String name, int age, int color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }
}
