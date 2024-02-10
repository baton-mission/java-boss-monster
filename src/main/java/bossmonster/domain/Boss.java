package bossmonster.domain;

import java.util.Random;

public class Boss {
    private Integer maxHp;
    private Integer currentHp;

    public Boss(Integer hp) {
        this.maxHp = hp;
        this.currentHp = hp;
        printFigure(true);
    }

    public void printFigure(final Boolean isInitial) {
        System.out.println("============================");
        System.out.println("BOSS HP [" + this.currentHp + "/" + this.maxHp + "]");
        System.out.println("____________________________");

        if(isInitial) {
            System.out.println(
                    "   ^-^\n"
                    + " / 0 0 \\\n"
                    + "(   \"   )\n"
                    + " \\  -  /\n"
                    + "  - ^ -  "
            );
            System.out.println("____________________________");
            return;
        }

        System.out.println(
                "   ^-^\n"
                        + " / X X \\\n"
                        + "(   \"\\  )\n"
                        + " \\  -  /\n"
                        + "  - ^ -  "
        );
        System.out.println("____________________________");
    }

    public Integer getHp() { return this.currentHp; }
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