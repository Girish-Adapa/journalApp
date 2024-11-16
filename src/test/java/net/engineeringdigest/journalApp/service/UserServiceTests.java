package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.repository.UserRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;


//    @BeforeEach
//    @BeforeAll
//    @AfterEach
//    @AfterAll
//    void setUp() {
//
//    }


    @ParameterizedTest
//    @Test
//    @CsvSource({
//            "ram",
//            "shyam",
//            "vipul"
//    })
//    @ValueSource(strings = {
//            "ram",
//            "shyam",
//            "vipul"
//    })
    @ArgumentsSource(UserArgumentsProvider.class)
    @Disabled
    public void testSaveNewUser(User user) {

        assertTrue(userService.saveNewUser(user));
//        assertEquals(4, 2 + 2);

//        assertNotNull(userRepository.findByUserName(name), "failed for : " + name);

//        User user = userRepository.findByUserName("ram");
//        assertTrue(!user.getJournalEntries().isEmpty());
    }

    @Disabled
    @ParameterizedTest
    @CsvSource({
            "1,1,2",
            "2,10,12",
            "3,3,9"
    })
    public void test(int a, int b, int expected) {
        assertEquals(expected, a + b);
    }
}
