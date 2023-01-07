package org.example.graph.bfs.bj12851;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MainTest {
    @Test
    @DisplayName("hello")
    void hello() throws Exception {
       hello(5,17,2);

    }

    private void hello(int a, int b, int result) {
        assertThat(Main.bfs(a, b)).isEqualTo(result);
    }



}