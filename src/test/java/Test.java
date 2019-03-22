import org.junit.Assert;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import utils.Attacher;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RunWith(JIRAJUnit4TestRunner.class)
public class Test {
    Attacher attacher = new Attacher();

    @org.junit.Test
    @JIRATestKey(key = "test1")
    public void test1() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        attacher.add(new File(".\\src\\test\\resources\\Untitled.png"), "test1");
        Assert.assertTrue(true);
    }

    @org.junit.Test
    @JIRATestKey(key = "test2")
    public void test2() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        attacher.add(new File(".\\src\\test\\resources\\text1.txt"), "test1"); //Should not be added into result *.xml file according to the wrong second parameter
        Assert.assertTrue(false);
    }

    @org.junit.Test()
    @JIRATestKey(key = "test3")
    @Ignore
    public void test3() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(false);
    }

    @org.junit.Test
    public void test4() {
        Assert.assertTrue(true);
    }

    @org.junit.Test()
    @JIRATestKey(key = "test5", disabled = true)
    public void test5() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(true);
    }

    @org.junit.Test(expected = IndexOutOfBoundsException.class)
    @JIRATestKey(key = "testForException")
    public void testForException() {
        List emptyList = new ArrayList();
        emptyList.get(0);
    }
}