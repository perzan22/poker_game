package org.perzan22.pokergame.model.player;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ActionTypeTest {

    @Test
    public void testFromCode_givenCorrectNumber_correctActionType() {
        // given
        int[] typeNumbers = new int[]{1,2,3,4};
        ActionType[] expected = new ActionType[]{
                ActionType.CHECK_CALL,
                ActionType.RAISE,
                ActionType.ALL_IN,
                ActionType.FOLD
        };

        // when
        for (int i : typeNumbers) {
            ActionType actionType = ActionType.fromCode(i);

            // then
            assertSame(expected[i-1], actionType, "Expected action type does not match for code: " + i);
        }
    }

    @Test
    public void testFromCode_givenInvalid_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> ActionType.fromCode(0), "Invalid action type code did not throw exception");
    }
}
