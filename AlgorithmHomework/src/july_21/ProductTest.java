package july_21;

public class ProductTest {

	public static void main(String[] args) {
		Product p0=new Product();
		Product p=new Product("01201","Daewoo",200000,4);
		Refrigerator r=new Refrigerator("10001","LG",700000,12,20);
		TV t= new TV("10001","LG",300000,40,"IPS",21);
		
		System.out.println(p0.toString());
		System.out.println(p.toString());
		System.out.println(r.toString());
		System.out.println(t.toString());
		
		

	}

}
