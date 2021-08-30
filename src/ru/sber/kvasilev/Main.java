package ru.sber.kvasilev;

import java.util.List;

import static ru.sber.kvasilev.CityUtils.*;

public class Main {
    public static void main(String[] args) {
        List<City> listOfCities = parse();

        countCitiesInDistinct(listOfCities);
    }
}
