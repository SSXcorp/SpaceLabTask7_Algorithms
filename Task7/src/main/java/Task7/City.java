package Task7;

public class City implements GraphNode {
    private final String id;
    private final String name;
    private final double latitude;
    private final double longitude;

    public City(String id, String name, double latitude, double longitude) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

//    @Override
//    public String toString() {
//        return new StringJoiner(", ", Station.class.getSimpleName() + "[", "]").add("id='" + id + "'")
//                .add("name='" + name + "'").add("latitude=" + latitude).add("longitude=" + longitude).toString();
//    }

    @Override
    public String toString() {
        return this.getName();
    }
}
