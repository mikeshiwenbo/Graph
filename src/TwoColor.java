
public class TwoColor {
	//��������ɫ��ͼ�����ж�����ɫ��ʹ������һ���ߵ������˵����ɫ������ͬ
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
