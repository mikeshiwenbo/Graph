

import java.util.Vector;

import javax.swing.text.GapContent;

public class Graph {
	/* *
	 * @author 师文博
	 * @aim 用邻接表实现稀疏图
	 * 
	 */
	private final int V;//顶点数
	private int E;//边数
	boolean directed;//判断是否为有向图
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
