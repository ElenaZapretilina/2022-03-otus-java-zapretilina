import annotations.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;

class Ioc {

    private Ioc() {
    }

    static TestLoggingInterface createMyClass(TestLoggingInterface testClass) {
        InvocationHandler handler = new DemoInvocationHandler(testClass);
        return (TestLoggingInterface) Proxy.newProxyInstance(Ioc.class.getClassLoader(),
                new Class<?>[]{TestLoggingInterface.class}, handler);
    }

    static class DemoInvocationHandler implements InvocationHandler {
        private final TestLoggingInterface myClass;
        ArrayList<Method> listAnnotation = new ArrayList<>();

        DemoInvocationHandler(TestLoggingInterface myClass) {
            this.myClass = myClass;
            for (Method declaredMethod : myClass.getClass().getDeclaredMethods()) {
                if (declaredMethod.isAnnotationPresent(Log.class)) {
                    listAnnotation.add(declaredMethod);
                }
            }
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            //  var hasAnnotation = myClass.getClass().getDeclaredMethod(method.getName(), method.getParameterTypes()).isAnnotationPresent(Log.class);
            for (Method logAnnotatedMethod : listAnnotation) {
                if (logAnnotatedMethod.getName().equals(method.getName()) && Arrays.equals(logAnnotatedMethod.getParameterTypes(), method.getParameterTypes())) {
                    System.out.println("executed method: " + method.getName() + ", param:" + Arrays.toString(args));
                }
            }
            return method.invoke(myClass, args);
        }

        @Override
        public String toString() {
            return "DemoInvocationHandler{" + "myClass=" + myClass + '}';
        }

    }
}
