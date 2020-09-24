package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class SearchesTest {

    @Test
    void findUserFamilyNameInitialByAnyProperFraction() {
        assertEquals(List.of("F","B","L","B"), new Searches().findUserFamilyNameInitialByAnyProperFraction()
            .collect(Collectors.toList()));
    }
}