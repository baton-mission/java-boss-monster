package bossmonster.resources;

public class Resource {

    Integer nowValue;
    Integer maxValue;

    public void decrease(int decreaseAmount) {
        nowValue -= decreaseAmount;
    }

    public String showNowMax() {
        return "[" + nowValue + "/" + maxValue + "]";
    }
}
