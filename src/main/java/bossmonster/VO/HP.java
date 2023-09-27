package bossmonster.VO;

public class HP extends Resource{
    public static HP boss(int userInput){
        if (userInput >= 100 && userInput <= 300) {
            return new HP(userInput);
        }
        throw new IllegalArgumentException("보스의 초기 HP는 100이상 300이하인 자연수여야 합니다.");
    }

    public HP(int userInput) {
        if (userInput > 0) {
            this.nowValue = userInput;
            this.maxValue = userInput;
            return;
        }
        throw new IllegalArgumentException("양수인 정수를 입력해야 합니다.");
    }

    public Boolean canDie(int damage) {
        return (nowValue <= damage);
    }

    public void toZero() {
        this.nowValue = 0;
    }

    public Integer dealDamege(Integer realDamage){
        if (nowValue <= realDamage) {
            return nowValue;
        }
        return realDamage;
    }
}
