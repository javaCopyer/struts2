package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


public class JDKProxyHelper implements InvocationHandler{
	private Object targetObject;
	public Object getProy(Object targetObject) {
		this.targetObject = targetObject;
		return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(), this);
		
	}
	@Override
	public Object invoke(Object arg0, Method method, Object[] obj)
			throws Throwable {
		System.out.println("被jdk代理了");
		System.out.println("方法名称：" + method.getName());
		return method.invoke(targetObject, obj);
	}
	public Object getTargetObject() {
		return targetObject;
	}
	public void setTargetObject(Object targetObject) {
		this.targetObject = targetObject;
	}

}
