package bossmonster.VO;

public class Name {
    private String value;
    public Name(String input){
        if (input.length()>5)
            throw new IllegalArgumentException("플레이어 이름은 5자 이하만 가능합니다.");
        this.value = input;
    }
}
