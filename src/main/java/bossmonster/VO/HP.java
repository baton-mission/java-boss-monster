package bossmonster.VO;

import bossmonster.IO.Input;

import java.util.List;

public class HP {
    private Integer nowValue;
    private Integer maxValue;
    public static HP boss(int input){
        if ( input >= 100 && input <= 300 ) {
            return new HP(input);
        }
        throw new IllegalArgumentException("보스의 초기 HP는 100이상 300이하인 자연수여야 합니다.");
    }
    public HP(int input){
        if (input > 0) {
            this.nowValue = input;
            this.maxValue = input;
            return;
        }
        throw new IllegalArgumentException("양수인 정수를 입력해야 합니다.");
    }

    public Boolean canDie(int damage){
        return (nowValue <= damage);
    }
    public void toZero(){
        this.nowValue = 0;
    }

    public void decrease(int damage){
        nowValue -= damage;
    }

    public String showNowMax(){
        return "[" + nowValue + "/" + maxValue + "]";
    }
    public Integer dealDamege(Integer input){
        if (nowValue <= input)
            return nowValue;
        return input;
    }
}
