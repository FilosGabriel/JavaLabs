package lab3;

/**
 * A class that represents the roads between nodes
 */

public class Edge {
    /**
     * The first node of the edge
     */
    private Node node1;
    /**
     * The second node of the edge
     */
    private Node node2;
    /**
     * The weight of the edge
     */
    private int weight;
    /**
     * false if the edge is uni-directional
     * true if the edge is bi-directional
     */
    private boolean twoWay;


    /**
     * A constructor for an edge that uses an argument to tell if it's uni-directional or bi-directional
     * @param node1 the first node of the edge
     * @param node2 the second node of the edge
     * @param weight the weight of the edge
     * @param twoWay a boolean that tells if the edge is bi-directional or uni-directional
     */
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


    /**
     * A constructor for an edge that is bi-directional
     * @param node1 the first node of the edge
     * @param node2 the second node of the edge
     * @param weight the weight of the edge
     */
    public Edge(Node node1, Node node2, int weight) {
        this(node1, node2, weight, true);
    }

    /**
     * @return the first node of the edge
     */
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
