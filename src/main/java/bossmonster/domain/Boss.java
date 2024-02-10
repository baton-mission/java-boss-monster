package bossmonster.domain;

import java.util.Random;

public class Boss {
    private final Integer maxHp;
    private Integer currentHp;

    public Boss(Integer hp) {
        this.maxHp = hp;
        this.currentHp = hp;
        printStat();
        printFigure(1);
    }

    public Integer getHp() { return this.currentHp; }

    public void printStat() {
        System.out.println("\n======================================");
        System.out.println("BOSS HP [" + this.currentHp + "/" + this.maxHp + "]");
        System.out.println("______________________________________");
    }

    public void printFigure(final Integer figureType) {
        if(figureType == 1) {     //initial
            System.out.println(
                    "   ^-^\n"
                    + " / 0 0 \\\n"
                    + "(   \"   )\n"
                    + " \\  -  /\n"
                    + "  - ^ -  "
            );
            System.out.println("______________________________________");
            return;
        }
        if(figureType == 0) {     //damaged
            System.out.println(
                    "   ^-^\n"
                    + " / X X \\\n"
                    + "(   \"\\  )\n"
                    + " \\  -  /\n"
                    + "  - ^ -  "
            );
            System.out.println("______________________________________");
            return;
        }

        System.out.println(      //lose
                "   ^-^\n"
                + " / ^ ^ \\\n"
                + "(   \"\\  )\n"
                + " \\  3  /\n"
                + "  - ^ -  "
        );
        System.out.println("______________________________________");
    }

    public void decreaseHp(final Integer hp) {
        if(this.currentHp - hp < 0) {
            this.currentHp = 0;
            return;
        }

        this.currentHp -= hp;
    }

    public Integer attack() {
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        return random.nextInt(20);
    }
}