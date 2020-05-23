package JUnitEx;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class SomeClassTest {

//    assertTrue() – проверяет, что переданное условие истинно;
//    assertFalse() – проверяет, что переданное условие ложно;
//    fail() – метод для принудительного «провала» теста;
//    assertEquals() - проверяет, что для объектов, переданных в качестве параметров, метод equals возвращает true;
//    assertNotEquals() – проверяет, что equals для объектов возвращает false;
//    assertNull() – проверяет, что переданный в качестве параметра объект равен null;
//    assertNotNull() – проверяет, что переданный в качестве параметра объект не равен null.

    private SomeClass someClass;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, 1, 1},
                {1, 2, 3},
                {2, 2, 4}, //Illegal argument exc.
                {4, 6, 10},
        });
    }

    private int a,b,c;

    public SomeClassTest(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Before
    public void init() {
        someClass = new SomeClass();
    }

    @Test
    public void shouldDoSomeMath() {
        Assert.assertEquals(c, someClass.doMath(a,b));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowException() {
        someClass.doMath(a,b);
    }



}
