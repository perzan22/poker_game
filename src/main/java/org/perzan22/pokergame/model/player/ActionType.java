package org.perzan22.pokergame.model.player;

public enum ActionType {
    CHECK_CALL(1),
    RAISE(2),
    ALL_IN(3),
    FOLD(4);

    private final int code;

    ActionType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    // read actionType type from number code
    public static ActionType fromCode(int code) {
        for (ActionType action : ActionType.values()) {
            if (action.getCode() == code) {
                return action;
            }
        }
        throw new IllegalArgumentException("Nieznany kod akcji: " + code);
    }
}
