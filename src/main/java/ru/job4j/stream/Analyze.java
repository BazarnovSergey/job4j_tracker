package ru.job4j.stream;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {
    /**
     * 1. Метод averageScore - с этим методом все достаточно просто, для реализации понадобятся методы:
     * <p>
     * - flatMap() для преобразования в поток объектов Subject;
     * <p>
     * - mapToInt() для последующего преобразования в потом оценок по каждому предмету;
     * <p>
     * - average() для расчета среднего бала по предмету;
     * <p>
     * - orElse() для того чтобы вернуть значение по умолчанию.
     *
     * @param stream
     * @return
     */
    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(subjects -> subjects.getSubjects().stream())
                .mapToInt(Subject::getScore)
                .average()
                .orElse(0D);
    }

    /**
     * 2. Метод averageScoreBySubject - поскольку нам надо выполнить преобразование в поток объектов
     * класса Tuple, последовательность будет следующей:
     * <p>
     * - метод map() для преобразования в поток объектов класса Tuple, внутри метода мы будем создавать
     * эти объекты - там будет фигурировать строка new Tuple();
     * <p>
     * - при этом в конструктор первым параметром будет передаваться имя текущего объекта Pupil
     * - используем соответствующий геттер;
     * <p>
     * - вторым параметром рассчитанный средний балл - расчет можно произвести по той же
     * последовательности, что описана для метода averageScore;
     *
     * @param stream
     * @return
     */
    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.map(pupil -> new Tuple(pupil.getName(), averageScore(Stream.of(pupil))))
                .collect(Collectors.toList());
    }

    /**
     * 3. Метод averageScoreByPupil - реализация этого метода несколько сложна, поскольку в данном
     * случае требуется выполнить промежуточный сбор данных в Map(). Опишем вкратце алгоритм:
     * <p>
     * - flatMap() для преобразования в поток объектов Subject;
     * <p>
     * - метод collect() в который мы передаем метод groupingBy() (с тремя параметрами) класса Collectors.
     * При этом карта собирается следующим образом: ключ (первый параметр) - это имя предмета,
     * второй параметр - тип карты, который будем использовать
     * (в нашем случае нужен LinkedHashMap::new, который позволит хранить пары ключ-значение
     * в порядке поступления), значение карты (третий параметр) - средний балл по этому предмету
     * для каждого ученика. Для расчета среднего балла используйте
     * метод averagingDouble() класса Collectors;
     * <p>
     * - после этого собранную карту мы разбираем с помощью entrySet() и открываем поток с помощью stream();
     * <p>
     * - полученный поток с помощью map() преобразуем в поток объектов класса Tuple,
     * внутри метода мы будем создавать эти объекты - там будет фигурировать строка new Tuple();
     * <p>
     * - в конструктор мы будем передавать параметры с помощью методов getKey() и getValue()
     * интерфейса Entry;
     * <p>
     * - последним методом будет collect(), с помощью которого мы все соберем в коллекцию List.
     *
     * @param stream
     * @return
     */
    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.flatMap(subjects -> subjects.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName, LinkedHashMap::new,
                        Collectors.averagingDouble(Subject::getScore)))
                .entrySet()
                .stream().map(a -> new Tuple(a.getKey(), a.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(pupil -> new Tuple(pupil.getName(), pupil.getSubjects().stream()
                        .mapToInt(Subject::getScore)
                        .sum()))
                .max(Comparator.comparing(Tuple::getScore))
                .orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream
                .flatMap(subjects -> subjects.getSubjects().stream())
                .collect(Collectors.groupingBy(
                        Subject::getName, LinkedHashMap::new,
                        Collectors.summingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(a -> new Tuple(a.getKey(), a.getValue()))
                .max(Comparator.comparing(Tuple::getScore))
                .orElse(null);
    }
}
