package ex2;

class GraphGenerator {
    int[][] m;
    int n;
    int nrOfEdges=0;
    int[] degreeVertex;

    void generateComplete()
    {
        for (int i=0; i<this.n; i++)
            for (int j=0; j<i; j++)
            {
                    this.m[i][j]=1;
                    this.m[j][i]=1;
                    this.nrOfEdges++;
                    this.degreeVertex[i]++;
                    this.degreeVertex[j]++;
            }
    }

    void generateCycle()
    {
        for (int i=0; i<this.n; i++)
            for (int j=0; j<this.n; j++)
            {
                if (Math.abs(i-j)==1 || Math.abs(i-j)==this.n-1)
                {
                    this.m[i][j]=1;
                    this.nrOfEdges++;
                    this.degreeVertex[i]++;
                }
                else this.m[i][j]=0;
            }
        this.nrOfEdges /= 2;
    }

    void generateRandom()
    {
        for (int i=0; i<this.n; i++)
            for (int j=0; j<i; j++)
            {
                if (Math.random()>=0.5)
                {
                    this.m[i][j]=1;
                    this.m[j][i]=1;
                    this.degreeVertex[i]++;
                    this.degreeVertex[j]++;
                    this.nrOfEdges++;
                }
            }
    }

    void afisare()
    {
        for (int i=0; i<this.n; i++)
        {
            for (int j=0; j<this.n; j++)
            {
                if (this.m[i][j] == 1)
                    System.out.print('\u25C6');
                else System.out.print('\u25C7');
            }
            System.out.println();
        }
        //for (int i=0; i<this.n; i++)
            //System.out.printf("%d: %d\n", i, degreeVertex[i]);
    }

}
