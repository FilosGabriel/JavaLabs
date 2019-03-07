package lab3;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.Temporal;

public interface Visitable extends Comparable<Visitable> {
    LocalTime getOpeningHours(); //un text precum "Deschis de la x la x", nush sigur daca e ok
    LocalTime getClosingHours();

    @Override
    int compareTo(Visitable o);

    public default void setOpeningHours(LocalTime opens, LocalTime closes){
//        this.openingHour = openingHour;
//        this.closingHour = closingHour;
    } //

    static Duration getVisitingDuration( Visitable location){
        Temporal startInclusive;
        Temporal endExclusive;
        Duration duration=Duration.between(location.getOpeningHours(),location.getClosingHours());
        return duration;
    }
}
