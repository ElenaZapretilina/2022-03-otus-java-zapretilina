import annotations.After;
import annotations.Before;
import annotations.Test;

public class ClassTest {
    int[] price = new int[]{100, 200, 300};

    public ClassTest() {
    }

    @Before
    public void before() {
        System.out.println("before");
    }

    @Test
    public void test1() {
        System.out.println("test1: " + this.price[0]);
    }

    @Test
    public void test2() {
        System.out.println("Test2: " + this.price[3]);
    }

    @After
    public void after() {
        System.out.println("after");
    }
}

