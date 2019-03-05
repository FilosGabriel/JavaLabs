package lab3;

public class TravelMap {
    private Node[] nodes;
    private Edge[] edges;
    private int nrOfNodes = 0; //nush cum sa adaug la final fara sa fac asta
    private int nrOfEdges = 0;

    public TravelMap() {
        nodes = new Node[100]; //nush cate elemente ar trebui sa aibe
        edges = new Edge[100];
    }

    public void addNode(Node node)
    {
        if (nrOfNodes == 0)
        {
            this.nodes[nrOfNodes] = node;
            nrOfNodes++;
        }
        else if (nrOfNodes == 1)
        {
            if (node.getName().compareTo(this.nodes[0].getName()) <= 0)
            {
                this.nodes[1] = this.nodes[0];
                this.nodes[0] = node;
            }
            else
            {
                this.nodes[1] = node;
            }
            this.nrOfNodes++;

        }
        else //daugare in vector sortat
        {
            int start = 0;
            int stop = nrOfNodes-1;
            int m;
            while (true)
            {
                m = (stop - start)/2;
                if (stop-start == 1 || stop-start == 0)
                {
                    if (node.getName().compareTo(this.nodes[stop].getName()) > 0)
                    {
                        m=stop+1;
                    }
                    else m=start;
                    break;
                }
                else if (node.getName().compareTo(this.nodes[m].getName()) > 0)
                    start = m;
                else if (node.getName().compareTo(this.nodes[m-1].getName()) < 0)
                    stop = m-1;
                else break;
            }
            for (int i=this.nrOfNodes; i>m; i--)
            {
                this.nodes[i]=this.nodes[i-1];
            }
            this.nodes[m]=node;
            nrOfNodes++;
        }
    }

    public void addEdge(Edge edge)
    {
        this.edges[nrOfEdges] = edge;
        nrOfEdges++;
    }

    public void addEdge(Node n1, Node n2, int weight)
    {
        this.edges[nrOfEdges] = new Edge(n1, n2, weight);
        nrOfEdges++;
    }

    public void addEdge(Node n1, Node n2, int weight, boolean twoWay)
    {
        this.edges[nrOfEdges] = new Edge(n1, n2, weight, twoWay);
        nrOfEdges++;
    }

    public String getNodes()
    {
        String nodes = new String(this.nodes[0].getName());
        for (int i=1; i<this.nrOfNodes-1; i++)
        {
            nodes += ", " + this.nodes[i].getName();
        }
        if (nrOfNodes != 1)
            nodes += ", " + this.nodes[this.nrOfNodes-1].getName();
        return nodes;
    }

}
