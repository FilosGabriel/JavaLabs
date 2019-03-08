package lab3;

import java.time.LocalTime;

/**
 * A class that represends a Museum node
 */

public class Museum extends Node implements Visitable, Payable {
    /**
     * the entry fee of the Museum
     */
    private int entryFee;
    /**
     * the hour at which the museum opens
     */
    private LocalTime openingHour = LocalTime.of(8, 0);
    /**
     * the hour at which the museum closes
     */
    private LocalTime closingHour = LocalTime.of(16, 0);

    public Museum(String name) {
        super(name);
    }

    public Museum(String name, int entryFee) {
        super(name);
        if (entryFee >= 0)
            this.entryFee = entryFee;
        else System.out.println("Costul de intrare nu poate fii negativ");
    }

    public Museum(String name, LocalTime openingHour, LocalTime closingHour) {
        super(name);
        if (openingHour.compareTo(closingHour) <= 0) {
            this.openingHour = openingHour;
            this.closingHour = closingHour;
        } else System.out.println("Orele specificate nu sunt valide");
    }

    public Museum(String name, int entryFee, LocalTime openingHour, LocalTime closingHour) {
        super(name);
        if (entryFee >= 0) this.entryFee = entryFee;
        else System.out.println("Costul nu poate fii negativ");
        if (openingHour.compareTo(closingHour) <= 0) {
            this.openingHour = openingHour;
            this.closingHour = closingHour;
        } else System.out.println("Orele specificate nu sunt valide");
    }

    @Override
    public int getEntryFee() {
        return this.entryFee;
    }

    @Override
    public void setEntryFee(int fee) {
        if (fee >= 0)
            this.entryFee = fee;
        else System.out.println("Costul de intrare nu poate fii negativ");
    }

    @Override
    public LocalTime getOpeningHours() {
//        return this.getName() + " is open from " + this.openingHour + " to " + this.closingHour;
        return openingHour;
    }
    @Override
    public LocalTime getClosingHours() {
//        return this.getName() + " is open from " + this.openingHour + " to " + this.closingHour;
        return closingHour;
    }


    @Override
    public void setOpeningHours(LocalTime opens, LocalTime closes) {
        if (opens.compareTo(closes) <= 0) {
            this.openingHour = opens;
            this.closingHour = closes;
        } else System.out.println("Orele specificate nu sunt corecte");
    }

    @Override
    public int compareTo(Visitable ob) {
        return openingHour.compareTo(ob.getOpeningHours());
    }
}
