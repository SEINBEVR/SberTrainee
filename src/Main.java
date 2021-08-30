import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<City> listOfCities = new ArrayList<>();

        Path fileNameDefined = Path.of("d:\\DATA\\SberTraineeData\\city_ru.csv");
        Scanner input = null;
        try {
            input = new Scanner(fileNameDefined);
        } catch (IOException e) {
            e.printStackTrace();
        }

            while (input != null && input.hasNextLine()) {
                String line = input.nextLine();
                String[] fields = line.split(";");
                if (fields.length == 6) {
                    String name = fields[1];
                    String region = fields[2];
                    String distinct = fields[3];
                    long population = Long.parseLong(fields[4]);
                    String foundation = fields[5];
                    listOfCities.add(new City(name, region, distinct, population, foundation));
                }
            }

        for(City city : listOfCities) {
            System.out.println(city);
        }
    }
}
