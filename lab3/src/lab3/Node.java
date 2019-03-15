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
     * His unique id
     */
    private  int idNode;

    /**
     * The number of node created
     */
    private static int numberNode=0;
    /**
     * An initializer for a node that has a name
     * @param name - The name of the object
     */
    public Node(String name) {
        this.name = name;
        numberNode++;
        idNode=numberNode;
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


    /**
     * @return Id of node
     */
    public int getIdNode(){return  idNode;}

}
