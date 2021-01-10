package recursion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * 재귀 함수는 자기 자신을 호출하는 함수이다.
 * 재귀 함수의 구조를 이해하고, 트리 구조에 대해서 전위순회, 중위순회, 후위순회를 실시하는 코드를 작성하자.
 * 
 * 트리 구조는 서킷을 이루지 않고 서로 다른 두 노드를 잇는 길이 하나뿐인 그래프를 의미한다.
 * 이진 트리는 모든 노드가 다른 노드를 가리킬 수 있는 노드 포인터를 2개까지 가진 트리를 의미한다.
 * 부분 트리는 루트 노드가 아닌 다른 노드를 루트로 삼는 트리를 의미한다.
 * 
 * 전위순회:	루트 노드 방문, 왼쪽 자식 부분 트리에 대해 재귀적 전위순회, 오른쪽 자식 부분 트리에 대해 재귀적 전위순회
 * 중위순회:	왼쪽 자식 부분 트리에 대해 재귀적 중위순회, 루트 노드 방문, 오른쪽 자식 부분 트리에 대해 재귀적 중위순회
 * 후위순회:	왼쪽 자식 부분 트리에 대해 재귀적 후위순회, 오른쪽 자식 부분 트리에 대해 재귀적 후위순회, 루트 노드 방문
 * 
 * 입력값 예시: 정수 배열 [ , 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 ] 에 대한 트리 구조의 루트 노드 (1, ->2, ->3)
 * 
 * 출력값 예시:
 * 	전위 순회: 1, 2, 4, 8, 9, 5, 10, 3, 6, 7
 * 	중위 순회: 8, 4, 9, 2, 10, 5, 1, 6, 3, 7
 * 	후위 순회: 8, 9, 4, 10, 5, 2, 6, 7, 3, 1
 */

public class RecursionTree {
	
	
	public static void preorder(TreeNode root) {
		//TODO: 주어진 트리의 루트 노드로부터 전위순회하는 코드를 구현
		System.out.print(root.value + " ");
		if(root.left != null) preorder(root.left);
		if(root.right != null) preorder(root.right);
	}
	
	public static void inorder(TreeNode root) {
		//TODO: 주어진 트리의 루트 노드로부터 중위순회하는 코드를 구현
		if(root.left != null) inorder(root.left);
		System.out.print(root.value + " ");
		if(root.right != null) inorder(root.right);
	}
	
	public static void postorder(TreeNode root) {
		//TODO: 주어진 트리의 루트 노드로부터 후위순회하는 코드를 구현
		if(root.left != null) postorder(root.left);
		if(root.right != null) postorder(root.right);
		System.out.print(root.value + " ");
	}
	
	public static TreeNode makeTree(int[] array) {
		TreeNode[] a = new TreeNode[array.length];
		for(int i=array.length-1; i>0; i--) {
			TreeNode left = null, right = null;
			if(i*2<array.length) left = a[i*2];
			if(i*2+1<array.length) right = a[i*2+1];
			a[i] = new TreeNode(array[i], left, right);
		}
		return a[1];
	}
	
	public static void main (String[] arg) throws FileNotFoundException {
		for(int i=5; i<8; i++) {
			File file = new File("input" + i + ".txt");
			Scanner sc = new Scanner(file);
			int length = sc.nextInt();
			int[] array = new int[length+1];
			for(int j=1; j<=length; j++) {
				array[j] = sc.nextInt();
			}
			TreeNode root = makeTree(array);
			
			preorder(root);
			System.out.println();
			inorder(root);
			System.out.println();
			postorder(root);
			System.out.println();
			System.out.println();
			
			sc.close();
		}
	}
}
