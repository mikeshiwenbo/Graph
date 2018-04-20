
public class DFS {
	private Graph g;
	private int count;
	private boolean[] visited;
	//������ȱ���
	//count��¼�����ж��ٸ���ͨ����
	public DFS(Graph g){
		this.g=g;
		visited=new boolean[g.V()];
		for(int i=0;i<g.V();i++){
			visited[i]=false;
		}
		for(int i=0;i<g.V();i++){
			if(!visited[i]){
				dfs(i);
				count++;
			}
		}
	}
	private void dfs(int i) {
		// TODO Auto-generated method stub
		visited[i]=true;
		for(int w:g.adj(i)){
			if(!visited[w]) dfs(w);
		}
	}

}
