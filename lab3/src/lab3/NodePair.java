package lab3;

/**
 * A class that represent a pair between a node and his distance fromm another node
 */
public class NodePair  implements Comparable{
	/**
	 * A id of node
	 */
	private int node;
	/**
	 * His distance
	 */
	private int distance;


	/**
	 * @param node A id node
	 * @param distance His distance
	 */
	public NodePair(int node, int distance) {
		this.node = node;
		this.distance = distance;
	}

	public int getNode() {
		return node;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	@Override
	public int compareTo(Object o) {
		return -Integer.compare(((NodePair) o).distance, this.distance);
	}
}
