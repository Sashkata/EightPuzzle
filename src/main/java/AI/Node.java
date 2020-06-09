package AI;

import java.util.Set;

public class Node {
	Node parent;
	Set<Node> Children;
	
	int[][] state;
	String action;
	int depth;
	int pathCost;
	boolean expanded;
	
	public Node(Node parent, int[][] state, String mvmt, int depth, int moveCost) {
		this.parent = parent;
		this.state = state;
		this.action = mvmt;
		this.depth = depth;
		this.pathCost = parent.pathCost + moveCost;
		this.expanded = false;
	}
	
	public Node(int[][] state) {
		this.parent = null;
		this.state = state;
		this.action = "BASE";
		this.depth = 0;
		this.pathCost = 0;
		this.expanded = false;
	}
}
