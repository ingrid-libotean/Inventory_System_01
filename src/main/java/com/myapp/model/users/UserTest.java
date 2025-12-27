package com.myapp.model.users;

//import com.myapp.model.users.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    // --- Teste Constructor (Req #2 - constructor) ---

    @Test
    public void testEmptyConstructor() {
        // Testăm constructorul gol (necesar pt JPA)
        User user = new User();
        assertNotNull(user, "Obiectul nu trebuie să fie null");
        assertNull(user.getEmail(), "Email ar trebui să fie null inițial");
    }

    @Test
    public void testFullConstructor() {
        // Testăm constructorul cu parametri
        User user = new User("Alex", "alex@test.com", "1234", "CLIENT");

        assertEquals("Alex", user.getName());
        assertEquals("alex@test.com", user.getEmail());
        assertEquals("CLIENT", user.getRole());
    }
}