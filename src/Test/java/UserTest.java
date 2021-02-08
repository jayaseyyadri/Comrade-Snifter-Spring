import com.codeup.adlister.models.User;
import com.codeup.adlister.util.Validation;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;


public class UserTest {
    User testUser = new User();
    User testUser2 = new User();
    User testUser3 = new User();
    User testUser4 = new User();
    Set<String> users = new HashSet<>();

    @Before
    public void setUp() {
        testUser.notHashedTest("password123");
        testUser.setUsername("matt");

        testUser2.notHashedTest("helloWorld123!");
        testUser2.setUsername("Matt");

        testUser3.setUsername("matthew");
        testUser3.notHashedTest("short");

        users.add(testUser.getUsername());
        users.add(testUser2.getUsername());
        users.add(testUser3.getUsername());

        testUser4.setUsername("tester");
        testUser4.notHashedTest("Jupiter2021!");


    }

    @Test
    public void verifyUserInfo(){
        assertFalse(Validation.goodQualityPassword(testUser.getPassword()));
        assertTrue(Validation.goodQualityPassword(testUser2.getPassword()));
        assertFalse(Validation.goodQualityPassword(testUser3.getPassword()));
        assertTrue(Validation.goodQualityPassword(testUser4.getPassword()));

        testUser4.notHashedTest("Jupiter2021_");
        assertTrue(Validation.goodQualityPassword(testUser4.getPassword()));
    }

    @Test
    public void userNameAlreadyExists(){
        assertTrue(Validation.userNameExists(users, "matt"));
        assertTrue(Validation.userNameExists(users, "Matt"));
        assertTrue(Validation.userNameExists(users, "matthew"));

        assertFalse(Validation.userNameExists(users, "MATT"));
        assertFalse(Validation.userNameExists(users, "matt123"));
        assertFalse(Validation.userNameExists(users, "admin"));

    }
}
