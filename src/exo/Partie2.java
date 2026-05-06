package exo;

import models.Trip;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Partie2 {
    
    Function<Trip, String> byCity   = Trip::city;
    Function<Trip, String> byDriver = Trip::driverId;

    public Map<String, Long> countByCity(List<Trip> trips) {
        // coder ici
        return trips.stream()
                .collect(Collectors.groupingBy(byCity, Collectors.counting()));
    }

    public Map<String, Double> revenueByDriver(List<Trip> trips) {
        // revenu par chauffeur
        // coder ici
        return trips.stream()
                .collect(Collectors.groupingBy(byDriver, Collectors.summingDouble(Trip::price)));
    }

    public Map<String, Double> avgDurationByCity(List<Trip> trips) {
        // coder ici
        // durée moyenne par ville
        return trips.stream()
                .collect(Collectors.groupingBy(byCity, Collectors.averagingDouble(Trip::durationMin)));
    }
}
