package proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
/**
 * cglib动态代理
 * CGLIB Nodep jar包含ASM框架的代码，所有不需引用ASM的jar包
 * @Description: TODO 
 * @author sky
 * @date 2018-7-14 下午3:18:46
 */
public class ProxyHelper implements MethodInterceptor{
	private Object targetObject;
	private Enhancer enhancer = new Enhancer();
	
	@SuppressWarnings("unchecked")
	public <T> T getProxy(Object targetObject) {
		this.targetObject = targetObject;
		enhancer.setSuperclass(targetObject.getClass());
		enhancer.setCallback(this);
		return (T) enhancer.create();
	}
	
	@Override
	public Object intercept(Object obj, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		System.out.println("被代理了");
		System.out.println("执行方法名称：" + method.getName());
		return proxy.invoke(targetObject, args);
	}

	public Object getTargetObject() {
		return targetObject;
	}

	public void setTargetObject(Object targetObject) {
		this.targetObject = targetObject;
	}
	

}
