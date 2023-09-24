package controller;

import domain.Player;

public class PlayerController {
    private static final Player player = Player.getInstance();
    private static final BossController bossController = new BossController();

    public void setName(String name){
        player.setName(name);
    }

    public void setStats(int hp, int mp){
        player.setCurrent_hp(hp);
        player.setMax_hp(hp);
        player.setCurrent_mp(mp);
        player.setMax_mp(mp);
    }

    public void attack(int attack_type){
        setMp(attack_type);
        int damage = attack_type * 10;
        bossController.getAttack(damage);

        if(attack_type == 1){
            System.out.printf("물리 공격을 했습니다. (입힌 데미지: %d) \n", damage);
        }

        if(attack_type == 2){
            System.out.printf("마법 공격을 했습니다. (입힌 데미지: %d) \n", damage);
        }
    }

    private void setMp(int attack_type){
        if(attack_type == 1){
            if(player.getCurrent_mp() + 10 <= player.getMax_mp()){
                player.setCurrent_mp(player.getCurrent_mp() + 10);
            }
        }

        if(attack_type == 2){
            player.setCurrent_mp(player.getCurrent_mp() - 30);
        }
    }

    public boolean checkMp(){
        if(player.getCurrent_mp() < 30) return false;
        return true;
    }

    public void getAttack(int damage){
        player.setCurrent_hp(player.getCurrent_hp() - damage);
        if(player.getCurrent_hp() < 0) player.setCurrent_hp(0);
    }

    public boolean isOver(){
        if(player.getCurrent_hp() > 0) return false;
        bossController.setState(3);
        return true;
    }
}
