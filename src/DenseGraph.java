

public class DenseGraph {
	//�ڽӾ���ʵ��ͼ
	private int n,m;  //nΪ������Ŀ,mΪ����Ŀ
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
	//���ؽڵ���Ŀ
	public int v(){
		return n;
	}
	//���رߵĸ���
	public int E(){
		return m;
	}
	public void addEdge(int v,int w){
		if(v>n||w>n){
			System.out.println("Խ��");
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
