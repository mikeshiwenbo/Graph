import java.util.Stack;

public class Path {
	//深度遍历获得两点间的路径，
	private Graph graph;
	private  int s;
	private boolean[] marked;
	private int[] edgeTo;
	public Path(Graph g,int s){
		this.graph=g;
		marked=new boolean[g.V()];
		edgeTo=new int[g.V()];
		this.s=s;
		dfs(graph,s);
	}
	private void dfs(Graph graph2, int s2) {
		// TODO Auto-generated method stub
		marked[s2]=true;
		for(int w:graph2.adj(s2)){
			if(!marked[w]){
				edgeTo[w]=s2;
				dfs(graph2,s2);
			}
		}
	}
	public boolean hasPathTo(int v){
		return marked[v];
	}
	public Iterable<Integer> pathTo(int v){
		if(!hasPathTo(v)) return null;
		Stack<Integer> path=new Stack<>();
		for(int x=v;x!=s;x=edgeTo[x]){
			path.push(x);
		}
		path.push(s);
		return path;
	}

}
