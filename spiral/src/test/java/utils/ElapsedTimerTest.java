package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElapsedTimerTest {

    @Test
    void testElapsedTimer() {
        try {
            ElapsedTimer.start();
        } catch (Exception e) {
            fail(e);
        }
    }
}