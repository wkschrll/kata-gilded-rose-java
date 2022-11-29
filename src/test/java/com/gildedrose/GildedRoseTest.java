package com.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

public class GildedRoseTest {

    @Test
    public void executeGoldenMasterTest() throws IOException {
        String originalOutput = Files.readString(Paths.get("goldenMasterTemplate.txt"));
        String actualOutput = TexttestFixture.executeGoldenMasterTest(new String[0]);
        assertEquals(originalOutput, actualOutput);
    }

}
