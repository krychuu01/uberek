package pl.uberek.ubereats.value_objects;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;
import pl.uberek.ubereats.user.value_objects.Email;


@SpringBootTest
public class EmailTest {

    @DisplayName("Changning email")
    @Test
    void emailChange(){
        Email email = new Email("qwerty@super.com");
        email = new Email("zxcqwe@qprs.eu");
        assertEquals(email, new Email("zxcqwe@qprs.eu"));
    }

}
