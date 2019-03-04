package lab3;

import java.time.LocalTime;

public class Main {
    public static void main (String[] args)
    {
        Church c = new Church("Voroneti", LocalTime.of(12, 0), LocalTime.of(16, 0));
        Hotel v1 = new Hotel("California");
    }
}
