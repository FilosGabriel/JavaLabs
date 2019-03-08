package lab3;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main (String[] args)
    {
        Church c = new Church("Voroneti", LocalTime.of(12, 0), LocalTime.of(16, 0));
        Hotel v1 = new Hotel("California");
        Museum v2 = new Museum("Museum of Failure",2,LocalTime.of(12, 0), LocalTime.of(16, 0));
        Museum v3 = new Museum("A Simple museum");
        TravelMap map = new TravelMap();
        map.addNode(v1);
        map.addNode(v2);
        map.addEdge(v1, v2, 15);
        map.addEdge(v2, v3, 7, true);
        map.addNode(c);
        map.addNode(v3);
        System.out.println(map.getNodes());
        map.freeVisitable();
        map.averageTicketPayable();

    }
}
