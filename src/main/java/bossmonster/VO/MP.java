package bossmonster.VO;

public class MP {
    private Integer nowValue;
    private Integer maxValue;
    public MP(int input){
        if (input < 0)
            throw new IllegalArgumentException("MP 초기값은 음수가 될 수 없습니다.");
        this.nowValue = input;
        this.maxValue = input;
    }
    public void increase(int input){
        if (nowValue + input >= maxValue){
            nowValue = maxValue;
            return;
        }
        nowValue += input;
    }
    public void decrease(int input){
        nowValue -= input;
    }
    public Boolean usableMagic(int input){
        return (input <= nowValue);
    }
    public String showNowMax(){
        return "[" + nowValue + "/" + maxValue + "]";
    }
}
