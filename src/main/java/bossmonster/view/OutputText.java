package bossmonster.view;

import bossmonster.domain.BossMonster;
import bossmonster.domain.Player;

public class OutputText {

    public static final String PHYSICAL_ATTACK = "물리 공격을 했습니다. (입힌 데미지: 10)";

    public final String Boss_ATTACK(int attackType){
        if(attackType == 1){
            return "보스가 공격 했습니다. (입힌 데미지: 10)";
        }
        return "보스가 공격 했습니다. (입힌 데미지: 15)";
    }

    public static final String BOSS_INIT =
            "____________________________\n"
            + "   ^-^\n"
            + " / 0 0 \\\n"
            + "(   \"   )\n"
            + " \\  -  /\n"
            + "  - ^ -\n"
            + "____________________________";
    public static final String BOSS_WINNING =
            "____________________________\n"
            + "   ^-^\n"
            + " / ^ ^ \\\n"
            + "(   \"   )\n"
            + " \\  3  /\n"
            + "  - ^ -\n"
            + "____________________________";
    public static final String BOSS_LOSING  =
            "____________________________\n"
            + "   ^-^\n"
            + " / x x \\\n"
            + "(   \"\\  )\n"
            + " \\  ^  /\n"
            + "  - ^ -\n"
            + "____________________________";

    public final String printBossHp(BossMonster bossMonster){
        return "\n"
                + "============================\n"
                + "BOSS HP ["+bossMonster.getHp()+"/"+bossMonster.getInitHp()+"]";
    }

    public final String printPlayerInfo(Player player){
        return "dori "
                + "HP ["+player.getHp()+"/"+player.getInitHp()+"] "
                + "MP ["+player.getMp()+"/"+player.getInitMp()+"]\n"
                + "============================";
    }
}
