
public class Cycle {
	//ʹ����ȱ������ͼ�Ƿ���л���ǰ��ڵ����Ի��ߣ���ƽ�б�
	private boolean[] marked;
	private boolean hasCycle;
	public Cycle(Graph g){
		marked=new boolean[g.V()];
		for(int s=0;s<g.V();s++){
			if(!marked[s]){
				dfs(g,s,s);
			}
		}
	}
	private void dfs(Graph g, int s, int s2) {
		// TODO Auto-generated method stub
		marked[s]=true;
		for(int w:g.adj(s)){
			if(!marked[w]){
				dfs(g,w,s);
			}else if(w!=s2){
				hasCycle=true;
			}
		}
	}
	public boolean hasCycle(){
		return hasCycle;
	}
}
