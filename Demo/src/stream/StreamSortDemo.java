package stream;

/**
 * 数据流排序
 */

import java.util.stream.Stream;

public class StreamSortDemo {

    public static void main(String[] args) {
        String[] str = new String[]{"d2", "a2", "b1", "b3", "c"};
        System.out.println("法一：");
        Stream.of(str)
                .sorted((s1, s2) -> {
                    System.out.printf("sort: %s; %s\n", s1, s2);
                    return s1.compareTo(s2);
                })
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a");
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));

        System.out.println("法二");
        Stream.of(str)
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a");
                })
                .sorted((s1, s2) -> {
                    System.out.printf("sort: %s; %s\n", s1, s2);
                    return s1.compareTo(s2);
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> {
                    System.out.println("forEach: " + s);
                });
    }
}
