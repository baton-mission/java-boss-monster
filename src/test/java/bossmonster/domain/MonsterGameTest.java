package bossmonster.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class MonsterGameTest {
    @Test
    void applyAttack() {
        Monster monster = Monster.fromHp(100);
        Player player = Player.of(new PlayerName("a"), PlayerVital.of(List.of(100, 100)));
        GameCharacters gameCharacters = GameCharacters.of(monster, player);
        MonsterGame monsterGame = new MonsterGame(gameCharacters, GameCount.init(), false);

        monsterGame.applyPlayerAttack(PlayerAttack.MAGICAL_ATTACK);
        monsterGame.applyMonsterAttack(new Hp(10));

        assertThat(player.getPlayerVital().getCurrentHp().getHp()).isEqualTo(90);
        assertThat(monster.getCurrentHp().getHp()).isEqualTo(80);
        assertThat(monsterGame.getGameCount().getGameCount()).isEqualTo(1);
    }

    @Test
    void isMonsterOver() {
        Monster monster = Monster.fromHp(100);
        Player player = Player.of(new PlayerName("a"), PlayerVital.of(List.of(100, 100)));
        GameCharacters gameCharacters = GameCharacters.of(monster, player);
        MonsterGame monsterGame = new MonsterGame(gameCharacters, GameCount.init(), false);

        monsterGame.applyPlayerAttack(PlayerAttack.MAGICAL_ATTACK);
        monsterGame.applyPlayerAttack(PlayerAttack.MAGICAL_ATTACK);
        monsterGame.applyPlayerAttack(PlayerAttack.MAGICAL_ATTACK);
        monsterGame.applyPlayerAttack(PlayerAttack.MAGICAL_ATTACK);
        monsterGame.applyPlayerAttack(PlayerAttack.MAGICAL_ATTACK);
        monsterGame.applyPlayerAttack(PlayerAttack.MAGICAL_ATTACK);

        assertThat(monsterGame.isMonsterOver()).isEqualTo(true);
    }

    @Test
    void isMonsterNotOver() {
        Monster monster = Monster.fromHp(100);
        Player player = Player.of(new PlayerName("a"), PlayerVital.of(List.of(100, 100)));
        GameCharacters gameCharacters = GameCharacters.of(monster, player);
        MonsterGame monsterGame = new MonsterGame(gameCharacters, GameCount.init(), false);

        monsterGame.applyPlayerAttack(PlayerAttack.MAGICAL_ATTACK);
        monsterGame.applyPlayerAttack(PlayerAttack.MAGICAL_ATTACK);
        monsterGame.applyPlayerAttack(PlayerAttack.MAGICAL_ATTACK);
        monsterGame.applyPlayerAttack(PlayerAttack.MAGICAL_ATTACK);

        assertThat(monsterGame.isMonsterOver()).isEqualTo(false);
    }

    @Test
    void 몬스터가_죽으면_플레이어에게_공격영향을_미치지_못한다() {
        Monster monster = Monster.fromHp(100);
        Player player = Player.of(new PlayerName("a"), PlayerVital.of(List.of(100, 100)));
        GameCharacters gameCharacters = GameCharacters.of(monster, player);
        MonsterGame monsterGame = new MonsterGame(gameCharacters, GameCount.init(), false);

        monsterGame.applyPlayerAttack(PlayerAttack.MAGICAL_ATTACK);
        monsterGame.applyPlayerAttack(PlayerAttack.MAGICAL_ATTACK);
        monsterGame.applyPlayerAttack(PlayerAttack.MAGICAL_ATTACK);
        monsterGame.applyPlayerAttack(PlayerAttack.MAGICAL_ATTACK);
        monsterGame.applyPlayerAttack(PlayerAttack.MAGICAL_ATTACK);
        monsterGame.applyMonsterAttack(new Hp(10));

        assertThat(player.getPlayerVital().getCurrentHp().getHp()).isEqualTo(100);
    }
}
