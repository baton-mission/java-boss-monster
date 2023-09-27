package bossmonster.VO;

public class Name {

    private String value;

    public Name(String userInput){
        if (userInput.length() <= 5) {
            this.value = userInput;
            return;
        }
        throw new IllegalArgumentException("플레이어 이름은 5자 이하만 가능합니다.");
    }

    public String showName() {
        return value;
    }
}
