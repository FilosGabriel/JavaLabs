package lab3;

public class Edge {
    private Node node1; //nush ce nume sa pun la variabile
    private Node node2;
    private int weight;
    private boolean twoWay;

    public Edge(Node node1, Node node2, int weight) {
        //Verificam daca costul  e pozitiv
        if (weight >= 0) {  //Ma gandeam ca nu e ok sa initializezi o muchie fara cost si de aia daca e negativ nu initializez deloc muchia
            this.node1 = node1;
            this.node2 = node2;
            this.weight = weight;
            this.twoWay = true;
        }
        else System.out.println("Costul unei muchii nu poate fi negativ");
    }

    public Edge(Node node1, Node node2, int weight, boolean twoWay) {
        if (weight >= 0)
        {
            this.node1 = node1;
            this.node2 = node2;
            this.weight = weight;
            this.twoWay = twoWay;
        }
        else System.out.println("Costul unei muchii nu poate fii negativ");
    }

    public Node getNode1() {
        return node1;
    }

    public void setNode1(Node node1) {
        this.node1 = node1;
    }

    public Node getNode2() {
        return node2;
    }

    public void setNode2(Node node2) {
        this.node2 = node2;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        if (weight >= 0)
            this.weight = weight;
        else System.out.println("Costul unei muchii nu poate fii negativ");
    }

    public boolean isTwoWay() {
        return twoWay;
    }

    public void setTwoWay(boolean twoWay) {
        this.twoWay = twoWay;
    }
}
