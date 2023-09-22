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
}
