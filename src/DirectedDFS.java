
public class DirectedDFS {
	//深度优先搜索测试有向图的可达性，判定的是从给定的一个或者一组顶点能到达哪些其它顶点
	private boolean[] marked;
	public DirectedDFS(Digraph G,int s){
		marked=new boolean[G.V()];
		dfs(G,s);
	}
	public DirectedDFS(Digraph G,Iterable<Integer> source){
		marked=new boolean[G.V()];
		for(int w:source){
			if(!marked[w])
			dfs(G,w);
		}
	}
	private void dfs(Digraph g, int s) {
		// TODO Auto-generated method stub
		marked[s]=true;
		for(int w:g.adj(s)){
			if(!marked[w]){
				dfs(g,w);
			}
		}
	}
	public boolean marked(int v){
		return marked[v];
	}

}
