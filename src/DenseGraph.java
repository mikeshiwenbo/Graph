

public class DenseGraph {
	//邻接矩阵实现图
	private int n,m;  //n为顶点数目,m为边数目
	private boolean direct;
	boolean[][] g;
	public DenseGraph(int n,boolean dirtect){
		this.n=n;
		this.m=0;
		this.direct=dirtect;
		g=new boolean[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				g[i][j]=false;
			}
		}
	}
	//返回节点数目
	public int v(){
		return n;
	}
	//返回边的个数
	public int E(){
		return m;
	}
	public void addEdge(int v,int w){
		if(v>n||w>n){
			System.out.println("越界");
		}else{
			if(hasEdge(v, w))
				return;
			g[v][w]=true;
			if(!direct)
				g[w][v]=true;
			m++;
			
		}
		
	}
	public boolean hasEdge(int v,int w){
		return g[v][w];
	}
}
