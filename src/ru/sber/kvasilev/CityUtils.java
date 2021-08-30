package ru.sber.kvasilev;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
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
     * @return список городов
     */
    public static List<City> nameSorted (List<City> listOfCities) {
        return listOfCities.stream().sorted(Comparator.comparing(City::getName)).collect(Collectors.toList());
    }

    /**
     * Сортировка данных о городах по их федерольному округу и имени внутри федерального округа в алфавитном порядке
     *
     * @param listOfCities список городов
     * @return список городов
     */
    public static List<City> distinctNameSorted (List<City> listOfCities) {
        return listOfCities.stream().sorted(Comparator.comparing(City::getDistinct).thenComparing(City::getName)).collect(Collectors.toList());
    }


}
