package bossmonster.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @DisplayName("플레이어 이름이 비어있을 경우 예외가 발생함")
    @Test
    void emptyExceptionByPlayerName() {
        //given
        String name = "";
        int hp = 100;
        int mp = 100;

        //when, then
        assertThatThrownBy(() -> new Player(name, hp, mp))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("플레이어 이름이 5글자 초과될 경우 예외가 발생함")
    @Test
    void sizeExceptionByPlayerName() {
        //given
        String name = "abcdef";
        int hp = 100;
        int mp = 100;

        //when, then
        assertThatThrownBy(() -> new Player(name, hp, mp))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("플레이어 HP와 MP의 합이 200이 아닐 경우 예외가 발생함")
    @Test
    void sizeExceptionByPlayerStatus() {
        //given
        String name = "abcde";
        int hp = 99;
        int mp = 100;

        //when, then
        assertThatThrownBy(() -> new Player(name, hp, mp))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("물리 공격으로 공격할 경우 데미지는 10임")
    @Test
    void confirmDamageOfNormalAttack() {
        //given
        Player player = new Player("홍길동", 100, 100);
        AttackType normalAttack = AttackType.ATTACK_TYPE_NORMAL;

        //when
        int damage = player.attack(normalAttack);

        //then
        assertThat(damage).isEqualTo(10);
    }

    @DisplayName("마법 공격으로 공격할 경우 데미지는 20임")
    @Test
    void confirmDamageOfMagicAttack() {
        //given
        Player player = new Player("홍길동", 100, 100);
        AttackType magicAttack = AttackType.ATTACK_TYPE_MAGIC;

        //when
        int damage = player.attack(magicAttack);

        //then
        assertThat(damage).isEqualTo(20);
    }

    @DisplayName("마법 공격으로 공격할 경우 MP를 30 소모함")
    @Test
    void confirmConsumeOfNormalAttack() {
        //given
        Player player = new Player("홍길동", 100, 100);
        AttackType magicAttack = AttackType.ATTACK_TYPE_MAGIC;

        //when
        player.attack(magicAttack);
        int currentMP = player.getCurrentMP();

        //then
        assertThat(currentMP).isEqualTo(70);
    }

    @DisplayName("물리 공격으로 공격할 경우 MP를 10 회복함")
    @Test
    void confirmRecoverOfNormalAttack() {
        //given
        Player player = new Player("홍길동", 100, 100);
        AttackType normalAttack = AttackType.ATTACK_TYPE_NORMAL;
        AttackType magicAttack = AttackType.ATTACK_TYPE_MAGIC;

        //when
        player.attack(magicAttack);
        player.attack(normalAttack);
        int currentMP = player.getCurrentMP();

        //then
        assertThat(currentMP).isEqualTo(80);
    }

    @DisplayName("공격 받은 데미지 만큼 HP가 감소함")
    @Test
    void confirmDamagedByAttack() {
        //given
        Player player = new Player("홍길동", 100, 100);
        int damage = 30;

        //when
        player.takeDamage(damage);
        int currentHP = player.getCurrentHP();

        //then
        assertThat(currentHP).isEqualTo(70);
    }

    @DisplayName("HP가 0일 경우 플레이어는 죽음")
    @Test
    void confirmDieByZeroHP() {
        //given
        Player player = new Player("홍길동", 100, 100);
        int damage = 100;

        //when
        player.takeDamage(damage);
        int currentHP = player.getCurrentHP();
        boolean playerStatus = player.isAlive();

        //then
        assertThat(currentHP).isEqualTo(0);
        assertThat(playerStatus).isFalse();
    }
}