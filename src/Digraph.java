
public class Digraph {
	//有向图的实现方法
	private int V;
	private int E;
	private Bag<Integer>[] adj;
	public Digraph(int V){
		this.V=V;
		this.E=0;
		adj=new Bag[V];
		for(int v=0;v<V;v++){
			adj[v]=new Bag<>();
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
		E++;
	}
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
	public Digraph reverse(){
		Digraph R=new Digraph(V);
		for(int i=0;i<V;i++){
			for(int w:adj(i)){
				R.addEdge(w, i);
			}
		}
		return R;
	}

}
