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

    public final String BOSS_INIT () {
        return  "____________________________\n"
                + "   ^-^\n"
                + " / 0 0 \\\n"
                + "(   \"   )\n"
                + " \\  -  /\n"
                + "  - ^ -\n"
                + "____________________________";
    }

    public final String BOSS_WINNING () {
        return  "____________________________\n"
                + "   ^-^\n"
                + " / ^ ^ \\\n"
                + "(   \"   )\n"
                + " \\  3  /\n"
                + "  - ^ -\n"
                + "____________________________";
    }

    public final String BOSS_LOSING () {
        return  "____________________________\n"
                + "   ^-^\n"
                + " / x x \\\n"
                + "(   \"\\  )\n"
                + " \\  ^  /\n"
                + "  - ^ -\n"
                + "____________________________";
    }


    public final String printBossHp(BossMonster bossMonster){
        return "\n"
                + "============================\n"
                + "BOSS HP ["+bossMonster.getHp()+"/"+bossMonster.getInitHp()+"]";
    }

    public final String printPlayerInfo(Player player){
        return  "\n"+player.getName()+" "
                + "HP ["+player.getHp()+"/"+player.getInitHp()+"] "
                + "MP ["+player.getMp()+"/"+player.getInitMp()+"]\n"
                + "============================";
    }

    public final String printPhysicalAttack(int random, boolean bossDie){
        String sentence ="\n물리 공격을 했습니다. (입힌 데미지: 10)\n";
        if(!bossDie){
            return sentence+"보스가 공격 했습니다. (입힌 데미지: "+random+")";
        }
        return sentence;
    }

    public final String printMagicAttack(int random, boolean bossDie){
        String sentence = "\n마법 공격을 했습니다. (입힌 데미지: 20)\n";
        if(!bossDie) {
            return sentence + "보스가 공격 했습니다. (입힌 데미지: " + random + ")";
        }
        return sentence;
    }

    public final String printFailMessage(){
        return "\ndori의 HP가 0이 되었습니다.\n"
                + "보스 레이드에 실패했습니다.";
    }

    public final String printWinMessage(Player player, int num){
        return player.getName() + " 님이 "+num+"번의 전투 끝에 보스 몬스터를 잡았습니다.";
    }
}
