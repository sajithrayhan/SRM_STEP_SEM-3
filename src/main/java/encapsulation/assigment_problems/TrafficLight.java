package encapsulation.assigment_problems;

public class TrafficLight {
    private static final String[] CYCLE = {"RED", "GREEN", "YELLOW"};

    private final String id;
    private int position;               // index into CYCLE; only next() moves it

    public TrafficLight(String id) {
        this.id = id;
        this.position = 0;              // starts on RED
    }

    public String getId() {
        return id;
    }

    public String getColor() {
        return CYCLE[position];
    }

    public String next() {
        position = (position + 1) % CYCLE.length;
        return getColor();
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("TL-9");
        System.out.println(t.getColor());
        for (int i = 0; i < 5; i++) {
            System.out.println(t.next());
        }
    }
}
