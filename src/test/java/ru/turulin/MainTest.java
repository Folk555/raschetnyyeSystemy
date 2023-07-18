package ru.turulin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class MainTest {

    @Test
    void main_promtArraysNotChanged() {
        String[] strs = {"zdcba", "abcdz", "abc", "abc"};
        String[] strsCopy = strs.clone();

        Main.getDuplicates(strs);

        assertNotEquals(strs, strsCopy, "указатели указывают на единый объект, для тест нужно 2 одинаковых, независимых");
        assertEquals(0, Arrays.compare(strs, strsCopy), "Произошло изменение промта");
    }

    @ParameterizedTest
    @CsvSource({"promt.txt,promtResult.txt",
            "promt2.txt,promt2Result.txt",
            "promt3.txt,promt3Result.txt"})
    void getDuplicates(String req, String ans) throws IOException {
        String rootPathString = "src/test/resources/";
        Path requestFilePath = Path.of(rootPathString + req);
        Path answerFilePath = Path.of(rootPathString + ans);
        String[] array = Files.readAllLines(requestFilePath).toArray(new String[0]);
        Map<String, List<Integer>> expectedMap = Files.readAllLines(answerFilePath).stream()
                .collect(Collectors.toMap(
                        e -> e.split(":")[0],
                        e -> Arrays.stream(e.split(":")[1].split(",")).map(Integer::valueOf).toList()
                ));

        Map<String, List<Integer>> actualDuplicates = Main.getDuplicates(array);

        Assertions.assertEquals(expectedMap, actualDuplicates);
    }

    @ParameterizedTest
    @CsvSource({"promt4.txt,promt4Result.txt",
            "promt5.txt,promt5Result.txt"})
    void negative_getDuplicates(String req, String ans) throws IOException {
        String rootPathString = "src/test/resources/";
        Path requestFilePath = Path.of(rootPathString + req);
        Path answerFilePath = Path.of(rootPathString + ans);
        String[] array = Files.readAllLines(requestFilePath).toArray(new String[0]);
        Map<String, List<Integer>> expectedMap = Files.readAllLines(answerFilePath).stream()
                .collect(Collectors.toMap(
                        e -> e.split(":")[0],
                        e -> Arrays.stream(e.split(":")[1].split(",")).map(Integer::valueOf).toList()
                ));

        Map<String, List<Integer>> actualDuplicates = Main.getDuplicates(array);

        Assertions.assertNotEquals(expectedMap, actualDuplicates);
    }
}