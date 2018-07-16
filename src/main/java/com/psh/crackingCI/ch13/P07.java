package com.psh.crackingCI.ch13;

import com.google.common.collect.Lists;

import java.util.List;

public class P07 {

    public static void main(String[] args) {
        List<Country> countries = Lists.newArrayList(
                new Country("A", 100),
                new Country("B", 200),
                new Country("A",
                        100),
                new Country("C", 300)
                );

        System.out.println(getPopulation(countries, "A"));
    }

    public static int getPopulation(List<Country> countries, String continent) {
        return countries.stream()
                .filter(c -> c.getContinent().equals(continent))
                .mapToInt(Country::getPopulation).sum();
    }


}

class Country {
    String continent;
    int population;

    public Country(String continent, int population) {
        this.continent = continent;
        this.population = population;
    }

    public int getPopulation() {
        return population;
    }

    public String getContinent() {
        return continent;
    }
}