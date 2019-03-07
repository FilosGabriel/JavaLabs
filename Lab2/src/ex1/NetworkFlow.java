package ex1;

import java.util.*;

class NetworkFlow {
	private int m;
	private int n;
	private final int NIL=0;
	private final int INF=Integer.MAX_VALUE;
	private List<List<Integer>> adj;
	private List<Integer> pairU;
	private List<Integer> pairV;
	private List<Integer> dist;
	NetworkFlow(int m1,int n1){
		this.m=m1;
		this.n=n1;
		adj=new ArrayList<List<Integer>>(m+1);
		for (int i=0;i<=m;i++){
			adj.add(i,new ArrayList<Integer>());
		}
		pairU=new ArrayList<>(Collections.nCopies(m+1,NIL));
		pairV=new ArrayList<>(Collections.nCopies(n+1,NIL));
		dist=new ArrayList<>(Collections.nCopies(m+1,NIL));

	}

	public void addEdge(int u,int v){
		adj.get(u).add(v);
	}

	private  boolean bfs(){
		Queue<Integer> Q=new ArrayDeque<>();
		for(int u=1;u<=m;u++){
			if(pairU.get(u)==NIL){
				dist.set(u,0);
				Q.add(u);
			}
			else dist.set(u,INF);
		}
//		System.out.println(Q);
		dist.set(NIL,INF);
		while (!Q.isEmpty()){
			int u=Q.poll();
			if(dist.get(u)<dist.get(NIL)){
				for(Integer it:adj.get(u)){
					int v=it;
					if(dist.get(pairV.get(v))==INF){
						dist.set(pairV.get(v),dist.get(u)+1);
						Q.add(pairV.get(v));
					}
				}
			}
		}
		return (dist.get(NIL)!=INF);
	}

	private boolean dfs(int u){
		if(u!=NIL){
			for(Integer it:adj.get(u)){
				int v=it;
				if(dist.get(pairV.get(v))==dist.get(u)+1){
					if(dfs(pairV.get(v))==true){
						pairV.set(v,u);
						pairU.set(u,v);
						return true;
					}
				}
			}
			dist.set(u,INF);
			return false;
		}
		return true;
	}

	public int hopcroftKarp(){
		int result=0;
		while (bfs()){
			for(int u=1;u<=m;u++){
				if(pairU.get(u)==NIL && dfs(u)) {
					result++;
				}
			}
		}
//		System.out.println(pairU);
		return  result;
	}

	public  List<Integer> getPairU(){
		return pairU;
	}
}

//
//class NetworkFlow{
//	public static void main(String [] args){
//		aNetworkFlow g=new aNetworkFlow(4,4);
//		g.addEdge(1, 2);
//		g.addEdge(1, 3);
//		g.addEdge(2, 1);
//		g.addEdge(3, 2);
//		g.addEdge(4, 2);
//		g.addEdge(4, 4);
//		System.out.println(g.hopcroftKarp());
//	}
//}
