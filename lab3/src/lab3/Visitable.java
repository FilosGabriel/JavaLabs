package lab3;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.Temporal;

/**
 * An interface for every location that is visitable (has opening hours)
 */

public interface Visitable extends Comparable<Visitable> {


    /**
     * @param o an object that implements Visitable
     * @return the comparasion between openingHour of the objects
     */
    @Override
    int compareTo(Visitable o);

    default LocalTime getOpeningHours(){
        return  LocalTime.of(9,30);
    }
    default LocalTime getClosingHours(){
        return  LocalTime.of(20,0);
    }

    /**
     * @param location A location we want to find the duration
     * @return the duration for which the location is open
     */
    static Duration getVisitingDuration( Visitable location){
        Temporal startInclusive;
        Temporal endExclusive;
        Duration duration=Duration.between(location.getOpeningHours(),location.getClosingHours());
        return duration;
    }
}
