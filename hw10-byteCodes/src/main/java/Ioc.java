import annotations.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
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

        DemoInvocationHandler(TestLoggingInterface myClass) {

            this.myClass = myClass;

        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            var hasAnnotation = myClass.getClass().getDeclaredMethod(method.getName(), method.getParameterTypes()).isAnnotationPresent(Log.class);
            if (hasAnnotation) {
                System.out.println("invoking method:executed method: " + method.getName() + ", param:" + Arrays.toString(args));
            }
            return method.invoke(myClass, args);
        }

        @Override
        public String toString() {
            return "DemoInvocationHandler{" + "myClass=" + myClass + '}';
        }

    }
}
