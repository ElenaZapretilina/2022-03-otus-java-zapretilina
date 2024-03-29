import annotations.Log;

public class TestLogging implements TestLoggingInterface {
    @Override
    @Log
    public void calculation(int param) {
        System.out.println("calculation, one param:" + param);
    }

    @Override
    @Log
    public void calculation(int param1, int param2) {
        System.out.println("calculation, two params:" + param1 + "," + param2);
    }

    @Override
    @Log
    public void calculation(int param1, int param2, String param3) {
        System.out.println("calculation, three params:" + param1 + "," + param2 + "," + param3);
    }

    @Override
    public String toString() {
        return "TestLogging{}";
    }
}

