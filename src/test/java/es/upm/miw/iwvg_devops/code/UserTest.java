package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user;
    private User user2;

    @BeforeEach
    void setUp() {
        List<Fraction> fractions = new ArrayList<>(Arrays.asList(new Fraction(), new Fraction()));

        user = new User("1", "John", "Doe", fractions);
    }

    @Test
    void testConstructor() {
        user2 = new User();

        assertEquals(Collections.emptyList(), user2.getFractions());
    }


    @Test
    void testGetId() {
        assertEquals("1", user.getId());
    }

    @Test
    void testGetName() {
        assertEquals("John", user.getName());
    }

    @Test
    void testSetName() {
        String newName = "Foo";
        user.setName(newName);

        assertEquals(newName, user.getName());
    }

    @Test
    void testGetFamilyName() {
        assertEquals("Doe", user.getFamilyName());
    }

    @Test
    void testSetFamilyName() {
        String newFamilyName = "Bar";
        user.setFamilyName(newFamilyName);

        assertEquals(newFamilyName, user.getFamilyName());
    }

    @Test
    void testGetFractions() {
        assertEquals(2, user.getFractions().size());
    }

    @Test
    void testSetFractions() {
        user.setFractions(Collections.emptyList());

        assertTrue(user.getFractions().isEmpty());
    }

    @Test
    void testAddFraction() {
        int originalSize = user.getFractions().size();
        user.addFraction(new Fraction());

        assertEquals(originalSize + 1, user.getFractions().size());
    }

    @Test
    void testFullName() {
        assertEquals("John Doe", user.fullName());
    }

    @Test
    void testInitials() {
        assertEquals("J.", user.initials());
    }

    @Test
    void testToString() {
        String userStr = "User{" +
                "id='" + user.getId() + '\'' +
                ", name='" + user.getName() + '\'' +
                ", familyName='" + user.getFamilyName() + '\'' +
                ", fractions=" + user.getFractions() +
                '}';

        assertEquals(userStr, user.toString());
    }
}