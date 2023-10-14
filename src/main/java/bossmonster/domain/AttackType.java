package bossmonster.domain;
enum AttackType {
    NORMAL(10, 0),
    MAGICK(20, 30);

    private final int damageValue;
    private final int useMpValue;

    AttackType(int damageValue, int useMpValue) {
        this.damageValue = damageValue;
        this.useMpValue = useMpValue;
    }

    int getDamageValue() {
        return damageValue;
    }

    int getUseMpValue() {
        return useMpValue;
    }

    static AttackType fromInt(int value){
        if(value == 1){
            return NORMAL;
        }
        if(value == 2){
            return MAGICK;
        }
        throw new IllegalArgumentException("없는 공격 타입입니다.");
    }
}
