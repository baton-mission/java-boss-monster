package bossmonster.VO;

public class HP {
    int nowValue;
    int maxValue;
    public void boss(int input){
        if ( input < 100 || input > 300 )
            throw new IllegalArgumentException("보스의 초기 HP는 100이상 300이하 여야 합니다.");
        new HP(input);
    }
    public HP(int input){
        this.nowValue = input;
        this.maxValue = input;
    }
}
