import annotations.After;
import annotations.Before;
import annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class RunTest {
    public static void main(String[] args) {
        runTest(ClassTest.class);
    }

    public static <T> void runTest(Class<T> clazz) {
        int successfulCount = 0;
        int exceptionCount = 0;
        int allCount = 0;
        RunTest myTest = new RunTest();

        try {
            ArrayList<Method> beforeMethods = new ArrayList<>();
            ArrayList<Method> testMethods = new ArrayList<>();
            ArrayList<Method> afterMethods = new ArrayList<>();
            Method[] methods = clazz.getMethods();

            for (Method method : methods) {

                if (method.isAnnotationPresent(Before.class)) {
                    beforeMethods.add(method);
                }

                if (method.isAnnotationPresent(Test.class)) {
                    testMethods.add(method);
                }

                if (method.isAnnotationPresent(After.class)) {
                    afterMethods.add(method);
                }
            }

            for (Method testMethod : testMethods) {

                Object newClazz = clazz.getDeclaredConstructor().newInstance();

                try {
                    ++allCount;
                    myTest.invokeMethods(beforeMethods, newClazz);
                    testMethod.invoke(newClazz);
                    ++successfulCount;
                } catch (Exception ex) {
                    ++exceptionCount;
                    System.out.println("Exception: " + testMethod.getName());
                }

                myTest.invokeMethods(afterMethods, newClazz);
            }

            System.out.println("-------------------------------------");
            System.out.println(" Successful count: " + successfulCount);
            System.out.println(" Exception count: " + exceptionCount);
            System.out.println(" All count: " + allCount);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void invokeMethods(ArrayList<Method> methods, Object object) {
        for (Method method : methods) {
            try {
                method.invoke(object);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}


