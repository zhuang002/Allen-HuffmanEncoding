import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		Node dic = buildDictionary(n, sc);
		sc.nextLine();
		String decoded = decode(sc.nextLine(), dic);
		System.out.println(decoded);
	}

	private static Node buildDictionary(int n, Scanner sc) {
		// TODO Auto-generated method stub
		Node dic = new Node();
		for (int i=0;i<n;i++) {
			Character c = sc.next().charAt(0);
			String key = sc.next();
			dic.add(key, c);
		}
		return dic;
	}

	private static String decode(String seq, Node dic) {
		// TODO Auto-generated method stub
		String decoded = "";
		Node current = dic;
		for (int i=0;i<seq.length(); i++) {
			Character c = seq.charAt(i);
			if (c == '0') {
				current = current.left;
			} else {
				current = current.right;
			}
			if (current.isLeaf()) {
				decoded += current.val;
				current = dic;
			}
		} 
		return decoded;
	}

}


class Node {
	Node left = null;
	Node right = null;
	char val = '\0';
	
	public void add(String key, Character c) {
		// TODO Auto-generated method stub
		if (key.isEmpty()) {
			this.val = c;
			return;
		}
		
		char p = key.charAt(0);
		Node current = this;
		if (p=='0') {
			if (this.left == null) {
				this.left = new Node();
			}
			current = this.left;
		} else {
			if (this.right == null) {
				this.right = new Node();
			}
			current = this.right;
		}
		current.add(key.substring(1), c);
	}

	public boolean isLeaf() {
		// TODO Auto-generated method stub
		return this.left == null && this.right == null;
	}
}
