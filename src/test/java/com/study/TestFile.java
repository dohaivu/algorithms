package com.study;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("main")
public class TestFile {

    @Test
    @DisplayName("VS Code JUnit 5 test")
    void testMain() {

        // arrange
        final List<String> list = Arrays.asList("React", "Angular", "Vue");

        // act
        final String actual = list.stream()
            .filter(x -> Objects.equals(x, "React"))
            .findFirst()
            .orElse(null);

        // assert
        assertEquals("React", actual, () -> "Main Succeed");
    }
}