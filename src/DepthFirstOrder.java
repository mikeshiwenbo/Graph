import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DepthFirstOrder {
	//前序遍历pre 后序遍历post 逆后序reversePost
	private boolean marked[];
	private Queue<Integer> pre;
	private Queue<Integer> post;
	private Stack<Integer> reversePost;
	public DepthFirstOrder(Digraph g){
		marked=new boolean[g.V()];
		pre=new LinkedList<>();
		post=new LinkedList<>();
		reversePost=new Stack<>();
		for(int v=0;v<g.V();v++){
			if(!marked[v]) dfs(g,v);
		}
	}
	private void dfs(Digraph g, int v) {
		// TODO Auto-generated method stub
		pre.offer(v);
		marked[v]=true;
		for(int w:g.adj(v)){
			if(!marked[w]){
				dfs(g,w);
			}
		}
		post.offer(v);
		reversePost.push(v);
	}
	public Iterable<Integer> pre(){
		return pre;
	}
	public Iterable<Integer> post(){
		return post;
	}
	public Iterable<Integer> reversePost(){
		return reversePost;
	}

}
