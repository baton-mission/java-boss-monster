package bossmonster;

import bossmonster.VO.HP;
import bossmonster.VO.MP;
import bossmonster.VO.Name;

public class Player {
    private Name name;
    private HP hp;
    private MP mp;
    public void createName(String input){
        this.name = new Name(input);
    }
}

