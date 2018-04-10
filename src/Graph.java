

import java.util.Vector;

import javax.swing.text.GapContent;

public class Graph {
	/* *
	 * @author ʦ�Ĳ�
	 * @aim ���ڽӱ�ʵ��ϡ��ͼ
	 * 
	 */
	private final int V;//������
	private int E;//����
	boolean directed;//�ж��Ƿ�Ϊ����ͼ
	private Bag<Integer>[] adj;
	public Graph(int V,boolean directed){
		this.V=V;
		this.E=0;
		this.directed=directed;
		adj=new Bag[V];
		for(int v=0;v<V;v++){
			adj[v]=new Bag<Integer>();
		}
	}
	public int V(){
		return V;
	}
	public int E(){
		return E;
	}
	public void addEdge(int v,int w){
		adj[v].add(w);
		adj[w].add(v);
		E++;
	}
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
}
