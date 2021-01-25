package Chapter1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author MrNiurh
 * @Date Creat in 2021/1/24
 * @Description 下游收集器
 * @See <a href="https://github.com/MrNiurh?tab=repositories">github</a>
 */
public class DownStreamCollectors {

    public static class City {
        private String name;
        private String state;
        private int population;

        public City(String name, String state, int population) {
            this.name = name;
            this.state = state;
            this.population = population;
        }

        public String getName() {
            return name;
        }

        public String getState() {
            return state;
        }

        public int getPopulation() {
            return population;
        }
    }

    public static Stream<City> readCities(String fileName) throws IOException {
        return Files.lines(Paths.get("Volume II", "src", "Resources", "txt", fileName))
                .map(l -> l.split(","))
                .map(a -> new City(a[0], a[1], Integer.parseInt(a[2])));
    }

    public static void main(String[] args) throws IOException {
        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
        locales = Stream.of(Locale.getAvailableLocales());
        Map<String, Set<Locale>> countryToLocaleSet = locales.collect(Collectors.groupingBy(
                Locale::getCountry, Collectors.toSet()));
        System.out.println("countryToLocaleSet:" + countryToLocaleSet);

        locales = Stream.of(Locale.getAvailableLocales());
        Map<String, Long> countryToLocaleCounts = locales.collect(Collectors.groupingBy(
                Locale::getCountry, Collectors.counting()));
        System.out.println("countryToLocaleCounts" + countryToLocaleCounts);

        Stream<City> cities = readCities("cities.txt");
        Map<String, Integer> stateToCityPopulation = cities.collect(Collectors.groupingBy(
                City::getState, Collectors.summingInt(City::getPopulation)));
        System.out.println("stateToCityPopulation" + stateToCityPopulation);

        cities = readCities("cities.txt");
        Map<String, Optional<String>> stateToLongestCityName = cities.collect(Collectors.groupingBy(
                City::getState, Collectors.mapping(City::getName, Collectors.maxBy(Comparator.comparing(String::length)))
        ));
        System.out.println("stateToLongestCityName" + stateToLongestCityName);

        locales = Stream.of(Locale.getAvailableLocales());
        Map<String, Set<String>> countryToLanguages = locales.collect(Collectors.groupingBy(
                Locale::getDisplayCountry, Collectors.mapping(Locale::getDisplayLanguage, Collectors.toSet())
        ));
        System.out.println("countryToLanguages" + countryToLanguages);

        cities = readCities("cities.txt");
        Map<String, IntSummaryStatistics> stateToCityPopulationSummary = cities.collect(Collectors.groupingBy(
                City::getState, Collectors.summarizingInt(City::getPopulation)
        ));
        System.out.println(stateToCityPopulationSummary.get("NY"));

        cities = readCities("cities.txt");
        Map<String, String> stateToCityNames = cities.collect(Collectors.groupingBy(
                City::getState, Collectors.reducing("", City::getName, (s, t) -> s.length() == 0 ? t : s + "," + t)
        ));

        cities = readCities("cities.txt");
        stateToCityNames = cities.collect(Collectors.groupingBy(
                City::getState, Collectors.mapping(City::getName, Collectors.joining(", "))
        ));

    }
}
