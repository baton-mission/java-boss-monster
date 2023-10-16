package bossmonster.domain.attack;

import java.util.Arrays;

public enum AttackType {
    ;
    private static final int BOSS_MAX_DAMAGE = 20;

    private static final int BOSS_MIN_DAMAGE = 0;
    private AttackType.Boss boss;
    private AttackType.Player player;

    public static AttackType.Boss createBossAttack() {
        return Boss.BOSS;
    }

    public static AttackType.Player createPlayerAttack(int number) {
        return Player.getAttackTypeByNumber(number);
    }


    public enum Boss {
        BOSS("보스", setDamage());


        private final String attackName;

        private final int damage;

        Boss(String attackName, int damage) {
            this.attackName = attackName;
            this.damage = damage;
        }

        public String getAttackName() {
            return attackName;
        }

        public int getDamage() {
            return damage;
        }

        public static int setDamage() {
            return new AttackRandomNumberGenerator()
                    .generate(BOSS_MIN_DAMAGE, BOSS_MAX_DAMAGE);
        }
    }

    public enum Player {
        NORMAL("물리 공격", 1, 10, -10),
        MAGIC("마법 공격", 2, 20, 30);
        private final String attackName;
        private final int typeNumber;
        private final int damage;
        private final int mpCost;

        Player(String attackName, int typeNumber, int damage, int mpCost) {
            this.attackName = attackName;
            this.typeNumber = typeNumber;
            this.damage = damage;
            this.mpCost = mpCost;
        }

        public String getAttackName() {
            return attackName;
        }

        public int getTypeNumber() {
            return typeNumber;
        }

        public int getDamage() {
            return damage;
        }

        public int getMpCost() {
            return mpCost;
        }

        public static AttackType.Player getAttackTypeByNumber(int typeNumber) {
            return Arrays.stream(AttackType.Player.values())
                    .filter(value -> value.getTypeNumber() == typeNumber)
                    .findAny()
                    .orElse(AttackType.Player.NORMAL);
        }
    }
}
