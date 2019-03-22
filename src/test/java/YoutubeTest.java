import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import ui.BaseTest;
import ui.pages.YoutubePage;

import java.util.Random;

@RunWith(JIRAJUnit4TestRunner.class)
public class YoutubeTest extends BaseTest {

    @Test
    @JIRATestKey(key = "EPMFARMATS-3020")
    public void alwaysPassedTest() {
        YoutubePage page = new YoutubePage("https://www.youtube.com/watch?v=UKKYpdWPSL8");
        String author = page.getAuthorName();
        Assert.assertEquals(author, "EPAM Systems Global");
    }

    @Test
    @JIRATestKey(key = "EPMFARMATS-2975")
    public void alwaysFailedTest() {
        YoutubePage page = new YoutubePage("https://www.youtube.com/watch?v=sU4i4DTr1HQ");
        String author = page.getAuthorName();
        Assert.assertEquals("Atlassian", author);
    }

    @Test
    @Ignore
    @JIRATestKey(key = "EPMFARMATS-2559")
    public void ignoredTest() {
        Assert.assertTrue(true);
    }

    @Test
    @JIRATestKey(key = "EPMFARMATS-3021")
    public void passedTest() {
        Random random = new Random();
        boolean r = random.nextBoolean();
        Assert.assertTrue(r);
    }
}
