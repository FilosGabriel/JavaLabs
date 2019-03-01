abstract  class  Graph {
    protected boolean[][] matrice;
    protected int size;
    abstract protected int numberOfEdges();
    abstract protected int maxDegree();
    abstract protected int minDegree();
    public  boolean[][] getMatrice(){return  matrice;}
    public void preatyPrint() {
        for (boolean[] line : matrice) {
            for (boolean row : line) {
                if (row) {
					System.out.print("\u25CF|");
				} else {
					System.out.print("\u25CB|");
				} }
            System.out.println("");
        } }
    public boolean sumDegree() {
        int sumOfGrades = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (true == matrice[i][j]) {
                    sumOfGrades++;
                }
            }
        }
        return 2 * numberOfEdges() == sumOfGrades;
    }
}
class CycleGraph extends  Graph{
    CycleGraph(int n){
        matrice=new boolean[n][n];
        size=n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrice[i][j]=(Math.abs(i - j) == 1 || Math.abs(i - j) == n - 1);
            }
        }
    }

    @Override
    public int maxDegree() { return 2; }
    @Override
    public int minDegree() { return 2; }
    @Override
    public int numberOfEdges(){ return  size; }
}

class completeGraph extends Graph{
    completeGraph(int n){
        matrice = new boolean[n][n];
        size=n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrice[i][j] = !(i==j);
            }
        }
    }
    @Override
    public int maxDegree() { return size-1; }

    @Override
    public int minDegree() { return size-1; }

    @Override
    public  int numberOfEdges(){ return  (size*(size-1))/2; }
}

class  randomGraph extends  Graph{
    randomGraph(int n){
        matrice = new boolean[n][n];
        size=n;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    matrice[i][j] = false;

                } else {
                    matrice[i][j] = (Math.random() < 0.5);
                }
                matrice[j][i]=matrice[i][j];
            }
        }
        for(int i=0;i<size;i++){
        	matrice[i][i]=false;
		}

    }
    @Override
    public  int numberOfEdges(){
        int edges=0;
        for( int i=0;i<size;i++) {
            for (int j=i+1;j<size;j++){
                if(matrice[i][j]){
                    edges++;
                }
            }
        }
        return  edges;
    }
    @Override
    public int maxDegree() {
        int degree=0,pos=0,finalDegree=0;
        for(int i=0;i<size;i++){
            degree=0;
            for(int j=0;j<size;j++){
                if(matrice[i][j]){
                    degree++;
                }
            }
            if(degree>finalDegree){
                finalDegree=degree;
            }
        }
        return finalDegree;
    }

    @Override
    public int minDegree() {
        int degree=0,pos=0,finalDegree=size;
        for(int i=0;i<size;i++){
            degree=0;
            for(int j=0;j<size;j++){
                if(matrice[i][j]){ degree++; }
            }
            if(degree<finalDegree){ finalDegree=degree; }
        }
        return finalDegree;
    }
}

 class selection{
	public selection(int n ,String option){
		if(option.equals("complet")) {
			completeGraph complet = new completeGraph(n);
			complet.preatyPrint();
			System.out.println("Edges :"+ complet.numberOfEdges());
			System.out.println("\u0394(G)=" + complet.maxDegree() + ", \u03B4(G)=" + complet.minDegree());
			System.out.println(complet.sumDegree());
		}
		else
		{
			if(option.equals("cycle")){
				CycleGraph complet = new CycleGraph(n);
				//			complet.preatyPrint();
				System.out.println(complet.numberOfEdges());
				System.out.println("\u0394(G)=" + complet.maxDegree() + ", \u03B4(G)=" + complet.minDegree());
				System.out.println(complet.sumDegree());
			}
			else{
				if(option.equals("random")){
					randomGraph complet = new randomGraph(4);
					//			complet.preatyPrint();
					System.out.println(complet.numberOfEdges());
					System.out.println("\u0394(G)=" + complet.maxDegree() + ", \u03B4(G)=" + complet.minDegree());
					System.out.println(complet.sumDegree());
				}}
		}
	}

}


public class secondExercise {

    public static void main(String []args)
    {
        if(args[0]!=null &&  Integer.parseInt( args[0])%2==1)
        {
				if(args[1]!=null){
				long startTime = System.nanoTime();
				int n = Integer.parseInt(args[0]);
				selection selection = new selection(n,args[1]);
				long endTime = System.nanoTime();
				long duration = (endTime - startTime);
				double elapsedTime=(double) duration/1000000;
				System.out.println("time :"+elapsedTime+" milliseconds.");
				}
			}
        else{
			System.out.println("Nu s-a dat nici un argument la linia de comanda sau n nu este impar");
		}


    }
}
