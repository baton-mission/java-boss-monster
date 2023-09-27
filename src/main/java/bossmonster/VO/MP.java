package bossmonster.VO;

public class MP extends Resource{
    public MP(int userInput) {
        if (userInput >= 0){
           this.nowValue = userInput;
           this.maxValue = userInput;
           return;
        }
        throw new IllegalArgumentException("MP 초기값은 0또는 양수인 정수를 입력해야합니다.");
    }

    public void increase(int restoreValue) {
        if (nowValue + restoreValue >= maxValue) {
            nowValue = maxValue;
            return;
        }
        nowValue += restoreValue;
    }

    public Boolean usableMagic(int Remains) {
        return (Remains <= nowValue);
    }
}
