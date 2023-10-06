package bossmonster.domain;

public class Player {

    private String name;
    private int currentHp;
    private int maxHp;
    private int currentMp;

    private int maxMp;

    private int tryCount = 0;

    public Player() {
    }

    public void sufferDamage(int damage) {
        this.currentHp = currentHp - damage;
        if (currentHp < 0) {
            currentHp = 0;
        }
    }

    public void takeDamage(Skill skill, Monster monster) {
        canUseSkill(skill);
        monster.sufferDamage(skill.getDamage());
        changeMp(skill);
        increaseTryCount();
    }

    private void increaseTryCount() {
        tryCount++;
    }

    public void canUseSkill(Skill skill) {
        if (currentMp < skill.getMp()) {
            throw new IllegalArgumentException("MP가 없어 스킬을 시전할 수 없습니다. 다른 스킬을 선택해주세요");
        }
    }


    private void changeMp(Skill skill) {
        this.currentMp = this.currentMp - skill.getMp();
        if (currentMp > maxMp) {
            currentMp = maxMp;
        }
    }


    public boolean isAlive() {
        return currentHp > 0;
    }


    public void isPossibleName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("사용자의 닉네임은 5글자 이하여야합니다.");
        }
    }

    public void isPossibleHpAndMp(int hp, int mp) {
        if (hp + mp != 200) {
            throw new IllegalArgumentException("사용자의 HP와 MP의 합은 200이어야합니다.");
        }
    }

    public void setName(String name) {
        isPossibleName(name);
        this.name = name;
    }

    public void setHpAndMp(int hp, int mp) {
        isPossibleHpAndMp(hp, mp);
        this.currentHp = hp;
        this.maxHp = hp;
        this.currentMp = mp;
        this.maxMp = mp;
    }


    public boolean isDead() {
        return !isAlive();
    }

    public String getName() {
        return name;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getCurrentMp() {
        return currentMp;
    }

    public int getMaxMp() {
        return maxMp;
    }

    public int getTryCount() {
        return tryCount;
    }
}
