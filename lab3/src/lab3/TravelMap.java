package lab3;

import java.util.*;

/**
 * A class that represents a collection of nodes and the edges between them
 */

public class TravelMap {
	/**
	 * The list of nodes that are part of the TravelMap object
	 */
	private List<Node> nodes = new ArrayList<Node>(100);
	/**
	 * The list of edges between the nodes of the TravelMap object
	 */
	private List<Edge> edges = new ArrayList<Edge>(100);
	//    private int nrOfNodes = 0;
	private int nrOfEdges = 0;


	/**
	 * A list of adjacency of node
	 */
	private List<List<NodePair>> adjacencyList = new ArrayList<>(100);

	/**
	 * A list of nodes and his distance from source to him
	 */
	private List<NodePair> allDistance = new ArrayList<>();

	/**
	 * A list of parents for  each node  in the path
	 */
	private List<Integer> parent = new ArrayList<>(Collections.nCopies(100, 0));

	/**
	 * Initialize the adjacency list
	 */
	public TravelMap() {
		for (int i = 0; i < 100; i++) {
			adjacencyList.add(new ArrayList<>());
		}
	}

	/**
	 * Adds a node to the TravelMap
	 *
	 * @param node the node to be added in the TravelMap
	 */
	public void addNode(Node node) {
		this.nodes.add(node);
	}

	/**
	 * Adds an edge to the TravelMap
	 *
	 * @param edge the edge to be added in the TravelMap
	 */
	public void addEdge(Edge edge) {
		this.edges.add(edge);
		nrOfEdges++;
	}

	/**
	 * Creates and adds an edge that is bi-directional to the TravelMap
	 *
	 * @param n1     The first node of the edge
	 * @param n2     The second node of the edge
	 * @param weight The weight of the edge
	 */
	public void addEdge(Node n1, Node n2, int weight) {
		this.edges.add(new Edge(n1, n2, weight));
		adjacencyList.get(n1.getIdNode()).add(new NodePair(n2.getIdNode(), weight));


		nrOfEdges++;
	}

	/**
	 * Creates and adds an edge that may be uni-directional or bi-directional to the TravelMap
	 *
	 * @param n1     The first node of the edge
	 * @param n2     The second node of the edge
	 * @param weight The weight of the edge
	 * @param twoWay false if the edge is uni-directional, true if it's bi-directional
	 */
	public void addEdge(Node n1, Node n2, int weight, boolean twoWay) {
		this.edges.add(new Edge(n1, n2, weight, twoWay));
		nrOfEdges++;
	}

	/**
	 * @return A string of the sorted list of names of the nodes in the TravelMap
	 */
	public String getNodes() {
		Collections.sort(nodes, new Comparator<Node>() {
			public int compare(Node c1, Node c2) {
				int result = c1.getName().compareTo(c2.getName());
				if (result < 0) return -1;
				if (result > 0) return 1;
				return 0;
			}
		});

		String nodes = this.nodes.get(0).getName();
		for (int i = 1; i < this.nodes.size() - 1; i++) {
			nodes += ", " + this.nodes.get(i).getName();
		}
		if (this.nodes.size() != 1)
			nodes += ", " + this.nodes.get(this.nodes.size() - 1).getName();
		return nodes;
	}

	/**
	 * @return A string of the list of edges in the TravelMap
	 */
	public String getEdges() {
		String edges = "Edge  \t\t\t\t\t\t\t|\t  Cost \n";
		for (Edge edge : this.edges) {
			edges += edge.getNode1().getName();
			if (edge.isTwoWay())
				edges += " ↔ ";
			else
				edges += " → ";
			edges += edge.getNode2().getName() + " | " + edge.getWeight() + "\n";
		}
		return edges;
	}

	@Override
	public String toString() {
		String map = "";
		map += this.getNodes() + "\n";
		map += this.getEdges();
		return map;
	}

	/**
	 * Prints every node that is visitable and not payable sorted by their opening hour
	 */
	public void freeVisitable() {
		Comparator<Visitable> dateComparator = (h1, h2)->h1.getOpeningHours().compareTo(h2.getOpeningHours());
		nodes.stream().filter(sc->sc instanceof Visitable).filter(sc->!(sc instanceof Payable)).sorted().forEach(System.out::println);
	}

	/**
	 * Prints the average ticket price for every node in the TravelMap that is payable
	 */
	public void averageTicketPayable() {
		nodes.stream().filter(sc->sc instanceof Payable).mapToDouble(sc->((Payable) sc).getEntryFee()).average().stream().forEach(System.out::println);
	}


	/**
	 * @param n1 Source node of path
	 * @param n2 Destination node of path
	 * @return A path from source to destination
	 */
	public List<Node> shortestPath(Node n1, Node n2) {
		MinHeap heap = new MinHeap();
		heap.add(new NodePair(n1.getIdNode(), 0));
		NodePair minNode;
		int adjNode;
		while (!heap.isEmpty()) {
			minNode = heap.remove();
			allDistance.add(minNode);
			for (NodePair it : adjacencyList.get(minNode.getNode())) {
				adjNode = heap.checkIn(it.getNode());
				if (adjNode == -1) heap.add(new NodePair(it.getNode(), it.getDistance() + minNode.getDistance()));
				else heap.update(adjNode, it.getDistance() + minNode.getDistance());
				parent.set(it.getNode(), minNode.getNode());
			}
		}
		List<Node> path = getPath(n2.getIdNode());
		path.add(n2);

		StringBuffer buffer = new StringBuffer();
		buffer.append("Path: ");
		for (Node it : path) {
			buffer.append(it.getName()).append("->");
		}
		buffer.append("END");
		System.out.println(buffer);
		return path;
	}


	/**
	 * @param node A id of a node
	 * @return A List that contain a path of nodes
	 */
	private List<Node> getPath(int node) {
		List<Node> path = new ArrayList<>();
		while (parent.get(node) != 0) {
			path.add(0, nodes.get(parent.get(node)));
			node = parent.get(node);
		}
		return path;
	}

	/**
	 * @param n1 A node that represent a source node
	 * @param n2 A node that represent destination node
	 * @return A path from source to destination
	 */
	public List<Node> gredyPath(Node n1, Node n2) {

		int curentDistance;
		Node node = n1;
		int saveNode = 1;
		List<Node> path = new ArrayList<>();
		path.add(node);

		boolean run = true;
		while (run) {
			curentDistance = Integer.MAX_VALUE;
			if (adjacencyList.get(node.getIdNode()).size() == 0) {
				run = false;
			} else {

				for (NodePair it : adjacencyList.get(node.getIdNode())) {
					if (it.getNode() == n2.getIdNode()) {
						run = false;
						curentDistance = it.getDistance();
						saveNode = n2.getIdNode();
						break;
					} else {
						if (it.getDistance() < curentDistance) {
							curentDistance = it.getDistance();
							saveNode = it.getNode();
						}
					}
				}
				node = nodes.get(nodes.size() - saveNode);
				path.add(nodes.get(nodes.size() - saveNode));
			}
		}

		for(Node it:path)
		{
			System.out.println(it.getName());
		}
		return path;
	}


}
