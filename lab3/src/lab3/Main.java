package lab3;

import java.time.LocalTime;

public class Main {
    public static void main (String[] args)
    {
        Church c = new Church("Voroneti", LocalTime.of(12, 0), LocalTime.of(16, 0));
        Hotel v1 = new Hotel("California");
        Museum v2 = new Museum("Museum of Failure");
        Museum v3 = new Museum("ASimple museum");
        TravelMap map = new TravelMap();
        map.addNode(v1);
        map.addNode(v2);
        map.addEdge(v1, v2, 15);
        map.addNode(c);
        map.addNode(v3);
        System.out.println(map.getNodes());
    }
}
