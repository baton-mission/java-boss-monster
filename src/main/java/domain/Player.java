package domain;

public class Player {
    private static Player instance;

    private Player(){

    }

    public static Player getInstance(){
        if(instance == null){
            instance = new Player();
        }
        return instance;
    }
    private int max_hp;
    private int current_hp;

    private int max_mp;
    private int current_mp;

    private String name;


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

    public int getMax_mp() {
        return max_mp;
    }

    public void setMax_mp(int max_mp) {
        this.max_mp = max_mp;
    }

    public int getCurrent_mp() {
        return current_mp;
    }

    public void setCurrent_mp(int current_mp) {
        this.current_mp = current_mp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
