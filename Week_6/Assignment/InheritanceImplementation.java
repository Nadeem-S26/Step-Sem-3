package Week_6.Assignment;
class Weather {
    protected String condition;
    public Weather() {
        this("Unknown");
        System.out.println("Weather(): Default constructor called");
    }
    public Weather(String condition) {
        this.condition = condition;
        System.out.println("Weather(String): Constructor called with condition = " + condition);
    }
    public void display() {
        System.out.println("General weather condition: " + condition);
    }
}
class Storm extends Weather {
    protected int windSpeed;
    public Storm() {
        this("Stormy", 60);
        System.out.println("Storm(): Default constructor called");
    }
    public Storm(String condition, int windSpeed) {
        super(condition);
        this.windSpeed = windSpeed;
        System.out.println("Storm(String, int): Constructor called with windSpeed = " + windSpeed);
    }
    @Override
    public void display() {
        System.out.println("Storm with wind speed: " + windSpeed + " km/h");
    }
}
class Thunderstorm extends Storm {
    private boolean hasLightning;
    public Thunderstorm() {
        this("Thunderstorm", 80, true);
        System.out.println("Thunderstorm(): Default constructor called");
    }
    public Thunderstorm(String condition, int windSpeed, boolean hasLightning) {
        super(condition, windSpeed);
        this.hasLightning = hasLightning;
        System.out.println("Thunderstorm(String, int, boolean): Constructor called with lightning = " + hasLightning);
    }
    @Override
    public void display() {
        System.out.println("Thunderstorm with wind speed: " + windSpeed + " km/h and lightning: " + hasLightning);
    }
}
class Sunshine extends Weather {
    private int uvIndex;
    public Sunshine() {
        this("Sunny", 5);
        System.out.println("Sunshine(): Default constructor called");
    }
    public Sunshine(String condition, int uvIndex) {
        super(condition);
        this.uvIndex = uvIndex;
        System.out.println("Sunshine(String, int): Constructor called with UV index = " + uvIndex);
    }
    @Override
    public void display() {
        System.out.println("Sunshine with UV index: " + uvIndex);
    }
}
public class InheritanceImplementation {
    public static void main(String[] args) {
        Weather[] forecasts = new Weather[3];
        forecasts[0] = new Thunderstorm();
        forecasts[1] = new Sunshine();
        forecasts[2] = new Storm("Windy", 45);
        System.out.println("\n--- Weather Forecasts ---");
        for (Weather w : forecasts) {
            w.display();
        }
    }
}