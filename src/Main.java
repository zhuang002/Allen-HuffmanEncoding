import java.util.HashMap;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		HashMap<String, String> dic = new HashMap<>();
		for (int i=0;i<n;i++) {
			String[] pair = sc.nextLine().split(" ");
			dic.put(pair[1], pair[0]);
		}
		
		String decoded = decode(sc.nextLine(), dic);
		System.out.println(decoded);
	}

	private static String decode(String seq, HashMap<String, String> dic) {
		// TODO Auto-generated method stub
		if (seq.isEmpty())
			return "";
		for (int i=1; i<=seq.length();i++) {
			String sub = seq.substring(0,i);
			if (dic.containsKey(sub)) {
				String decoded = dic.get(sub) + decode(seq.substring(i), dic);
				return decoded;
			}
		}
		return "";
	}

}
