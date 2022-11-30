/**
 * DepthFistSearch.java contains the methods to do a depth-first preorder search of a binary tree, find the tree's height,
 *  and find the number of nodes traversed
 * @author Jared Rosenberger
 * @version 11/30/22
 * DepthFirstSearch.java
 * Fall 2022
 */
public class DepthFirstSearch {
	
	private int nodesTraversed;//will count the number of nodes traversed
	private int lheight;//will track the height of the longest left subtree
	private int rheight;//will track the height of the longest right subtree
	
	/**
	 * No-argument constructor initializes instance variables
	 */
	public DepthFirstSearch() {
		nodesTraversed = 0;
		lheight = 0;
		rheight = 0;
		System.out.println("Call DFS with root node to do a Depth First Search.");
    }//end constructor
	
	/**
	 * DFS performs a depth-first preorder search of a binary tree given the root node 
	 * @param node is the root of a binary tree
	 */
    public void DFS(Node node) {
    	System.out.println("Node Traversed:\t" + node.getData());
    	nodesTraversed++;
    	if(node.getlChild() == null && node.getrChild() == null) {
    		return;
    	}
    	DFS(node.getlChild());
    	DFS(node.getrChild());
    }//end DFS
    
    /**
     * printVisited prints the number of nodes traversed during DFS
     */
    public void printVisited() {
    	System.out.println("Total Nodes Traversed:\t" + nodesTraversed);
    }//end getVisited
    
    /**
     * printHeight calculates and prints the height of a given binary tree
     * @param root is the root of a binary tree
     */
    public void printHeight(Node root) {
    	getRHeight(root);
    	getLHeight(root);
    	int treeHeight = Math.max(rheight, lheight);
    	System.out.println("Tree Height: " + treeHeight + " levels");
    }//end printHeight
    
    /**
     * getRHeight calculates the height of the right subtree of a binary tree 
     * @param root is the root of a binary tree
     */
    private void getRHeight(Node root) {
    	rheight++;
    	if(root.getrChild() == null) {
    		//System.out.println("Right Subtree height: " + rheight);
    		return;
    	}
    	getRHeight(root.getrChild());
    }//end getRHeight
    
    /**
     * getLHeight calculates the height of the left subtree of a binary tree
     * @param root is the root of a binary tree
     */
    private void getLHeight(Node root) {
    	lheight++;
    	if(root.getlChild() == null) {
    		//System.out.println("Left Subtree height: " + lheight);
    		return;
    	}
    	getLHeight(root.getlChild());
    }//end getLHeight
    
    /**
     * reset counts allows a DepthFirstSearch Object to be reused by resetting it's instance variables
     */
    public void resetCount() {
    	nodesTraversed = 0;
    	rheight = 0;
    	lheight = 0;
    }//end resetCount
}//end DepthFirstSearch.java
