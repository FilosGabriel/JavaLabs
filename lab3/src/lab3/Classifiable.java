package lab3;

/**
 * An interface for every location that is classifiable (has a rank)
 */

public interface Classifiable {
    /**
     * @return the number of stars a classifiable object has
     */
    public int getRank();

    /**
     * @param rank - the number of stars the object has
     */
    public void setRank(int rank);
}
