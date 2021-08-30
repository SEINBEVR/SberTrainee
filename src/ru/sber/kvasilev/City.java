package ru.sber.kvasilev;

/**
 * Класс описывающий объект типа City
 */
public class City {
    //Наименование города
    private String name;
    //Регион
    private String region;
    //Федеральный округ
    private String distinct;
    //Население
    private long population;
    //Дата основания или первое упоминание
    private String foundation;

    public City(String name, String region, String distinct, long population, String foundation) {
        this.name = name;
        this.region = region;
        this.distinct = distinct;
        this.population = population;
        this.foundation = foundation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDistinct() {
        return distinct;
    }

    public void setDistinct(String distinct) {
        this.distinct = distinct;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public String getFoundation() {
        return foundation;
    }

    public void setFoundation(String foundation) {
        this.foundation = foundation;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", distinct='" + distinct + '\'' +
                ", population=" + population +
                ", foundation='" + foundation + '\'' +
                '}';
    }
}
