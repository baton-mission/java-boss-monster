package bossmonster.dto.response;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import bossmonster.domain.AttackType;

public class AttackTypeDto {

    private final Map<Integer, String> attackTypeMap;

    public AttackTypeDto() {
        this.attackTypeMap = getAttackTypeMap();
    }

    public Map<Integer, String> getAttackTypeMap() {
        return Stream.of(AttackType.values())
                .collect(Collectors.toMap(
                        AttackType::getAttackTypeCode,
                        AttackType::getAttackTypeName));

    }

}
