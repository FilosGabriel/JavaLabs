import javax.xml.crypto.NodeSetData;
import java.util.Arrays;
class Bfs{
	private  boolean[][] matriceBfs;
	private  boolean[ ]used;
	private  int [] deque;
	private int last=0,first=0,size;
	public boolean [] getUsed(){return used;}
	public  Bfs(boolean [][] matrice){
		matriceBfs=matrice;
		used=new  boolean[matrice[0].length];
		Arrays.fill(used, false);
		deque=new int[matrice[0].length+10];
		size=matrice[0].length;
	}
	public  boolean conexFrom(int i){
		deque[last]=i;
		last++;
		used[i]=true;
		while(last!=first){
			i=deque[first];
			first++;
			for(int index=0;index<size;index++){
//				System.out.println(size);
				if(matriceBfs[i][index]==true && used[index]==false){
					used[index]=true;
//					System.out.println(last);
					deque[last]=index;
					last++;
				}
			}
		}
		for (boolean r:used) {
			if(r==false){
				return false;
			}
		}
		return  true;
	}
	public int nrComponents(){
		int nrNodeUsed=0,components=1;
		conexFrom(0);
		int i=0;
		while(nrNodeUsed<size && used[nrNodeUsed]==true){
			nrNodeUsed++;
		}
		while (nrNodeUsed < size) {
			conexFrom(nrNodeUsed);
			last++;
			while(nrNodeUsed<size && used[nrNodeUsed]==true){
				nrNodeUsed++;
			}
			components++;
		}
		return components;
	}
}
class Node{
	private int[]nods;
	private int name;
	Node(int name1,int child,int last){
		name=name1;
		nods=new int[child];
		for(int i=0;i<child;i++){
			nods[i]=last+1+i;
		}
	}
	public  int []getNods(){return nods;}
}
class RandomTree{
	private int[] sample;
	private final  int MAX_NODE=4;
	private int totalNode=0;
	private boolean [][] matrice;
	Node [] tree;

	public RandomTree(int nrNode){
		tree=new Node[100];
		sample=new	 int[nrNode];
		matrice=new	boolean[nrNode][nrNode];
//		int startNode=java.util.concurrent.ThreadLocalRandom.current().nextInt(0,nrNode);
		int nrNodeCurentLevel=java.util.concurrent.ThreadLocalRandom.current().nextInt(2,MAX_NODE);
		int last=0;
		for(int i=0;i<nrNode;i++){
//			System.out.println(i);
			if(last>=nrNode){
				for(int j=i;j<nrNode;j++){
					tree[j]=new Node(j,0,0);
				}
				break;
			}
			else{
				tree[i]=new Node(i,nrNodeCurentLevel,last);
				last+=nrNodeCurentLevel;
				nrNodeCurentLevel=java.util.concurrent.ThreadLocalRandom.current().nextInt(0,MAX_NODE);
				if(last+nrNodeCurentLevel>=nrNode){
					nrNodeCurentLevel=nrNode-last;
				}
			}
		}

		for (int i=0;i<nrNode;i++){
			System.out.print("Node["+i+"]:{");
			for(int child:tree[i].getNods()){
				System.out.print(child+", ");
			}
			System.out.println("}");
		}


	}
}



public  class  bonus {


	public static void main(String[] args) {
//		final int SIZE_DATA=6;
//		randomGraph randomGraph = new randomGraph(SIZE_DATA);
//		boolean[][] mat = new boolean[SIZE_DATA][SIZE_DATA];
//		randomGraph.preatyPrint();
//		mat = randomGraph.getMatrice();
//		Bfs accesibil=new Bfs(mat);
//		System.out.println("Conex:"+accesibil.conexFrom(0));
//		System.out.println("Number of connected components :"+accesibil.nrComponents());
		RandomTree tree=new RandomTree(25);
		}
	}