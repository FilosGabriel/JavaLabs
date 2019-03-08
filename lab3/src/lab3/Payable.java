package lab3;

/**
 * An interface for every location that is payable (has an entry fee)
 */

public interface Payable {
    /**
     * @return the entry fee of a Payable object
     */
    public int getEntryFee();

    /**
     * @param fee the entry fee of a Payable object
     */
    public void setEntryFee(int fee);
}
