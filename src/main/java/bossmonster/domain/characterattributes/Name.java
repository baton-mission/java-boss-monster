package bossmonster.domain.characterattributes;

public class Name {

    private String name;

    public Name(String name) {
        this.name = name;
    }

    public boolean isLengthOver(int maxLength) {
        return name.length() > maxLength;
    }

    public String getName() {
        return name;
    }
}
