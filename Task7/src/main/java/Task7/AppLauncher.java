package Task7;

import java.util.*;

public class AppLauncher {
    public static void main(String[] args) {
        City sofia = new City("Sofia", "Sofia", 42.7, 23.32);
        City blagoevgrad = new City("Blagoevgrad", "Blagoevgrad", 42.02, 23.1);
        City burgas = new City("Burgas", "Burgas", 42.51, 27.47);
        City varna = new City("Varna", "Varna", 43.22, 27.92);
        City vidin = new City("Vidin", "Vidin", 43.99, 22.88);
        City gabrovo = new City("Gabrovo", "Gabrovo", 42.87, 25.33);
        City dobrich = new City("Dobrich", "Dobrich", 43.57, 27.83);

        // Create connections between stations
        Map<String, Set<String>> connections = new HashMap<>();
        connections.put("Sofia", new HashSet<>(Arrays.asList("Blagoevgrad", "Burgas", "Vidin")));
        connections.put("Blagoevgrad", new HashSet<>(Arrays.asList("Sofia", "Gabrovo", "Dobrich")));
        connections.put("Burgas", new HashSet<>(Arrays.asList("Sofia")));
        connections.put("Varna", new HashSet<>(Arrays.asList("Dobrich", "Vidin")));
        connections.put("Vidin", new HashSet<>(Arrays.asList("Sofia", "Varna")));
        connections.put("Gabrovo", new HashSet<>(Arrays.asList("Blagoevgrad")));
        connections.put("Dobrich", new HashSet<>(Arrays.asList("Blagoevgrad", "Varna")));


        // Create a graph
        Graph<City> graph = new Graph<>(Set.of(sofia, blagoevgrad, burgas, varna, vidin, gabrovo, dobrich), connections);

        // Create a RouteFinder with HaversineScorer
        RouteFinder<City> routeFinder = new RouteFinder<>(graph, new HaversineScorer(), new HaversineScorer());

        // Find and print a route from sofia to varna
        List<City> route = routeFinder.findRoute(sofia, varna);
        System.out.println("Route from Earl's Court to Angel: " + route);
    }
}

//Изначально наше множество имеет только одну стартовую точку, предыдущего узла для которого просто не существуют, поэтому
// оценка 0. , а вторая - как далеко точка находится от пункта назначения
//
