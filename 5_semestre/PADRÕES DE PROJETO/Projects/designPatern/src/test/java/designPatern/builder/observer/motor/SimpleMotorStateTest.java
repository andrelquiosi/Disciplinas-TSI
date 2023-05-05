package designPatern.builder.observer.motor;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SimpleMotorStateTest {

    @Test
    void test() {
        fail("Not yet implemented");
    }

    @Test
    void testAccelerationFraction() {

    }

    @Test
    void shouldReturnCorrectClone() {

        MotorState state = new SimpleMotorState(

                MotorState.Status.ON,
                1100f,
                0.1f);

        MotorState clone = state.clone();

        boolean areDifferentRefs = (state != clone);
        assertTrue(areDifferentRefs);

        boolean areEquals = state.equals(clone);
        assertTrue(areEquals);

    }

    @Test
    void testCurrentStatus() {

    }

    @Test
    void testRotatiosPerMinute() {

    }
}
