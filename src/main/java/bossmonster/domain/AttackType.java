package bossmonster.domain;

import bossmonster.ExceptionMessage;

import java.util.Arrays;
import java.util.Optional;

public enum AttackType {
	PHYSICAL(1, "물리 공격", 10),
	MAGIC(2, "마법 공격", 20);

	private final int typeNumber;
	private final String typeName;
	private final int damage;

	AttackType(int typeNumber, String typeName, int damage) {
		this.typeNumber = typeNumber;
		this.typeName = typeName;
		this.damage = damage;
	}

	public static AttackType findByNumber(int typeNumber) {
		Optional<AttackType> findType = Arrays.stream(values()).
				filter(type -> type.typeNumber == typeNumber)
				.findAny();
		if (findType.isEmpty()) {
			throw new IllegalArgumentException(ExceptionMessage.ATTACK_TYPE_NO_MATCH);
		}
		return findType.get();
	}
}
