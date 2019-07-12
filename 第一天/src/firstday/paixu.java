package firstday;

public class paixu {
public static void main(String[] args) {
	int[] lx = new int[10];
	
	for (int i = 0; i < lx.length; i++) {
		
		int a = (int) (Math.random()*10);//0-9
		lx[i] = a;
		}
	
	for (int i = 0; i < lx.length; i++) {
		System.err.print(lx[i]+" ");
	}
}
}
