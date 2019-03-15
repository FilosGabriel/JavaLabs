package lab3;

import java.util.Arrays;

public class MinHeap {
	private static final int DEFAULT_CAPACITY=100;
	protected NodePair[] array;
	protected int size;
	public  MinHeap(){
		array=new NodePair[DEFAULT_CAPACITY];
		size=0;
	}
	public void add(NodePair node){
		if(size>=array.length-1){
			this.resize();
		}
		size++;
		int index=size;
		array[index]=node;
		bubbleUp();
	}
	public boolean isEmpty(){
		return size==0;
	}
	public NodePair peek(){
		if(this.isEmpty()){
			throw  new IllegalStateException();
		}
		return array[1];
	}
	public NodePair remove(){
		NodePair result=peek();
		array[1]=array[size];
		array[size]=null;
		size--;
		bubbleDown();
		return  result;
	}

	protected void bubbleDown(){
		int index = 1;

		// bubble down
		while (hasLeftChild(index)) {
			// which of my children is smaller?
			int smallerChild = leftIndex(index);

			// bubble with the smaller child, if I have a smaller child
			if (hasRightChild(index)
					&& array[leftIndex(index)].compareTo(array[rightIndex(index)]) > 0) {
				smallerChild = rightIndex(index);
			}

			if (array[index].compareTo(array[smallerChild]) > 0) {
				swap(index, smallerChild);
			} else {
				// otherwise, get outta here!
				break;
			}

			// make sure to update loop counter/index of where last el is put
			index = smallerChild;
		}
	}

	protected void bubbleUp() {
		int index = this.size;

		while (hasParent(index)
				&& (parent(index).compareTo(array[index]) > 0)) {
			// parent/child are out of order; swap them
			swap(index, parentIndex(index));
			index = parentIndex(index);
		}
	}

	protected boolean hasParent(int i) {
		return i > 1;
	}


	protected int leftIndex(int i) {
		return i * 2;
	}


	protected int rightIndex(int i) {
		return i * 2 + 1;
	}


	protected boolean hasLeftChild(int i) {
		return leftIndex(i) <= size;
	}


	protected boolean hasRightChild(int i) {
		return rightIndex(i) <= size;
	}


	protected NodePair parent(int i) {
		return array[parentIndex(i)];
	}


	protected int parentIndex(int i) {
		return i / 2;
	}


	protected NodePair[] resize() {
		return Arrays.copyOf(array, array.length * 2);
	}


	protected void swap(int index1, int index2) {
		NodePair tmp = array[index1];
		array[index1] = array[index2];
		array[index2] = tmp;
	}
	public String toString() {
		StringBuffer a=new StringBuffer();
		for (NodePair it:array) {
			if(it!=null) a.append(it.getNode()).append("-").append(it.getDistance()).append(" ");
			else a.append(" ooooo ");
		}
		return a.toString();
	}

	public int checkIn(int node){
		for(int i=0;i<=size;i++){
			if(array[i]!=null){
				if(array[i].getNode()==node) return  i;
			}
		}
		return -1;
	}
	public void update(int node,int distance){
		if(array[node].getDistance()>distance){
			array[node].setDistance(distance);
		}
	}

}
