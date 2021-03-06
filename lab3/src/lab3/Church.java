package lab3;

import java.time.LocalTime;

/**
 * A class that represents a Church node
 */

public class Church extends Node implements Visitable {
    /**
     * the hour at which the Church opens
     */
    private LocalTime openingHour = LocalTime.of(10, 0);
    /**
     * the hour at which the Church closes
     */
    private LocalTime closingHour = LocalTime.of(12, 0);

    public Church(String name) {
        super(name);
    }

    public Church(String name, LocalTime openingHour, LocalTime closingHour) {
        super(name);
        if (openingHour.compareTo(closingHour) <= 0)
        {
            this.openingHour = openingHour;
            this.closingHour = closingHour;
        }
        else System.out.println("Orele specificate nu sunt corecte");
    }

    @Override
    public LocalTime getOpeningHours() {
//        return this.getName() + " is open from " + this.openingHour.toString() + " to " + this.closingHour.toString();
        return openingHour;
    }

    @Override
    public LocalTime getClosingHours() {
        return closingHour;
    }

    @Override
    public void setOpeningHours(LocalTime opens, LocalTime closes) {
        if (opens.compareTo(closes) <= 0) {
            this.openingHour = opens;
            this.closingHour = closes;
        }
        else System.out.println("Orele specificate nu sunt corecte");
    }
    @Override
    public int compareTo(Visitable ob) {
        return openingHour.compareTo(ob.getOpeningHours());
    }
}
