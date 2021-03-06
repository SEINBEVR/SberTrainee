package ru.sber.kvasilev;

import java.io.IOException;
import java.nio.file.Path;
import java.text.MessageFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Класс содержит статические методы, необходимые для обработки данных
 */
public class CityUtils {
    /**
     * Загрузка данных о городах в список
     *
     * @return коллекция, содержащая список с данными о городах
     */
    public static List<City> parse() {
        List<City> listOfCities = new ArrayList<>();
        Path fileNameDefined = Path.of("d:\\DATA\\SberTraineeData\\city_ru.csv");
        try {
            Scanner input = new Scanner(fileNameDefined);
            while (input.hasNextLine()) {
                listOfCities.add(parse(input.nextLine()));
            }
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  listOfCities;
    }

    /**
     * Преобразование строки в экземпляр класса City
     *
     * @param line строка для преобразования
     * @return новый объект типа City
     */
    public static City parse(String line) {
        Scanner lineScanner = new Scanner(line);
        lineScanner.useDelimiter(";");
        lineScanner.skip("\\d*");
        String name = lineScanner.next();
        String region = lineScanner.next();
        String distinct = lineScanner.next();
        long population = lineScanner.nextLong();
        String foundation = null;
        if(lineScanner.hasNext()) {
            foundation = lineScanner.next();
        }
        lineScanner.close();
        return new City(name, region, distinct, population, foundation);
    }

    /**
     * Вывод списка городов в консоль
     *
     * @param listOfCities коллекция, солержащая данные о городах для вывода
     */
    public static void printCities (List<City> listOfCities) {
        listOfCities.forEach(System.out::println);
    }

    /**
     * Сортировка данных о городах по их наименованиям в алфавитном порядке
     *
     * @param listOfCities список городов
     */
    public static void nameSorted (List<City> listOfCities) {
        listOfCities.sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
    }

    /**
     * Сортировка данных о городах по их федерольному округу и имени внутри федерального округа в алфавитном порядке
     *
     * @param listOfCities список городов
     */
    public static void distinctNameSorted (List<City> listOfCities) {
        listOfCities.sort(Comparator.comparing(City::getDistinct).thenComparing(City::getName));
    }

    /**
     * Нахождение города с наибольшим населением и его индекс
     *
     * @param listOfCities список городов
     */
    public static void mostPopulatedCity (List<City> listOfCities) {
        City[] arrayOfCities = listOfCities.toArray(new City[0]);
        long maxPopulation = arrayOfCities[0].getPopulation();
        int indexOfMostPopulatedCity = 1;
        for(int i = 1; i < arrayOfCities.length; i++) {
            if(maxPopulation < arrayOfCities[i].getPopulation()) {
                maxPopulation = arrayOfCities[i].getPopulation();
                indexOfMostPopulatedCity = i;
            }
        }
        System.out.println(MessageFormat.format("[{0}] = {1}", indexOfMostPopulatedCity, maxPopulation));
    }

    /**
     * Нахождение количества городов в каждом регионе
     *
     * @param listOfCities
     */
    public static void countCitiesInRegion (List<City> listOfCities) {
        Map<String, Long> resultMap = listOfCities.stream()
                .collect(Collectors.groupingBy((City::getRegion), Collectors.counting()));
        for(Map.Entry e : resultMap.entrySet()) {
            System.out.println(MessageFormat.format("{0} - {1}", e.getKey(), e.getValue()));
        }
    }
}
