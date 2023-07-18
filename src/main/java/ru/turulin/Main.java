package ru.turulin;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Map<String, List<Integer>> duplicates = getDuplicates(new String[]{"qwe", "wqe", "qwee", "a", "a"});
        duplicates.forEach((k, v) -> System.out.println(k + ":  " + v));
    }

    public static Map<String, List<Integer>> getDuplicates(final String[] args) {
        String[] newArgs = args.clone();
        Map<String, List<Integer>> dublicatesMap = new HashMap<>();
        for (int i = 0; i < newArgs.length; ++i) {
            char[] copyCharString = newArgs[i].toCharArray();
            Arrays.sort(copyCharString);
            String sortedCharsString = String.valueOf(copyCharString);
            if (dublicatesMap.containsKey(sortedCharsString))
                dublicatesMap.get(sortedCharsString).add(i);
            else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                dublicatesMap.put(sortedCharsString, list);
            }
        }
        dublicatesMap = dublicatesMap.entrySet().stream()
                .filter((entry) -> entry.getValue().size() > 1)
                .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));
        return dublicatesMap;
    }
}