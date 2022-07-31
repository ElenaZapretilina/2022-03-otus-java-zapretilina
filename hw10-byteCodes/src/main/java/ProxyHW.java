import annotations.Log;

public class ProxyHW {
    public static void main(String[] args) {
        TestLoggingInterface myClassOne = Ioc.createMyClass(new TestLogging());
        myClassOne.calculation(5);
        myClassOne.calculation(6, 7);
        myClassOne.calculation(6, 7, "end");
    }
}



