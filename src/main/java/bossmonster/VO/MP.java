package bossmonster.VO;

public class MP extends Resource{
    public MP(int input){
        if (input >= 0){
           this.nowValue = input;
           this.maxValue = input;
        }
        throw new IllegalArgumentException("MP 초기값은 0또는 양수인 정수를 입력해야합니다.");
    }
    public void increase(int input){
        if (nowValue + input >= maxValue){
            nowValue = maxValue;
            return;
        }
        nowValue += input;
    }

    public Boolean usableMagic(int input){
        return (input <= nowValue);
    }
}
