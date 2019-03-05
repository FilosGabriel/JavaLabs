package lab3;

import java.time.LocalTime;

public class Museum extends Node implements Visitable, Payable {
    private int entryFee;
    private LocalTime openingHour = LocalTime.of(8, 0);
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
        if (openingHour.compareTo(closingHour) <= 0)
        {
            this.openingHour = openingHour;
            this.closingHour = closingHour;
        }
        else System.out.println("Orele specificate nu sunt valide");
    }

    public Museum(String name, int entryFee, LocalTime openingHour, LocalTime closingHour) {
        super(name);
        if (entryFee >= 0) this.entryFee = entryFee;
        else System.out.println("Costul nu poate fii negativ");
        if (openingHour.compareTo(closingHour) <= 0)
        {
            this.openingHour = openingHour;
            this.closingHour = closingHour;
        }
        else System.out.println("Orele specificate nu sunt valide");
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
    public String getOpeningHours() {
        return this.getName() + " is open from " + this.openingHour + " to " + this.closingHour;
    }

    @Override
    public void setOpeningHours(LocalTime opens, LocalTime closes) {
        if (opens.compareTo(closes) <= 0) {
            this.openingHour = opens;
            this.closingHour = closes;
        }
        else System.out.println("Orele specificate nu sunt corecte");
    }
}
