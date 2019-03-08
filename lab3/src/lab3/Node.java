package lab3;

/**
 * A general class that represents any type of node
 */

public abstract class Node {
    /**
     * the name of a Node object
     */
    private String name;

    /**
     * An initializer for a node that has a name
     * @param name - The name of the object
     */
    public Node(String name) {
        this.name = name;
    }

    /**
     * @return the name of the object
     */
    public String getName() {
        return name;
    }

    /**
     * Changes the name of the Node object
     * @param name The new name of the Node object
     */
    public void setName(String name) {
        this.name = name;
    }


}
