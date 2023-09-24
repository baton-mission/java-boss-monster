package domain;

public class Boss {
    private static Boss instance;

    private Boss(int state){
        this.state = state;
    }

    public static Boss getInstance(){
        if(instance == null){
            instance = new Boss(1);
        }
        return instance;
    }
    private int max_hp;
    private int current_hp;
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getMax_hp() {
        return max_hp;
    }

    public void setMax_hp(int max_hp) {
        this.max_hp = max_hp;
    }

    public int getCurrent_hp() {
        return current_hp;
    }

    public void setCurrent_hp(int current_hp) {
        this.current_hp = current_hp;
    }
}
