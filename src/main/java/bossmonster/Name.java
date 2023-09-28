package bossmonster;

public class Name {

    private String name;

    public Name(String name) {
        this.name = name;
    }

    public boolean isLengthOver(int maxLength) {
        return name.length() > maxLength;
    }
}
