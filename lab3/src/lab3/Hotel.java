package lab3;

public class Hotel extends Node implements Classifiable {
    private int rank = 0;
    private int roomCost = 0; //nush daca e ok numit entryFee
    private int nrOfRooms = 0;

    public Hotel(String name) {
        super(name);
    }

    public Hotel(String name, int rank) {
        super(name);
        if (rank >= 0 && rank <= 5)
            this.rank = rank;
        else System.out.println("Rankul poate fii doar intre 0 si 5");
    }

    public Hotel(String name, int roomCost, int nrOfRooms) {
        super(name);
        if (roomCost >= 0)
            this.roomCost = roomCost;
        else System.out.println("Costul camerei nu poate fii negativ");
        if (nrOfRooms >= 0)
                this.nrOfRooms = nrOfRooms;
        else System.out.println("Numarul de camare nu poate fii negativ");
    }

    public Hotel(String name, int rank, int roomCost, int nrOfRooms) { //nu cred ca avem nevoie de asa multi constructuri, dar oricum erau usor de generat
        super(name);
        if (roomCost >= 0) this.roomCost = roomCost;
        else System.out.println("Costul unei camere nu poate fii negativ");
        if (nrOfRooms >= 0) this.nrOfRooms = nrOfRooms;
        else System.out.println("Numarul de camare nu poate fii negativ");
        if (rank >= 0 && rank <= 5) this.rank = rank;
        else System.out.println("Rankul nu poate fii negativ");
    }

    public int getRoomCost() {
        return roomCost;
    }

    public void setRoomCost(int roomCost) {
        if (roomCost >= 0)
            this.roomCost = roomCost;
        else System.out.println("Costul camerei nu poate fii negativ");
    }

    public int getNrOfRooms() {
        return nrOfRooms;
    }

    public void setNrOfRooms(int nrOfRooms) {
        if (nrOfRooms >= 0)
            this.nrOfRooms = nrOfRooms;
        else System.out.println("Numarul de camaere nu poate fii negativ");
    }

    @Override
    public int getRank() {
        return this.rank;
    }

    @Override
    public void setRank(int rank) {
        if (rank >= 0 && rank <= 5)
            this.rank = rank;
        else System.out.println("Rankul poate fii doar intre 0 si 5");
    }
}
