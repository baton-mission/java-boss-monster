package bossmonster.view.outputview;

public enum BossSprite {
    BOSS_IDLE("""
               ^-^
             / 0 0 \\
            (   "   )
             \\  -  /
              - ^ -
              """),

    BOSS_WIN("""
               ^-^
             / ^ ^ \\
            (   "   )
             \\  3  /
              - ^ -
               """),

    BOSS_DAMAGED("""
               ^-^
             / x x \\
            (   "\\  )
             \\  ^  /
              - ^ -
               """);
    private final String sprite;

    BossSprite(String sprite) {
        this.sprite = sprite;
    }

    public String getSprite() {
        return sprite;
    }
}
