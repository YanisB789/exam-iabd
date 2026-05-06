package exo;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import models.Trip;

public class Partie1 {

    Predicate<Trip> longAndExpensive = trip -> trip.distanceKm() > 10 && trip.price() > 20;
    Predicate<Trip> bad = trip -> trip.rating() < 3;
    Predicate<Trip> recent = trip -> {
        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);
        LocalDate tripDate = trip.startTime().toLocalDate();
        return tripDate.equals(today) || tripDate.equals(yesterday);
    };

    public List<Trip> longAndExpensiveTrips(List<Trip> trips) {
        // distance > 10km et prix > 20€
        return trips.stream()
                .filter(longAndExpensive)
                .collect(Collectors.toList());
    }

    public List<Trip> badTrips(List<Trip> trips) {
        // rating < 3
        return trips.stream()
                .filter(bad)
                .collect(Collectors.toList());
    }

    public List<Trip> recentTrips(List<Trip> trips) {
        // aujourd’hui ou hier
        return trips.stream()
                .filter(recent)
                .collect(Collectors.toList());
    }
}
