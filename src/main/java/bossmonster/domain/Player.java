package bossmonster.domain;

public class Player {

    String name;
    int hp;
    int mp;
    int maxHp;
    int maxMp;

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getMp() {
        return mp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getMaxMp() {
        return maxMp;
    }

    public void setName(String name) {
        validatePlayerName(name);
        this.name = name;
    }

    public void setStatus(int hp, int mp) {
        validatePlayerStatus(hp, mp);
        this.hp = hp;
        this.maxHp = hp;
        this.mp = mp;
        this.maxMp = mp;
    }

    public void gainMp() {
        if (mp < maxMp) {
            mp += 10;
        }
    }

    public void consumeMp() {
        mp -= 30;
    }

    public void reduceHp(int damage) {
        hp -= damage;
        if (hp < 0) {
            hp = 0;
        }
    }

    private void validatePlayerName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    private void validatePlayerStatus(int hp, int mp) {
        if (hp + mp != 200) {
            throw new IllegalArgumentException();
        }
    }
}
