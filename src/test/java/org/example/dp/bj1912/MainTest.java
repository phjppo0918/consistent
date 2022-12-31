package org.example.dp.bj1912;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MainTest {
    @Test
    @DisplayName("")
    void test() throws Exception {
        compareResult("10 -4 3 1 5 6 -35 12 21 -1", 33);
        compareResult("2 1 -4 3 4 -4 6 5 -5 1", 14);
        compareResult("-1 -2 -3 -4 -5", -1);
    }

    void compareResult(String elements, long expected) {
        assertThat(Main.getMax(elements)).isEqualTo(expected);
    }
}