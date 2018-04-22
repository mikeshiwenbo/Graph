
public class TwoColor {
	//用两种颜色将图的所有顶点着色，使得任意一条边的两个端点的颜色都不相同
	private boolean[] marked;
	private boolean[] color;
	private boolean isTwoColorable=true;
	public TwoColor(Graph g){
		marked=new boolean[g.V()];
		color=new boolean[g.V()];
		for(int i=0;i<g.V();i++){
			if(!marked[i]){
				dfs(g,i);
			}
		}
	}
	private void dfs(Graph g, int i) {
		// TODO Auto-generated method stub
		marked[i]=true;
		for(int w:g.adj(i)){
			if(!marked[w]){
				color[w]=!color[i];
				dfs(g,w);
			}else if(color[w]==color[i]) isTwoColorable=false;
		}
	}
	public boolean isBipaatite(){
		return isTwoColorable;
	}
}
