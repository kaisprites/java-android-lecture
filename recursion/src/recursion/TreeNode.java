package recursion;

public class TreeNode {
	public Object value;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(int i, TreeNode left, TreeNode right) {
		value = i;
		this.left = left;
		this.right = right;
	}
	
	@Override
	public String toString() {
		return String.valueOf(value);
	}
}