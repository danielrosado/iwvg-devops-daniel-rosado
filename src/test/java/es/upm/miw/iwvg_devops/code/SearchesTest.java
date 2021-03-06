package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class SearchesTest {

    @Test
    void testFindUserFamilyNameInitialByAnyProperFraction() {
        assertEquals(List.of("F.", "B.", "L.", "B."), new Searches().findUserFamilyNameInitialByAnyProperFraction()
                .collect(Collectors.toList()));
    }

    @Test
    void testFindUserFamilyNameByAllNegativeSignFractionDistinct() {
        assertEquals(Collections.emptyList(), new Searches().findUserFamilyNameByAllNegativeSignFractionDistinct()
                .collect(Collectors.toList()));
    }

    @Test
    void testFindUserIdByAllProperFraction() {
        assertEquals(Collections.emptyList(), new Searches().findUserIdByAllProperFraction()
                .collect(Collectors.toList()));
    }

    @Test
    void testFindDecimalImproperFractionByUserName() {
        assertEquals(List.of(2.0, -0.5), new Searches().findDecimalImproperFractionByUserName("Oscar")
                .collect(Collectors.toList()));
    }

    @Test
    void testFindDecimalImproperFractionByUserName2() {
        assertEquals(List.of(-0.0), new Searches().findDecimalImproperFractionByUserName("Antonio")
                .collect(Collectors.toList()));
    }
}