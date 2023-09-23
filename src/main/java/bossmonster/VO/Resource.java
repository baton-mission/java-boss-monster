package bossmonster.VO;

public class Resource {
    Integer nowValue;
    Integer maxValue;

    public void decrease(int input){
        nowValue -= input;
    }
    public String showNowMax(){
        return "[" + nowValue + "/" + maxValue + "]";
    }
}
