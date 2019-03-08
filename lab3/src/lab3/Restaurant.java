package lab3;

/**
 * A class that represents a Restaurant node
 */

public class Restaurant extends Node implements Classifiable {
    /**
     * the cost of a meal at the restaurant
     */
    private int mealCost = 0;
    /**
     * the rank/number of stars of the restaurant
     */
    private int rank = 0;

    public Restaurant(String name) {
        super(name);
    }

    public Restaurant(String name, int rank) {
        super(name);
        if (rank >= 0 && rank <= 5)
            this.rank = rank;
        else System.out.println("Rankul trebuie sa fie intre 0 si 5");
    }

    public Restaurant(String name, int mealCost, int rank) {
        super(name);
        if (mealCost >= 0)
            this.mealCost = mealCost;
        else System.out.println("Costul unei mese nu poate fii negativ");
        if (rank >= 0 && rank <= 5)
            this.rank = rank;
        else System.out.println("Rankul trebuie sa fie intre 0 si 5");
    }

    public int getMealCost() {
        return mealCost;
    }

    public void setMealCost(int mealCost) {
        if (mealCost >= 0)
            this.mealCost = mealCost;
        else System.out.println("Costul unei mese nu poate fii negativ");
    }

    @Override
    public int getRank() {
        return this.rank;
    }

    @Override
    public void setRank(int rank) {
        if (rank >= 0 && rank <= 5)
            this.rank = rank;
        else System.out.println("Rankul trebuie sa fie doar intre 0 si 5");
    }
}
