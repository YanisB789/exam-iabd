import exo.Partie1;
import exo.Partie2;
import factory.TripFactory;
import models.Trip;

import java.util.List;

void main() {
    // Petite liste pour tester et afficher
    List<Trip> trips = TripFactory.generateTrips(10);

    Partie1 partie1 = new Partie1();

    System.out.println("=== longAndExpensiveTrips ===");
    List<Trip> longAndExpensive = partie1.longAndExpensiveTrips(trips);
    longAndExpensive.forEach(System.out::println);
    System.out.println("Total : " + longAndExpensive.size());

    System.out.println("\n=== badTrips ===");
    List<Trip> bad = partie1.badTrips(trips);
    bad.forEach(System.out::println);
    System.out.println("Total : " + bad.size());

    System.out.println("\n=== recentTrips ===");
    List<Trip> recent = partie1.recentTrips(trips);
    recent.forEach(System.out::println);
    System.out.println("Total : " + recent.size());

    System.out.println("\n=== Tous les trips générés ===");
    trips.forEach(System.out::println);

    Partie2 partie2 = new Partie2();

    System.out.println("=== countByCity ===");
    partie2.countByCity(trips).forEach((city, count) ->
        System.out.println(city + " : " + count));

    System.out.println("\n=== revenueByDriver ===");
    partie2.revenueByDriver(trips).forEach((driver, revenue) ->
        System.out.println(driver + " : " + revenue));

    System.out.println("\n=== avgDurationByCity ===");
    partie2.avgDurationByCity(trips).forEach((city, avg) ->
        System.out.println(city + " : " + avg));


}

