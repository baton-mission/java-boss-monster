package bossmonster.view.outputview;

import bossmonster.domain.attack.AttackType;
import bossmonster.dto.BattleDTO;
import bossmonster.view.OutputView;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Consumer;

import static bossmonster.controller.Parameter.*;

public class BattleOutputView implements OutputView {
    private final ErrorOutputView errorOutputView;
    private final Map<String, Consumer<Object>> textMap = Map.ofEntries
            (
                    Map.entry(PLAYER_ATTACK_SELECT.getName(), viewSelectAttack()),
                    Map.entry(BOSS_ATTACK.getName(), viewBossAttack()),
                    Map.entry(PLAYER_ATTACK.getName(), viewPlayerAttack())
            );


    public BattleOutputView(ErrorOutputView errorOutputView) {
        this.errorOutputView = errorOutputView;
    }

    @Override
    public void show(Map<String, String> param, Map<String, Object> model) {
        if (param.containsKey(ERROR.getName())) {
            viewError(param, model);
        }

        textMap.forEach((name, value) -> {
            if (model.containsKey(name)) {
                value.accept(model.get(name));
                model.remove(name);
            }
        });
    }

    private void viewError(Map<String, String> param, Map<String, Object> model) {
        errorOutputView.show(param, model);
        param.remove(ERROR.getName());
    }

    private Consumer<Object> viewSelectAttack() {
        return param -> {
            System.out.println("어떤 공격을 하시겠습니까?");
            Arrays.stream(AttackType.Player.values()).forEach(this::printAttack);
        };
    }

    private void printAttack(AttackType.Player type) {
        System.out.println(type.getTypeNumber() + ". " + type.getAttackName());
    }

    private Consumer<Object> viewPlayerAttack() {
        return param ->
        {
            BattleDTO dto = (BattleDTO) param;
            String name = dto.getAttackName();
            int damage = dto.getDamage();
            System.out.println(name + "을 했습니다. (입힌 데미지 : " + damage + ")");
        };
    }

    private Consumer<Object> viewBossAttack() {
        return param ->
        {
            BattleDTO dto = (BattleDTO) param;
            String name = dto.getAttackName();
            int damage = dto.getDamage();
            System.out.println(name + "가 공격 했습니다. (입힌 데미지 : " + damage + ")");
        };
    }
}
