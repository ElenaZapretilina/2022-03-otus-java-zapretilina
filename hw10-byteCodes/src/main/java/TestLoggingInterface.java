import annotations.Log;

public interface TestLoggingInterface {
    @Log
    void calculation(int param);

    @Log
    void calculation(int param, int param1);

    @Log
    void calculation(int param1, int param2, String param3);
}
