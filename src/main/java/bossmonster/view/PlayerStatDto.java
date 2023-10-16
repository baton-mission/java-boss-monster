package bossmonster.view;

public class PlayerStatDto {
    private final int Hp;
    private final int Mp;

    public PlayerStatDto(int hp, int mp) {
        Hp = hp;
        Mp = mp;
    }

    public int getHp() {
        return Hp;
    }

    public int getMp() {
        return Mp;
    }
}
