package bossmonster;

import bossmonster.domain.creatures.Creature;

public class TypeQualifier {
    public static boolean checkCreatureType(Class<? extends Creature> type, Creature checked) {
        try {
            type.cast(checked);
        } catch (ClassCastException e) {
            return false;
        }
        return true;
    }
}
