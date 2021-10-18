import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CoderTest {
    private String firstCode = "qqqqqqqqqwwwwwwwwwwwwwwwweeeeeeeeeeeeeeemmnnnnvvvvvvlllllllaaaaassssssssssssseeeeeeeeeeeeeeeeeeeee";

    private String secondCode = """
            mmmmmmaaaaaaalllakdsddddddddooooowwwwwssaaaaa
            zzzzzz
            spl
            """;

    private String thirdCode = """
            iiiiiiidddddd
            ccccc
            aaaaaww
            ffffff
            """;

    private String fourthCode = """
            qwertyuopppppppppppcvvvvvmal
            a
            qqqwe
            """;

    private String firstEncode = "9q16w15e2m4n6v7l5a13s21e";
    private String secondEncode = """
            6m7a3lakds8d5o5w2s5a
            6z
            spl
            """;
    private String thirdEncode = """
            7i6d
            5c
            5a2w
            6f
            """;
    private String fourthEncode = """
            qwertyuo11pc5vmal
            a
            3qwe
            """;

    @Test
    void codeTest(){
        assertEquals(firstEncode, Action.code(firstCode));
        assertEquals(secondEncode, Action.code(secondCode));
        assertEquals(thirdEncode, Action.code(thirdCode));
        assertEquals(fourthEncode, Action.code(fourthCode));
    }

    @Test
    void encodeTest(){
        assertEquals(firstCode, Action.encode(firstEncode));
        assertEquals("mmmmmmaaaaaaalllakdsddddddddooooowwwwwssaaaaazzzzzzspl", Action.encode(secondEncode));
        assertEquals("iiiiiiiddddddcccccaaaaawwffffff", Action.encode(thirdEncode));
        assertEquals("qwertyuopppppppppppcvvvvvmalaqqqwe", Action.encode(fourthEncode));
    }
}
