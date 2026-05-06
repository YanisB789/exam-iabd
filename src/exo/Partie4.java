package exo;

import models.Trip;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Partie4 {

    Function<Trip, String> byCity = Trip::city;
    Predicate<Trip> isPremium     = trip -> trip.price() > 30 && trip.rating() > 4;

    public double totalRevenueSequential(List<Trip> trips) {
        // stream()
        return trips.stream()
                .mapToDouble(Trip::price)
                .sum();
    }

    public double totalRevenueParallel(List<Trip> trips) {
        // parallelStream()
        return trips.parallelStream()
                .mapToDouble(Trip::price)
                .sum();
    }

    public Map<String, Long> countByCityParallel(List<Trip> trips) {
        // coder ici
        return trips.parallelStream()
                .collect(Collectors.groupingBy(byCity, Collectors.counting()));
    }

    public List<Trip> premiumTripsParallel(List<Trip> trips) {
        // prix > 30 et rating > 4
        return trips.parallelStream()
                .filter(isPremium)
                .collect(Collectors.toList());
    }
}
