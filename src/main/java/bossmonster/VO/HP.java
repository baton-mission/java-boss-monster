package bossmonster.VO;

public class HP {
    private int nowValue;
    private int maxValue;
    public void boss(int input){
        if ( input < 100 || input > 300 )
            throw new IllegalArgumentException("보스의 초기 HP는 100이상 300이하 여야 합니다.");
        new HP(input);
    }
    public HP(int input){
        if (input < 0)
            throw new IllegalArgumentException("체력 초기값은 음수가 될 수 없습니다.");
        this.nowValue = input;
        this.maxValue = input;
    }
}
