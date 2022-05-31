package algorithm;

public class IntegerToBinary {

	public static void main(String[] args) {
		
		int n = 8;
		StringBuilder sb = new StringBuilder();
		while(n != 0) {
			int remains = n%2;
			n = n/2;
			sb.append(remains);
		}
		String str = sb.toString();
		
		char[] chArr = str.toCharArray();
		for(int i=0;i<str.length()/2;i++) {
			char pre = chArr[i];
			char tmp = pre;
			int backIndex = str.length()-i-1;
			chArr[i] = chArr[backIndex];
			chArr[backIndex] = tmp;
		}
		
		for(int i=0;i<chArr.length;i++) {
			System.out.print(chArr[i]);
		}
	}

}
