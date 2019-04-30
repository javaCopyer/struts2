package proxy;


public class TestMail {
	public static void main(String[] args) {
		
		/**cglib动态代理**/
		Bussiness bus = new Bussiness();
		ProxyHelper proxy = new ProxyHelper();
		bus = proxy.getProxy(bus);
		bus.domain();
		System.out.println("------------------------");
		/**jdk动态代理**/
		JDKProxyHelper jph = new JDKProxyHelper();
		BussinessInterface a = (BussinessInterface) jph.getProy(new Bussiness());
		a.domain();
	}
}
