import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BreadFirstPaths {
	//广度优先遍历图
	private boolean[] marked;
	private int[] edgeTo;
	private int s;
	public BreadFirstPaths(Graph g,int s){
		marked=new boolean[g.V()];
		edgeTo=new int[g.V()];
		this.s=s;
		bfs(g,s);
	}
	private void bfs(Graph g, int s) {
		// TODO Auto-generated method stub
		Queue<Integer> q=new LinkedList<>();
		marked[s]=true;
		q.offer(s);
		while(!q.isEmpty()){
			int h=q.poll();
			for(int w:g.adj(h)){
				if(!marked[w]){
					edgeTo[w]=h;
					marked[w]=true;
					q.offer(w);
				}
			}
		}
	}
	public boolean hasPathTo(int v){
		return marked[v];
	}
	public Iterable<Integer> pathTo(int v){
		Stack<Integer> a=new Stack<>();
		for(int k=v;k!=s;k=edgeTo[k]){
			a.push(k);
		}
		a.push(s);
		return a;
	}

}
