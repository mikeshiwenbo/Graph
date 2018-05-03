import java.util.Stack;

public class DirectedCycle {
	//判断一个有向图中是否含有环
	private boolean[] marked;
	private int[] edgeTo;
	private Stack<Integer> cycle;
	private boolean[] onStack;
	public DirectedCycle(Graph G){
		onStack=new boolean[G.V()];
		edgeTo=new int[G.V()];
		marked=new boolean[G.V()];
		for(int v=0;v<G.V();v++){
			if(!marked[v]) dfs(G,v);
		}
	}
	public boolean hasCycle(){
		return cycle!=null;
	}
	public Iterable<Integer> cycle(){
		return cycle;
	}
	private void dfs(Graph g, int v) {
		// TODO Auto-generated method stub
		onStack[v]=true;
		marked[v]=true;
		for(int w:g.adj(v)){
			if(this.hasCycle()) return ;
			else if(!marked[w]){
				edgeTo[w]=v;
				dfs(g,w);
			}
			else if(onStack[w]){
				cycle=new Stack<>();
				for(int x=v;x!=w;x=edgeTo[x]){
					cycle.push(x);
				}
				cycle.push(w);
				cycle.push(v);
			}
		}
		onStack[v]=false;
	}
}
