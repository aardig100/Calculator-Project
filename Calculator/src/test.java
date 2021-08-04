
public class test {
	public static void main(String [] args) {
		
		
		String expression = "5Mod4";
		expression = expression.replaceAll("Mod", "%");
		System.out.println(expression);
	}
}
