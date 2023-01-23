import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class ReorganizeStringTest {

    @org.junit.jupiter.api.Test
    void reorganizeString() {

        String one = "aab";
        String two = "aaab";

        assertEquals("aba", ReorganizeString.reorganizeString(one));
        assertEquals("", ReorganizeString.reorganizeString(two));
    }
}