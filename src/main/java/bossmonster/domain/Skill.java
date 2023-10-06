package bossmonster.domain;

import java.util.Arrays;

public enum Skill {
    MAGIC("2", 20, 30, "마법공격"),
    PHYSICAL("1", 10, -10, "물리공격");


    private String skillNo;
    private int damage;
    private int mp;

    private String skillName;

    Skill(String skillNo, int damage, int mp, String skillName) {
        this.skillNo = skillNo;
        this.damage = damage;
        this.mp = mp;
        this.skillName = skillName;
    }

    public static Skill getSkillBySkillNo(String skillNo) {
        return Arrays.stream(Skill.values())
                .filter(skill -> skill.getSkillNo().equals(skillNo))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 스킬입니다."));
    }

    public String getSkillNo() {
        return skillNo;
    }

    public int getDamage() {
        return damage;
    }

    public int getMp() {
        return mp;
    }

    public String getSkillName() {
        return skillName;
    }
}
