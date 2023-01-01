package org.example.dp.bj11057;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MainTest {

    @Test
    @DisplayName("hello")
    void hello() throws Exception {
        getResult(1, 10);
        getResult(2, 55);
        getResult(3, 220);
    }
    private void getResult(int num, long expected) {
        assertThat(Main.getCount(num)).isEqualTo(expected);
    }
}