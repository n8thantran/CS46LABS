package tiktokers;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class ArrayListMyTikTokManagerTest {

    private MyTikTokManager dir;
    ArrayListMyTikTokManager topTen;

    @Before
    public void setUp() {
        dir = new ArrayListMyTikTokManager();
        topTen = new ArrayListMyTikTokManager();
        topTen.load("src/Top10TikTokers.txt");
    }

    @Test
    public void topTenContainsBurak() {
        assertNotNull(topTen.get("@cznburak", "Followers"));
    }

    @Test(expected = NoSuchElementException.class)
    public void removeNonExistentEntry() {
        dir.remove("@nonexistent", "Followers");
    }

    @Test
    public void anEmptyDirectoryHasNoRumpledEater() {
    assertNull(dir.get("@rumpledeater", "Followers"));
    }

    @Test(expected = NoSuchElementException.class)
    public void removeNonExistentEntryEmptyManager() {
        String removed = dir.remove("@nonexistent","Followers");
        assertNull(removed);
    }

    @Test(expected = NoSuchElementException.class)
    public void removeNonExistentEntryNonEmptyManager() {
        dir.put("@existinguser", "Followers", "500000");
        String removed = dir.remove("@nonexistent", "Followers");
        assertNull(removed);
        assertNotNull(dir.get("@existinguser", "Followers"));
    }


    @Test
    public void basicRemove() {
    // make a MyTikTokManager (like in Step 2.4)
    MyTikTokManager dir = new ArrayListMyTikTokManager();
    // add a TikToker (hint: use put() method)
    dir.put("@rumpledeater","Followers","1000000");
    // remove that TikToker (hint: use remove() method)
    dir.remove("@rumpledeater", "Followers");
    // check that the entry is gone, using one of the assertions
    // in the Assert class methods of the JUnit API:
    // https://junit.org/junit4/javadoc/4.12/org/junit/Assert.html
    assertNull(dir.get("@rumpledeater", "Followers"));
    }
}
