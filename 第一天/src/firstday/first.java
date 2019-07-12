package firstday;

public class first {
	public static void main(String[] args) {
		for (int i = 1000; i < 10000; i++) {
			//9888
			int a=i/1000;//9
			int b=i/100-a*10;//98-90=8
			int c=i/10-a*100-b*10;//988-900-80=8
			int d=i/1-a*1000-b*100-c*10;//9888-9000-800-80=8
			int e=a+b*10+c*100+d*1000;
			if(i==e*9) {
				System.out.println(i+"相对的"+e);
			}
		}
	
	}
}
