package ua.kpi.fpm.pma.oop.chuckquotes;

import org.junit.BeforeClass;
import org.junit.Test;
import ua.kpi.fpm.pma.oop.chuckquotes.quote.Quote;
import ua.kpi.fpm.pma.oop.chuckquotes.quote.QuotesRegistry;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class QuotesRegistryTest {

    private static String[] expectedQuotes;
    private static QuotesRegistry registry;

    @BeforeClass
    public static void setUpClass() throws Exception {
        registry = new QuotesRegistry();

        expectedQuotes = new String[41];

        expectedQuotes[0] = "Chuck Norris can make a class that is both abstract and final.";
        expectedQuotes[1] = "Chuck Norris serializes objects straight into human skulls.";
        expectedQuotes[2] = "Chuck Norris doesn’t deploy web applications, he round-house kicks them into the server.";
        expectedQuotes[3] = "Chuck Norris always uses his own design patterns, and his favorite is the Round-house Kick.";
        expectedQuotes[4] = "Chuck Norris could use anything in java.util.* to kill you, including the javadocs.";
        expectedQuotes[5] = "Chuck Norris can hit you so hard your web app will turn into a swing application, and a very bad swing application containing lots of icons of human skulls.";
        expectedQuotes[6] = "Chuck Norris demonstrated the meaning of Float.POSITIVE_INFINITY by counting to it, twice.";
        expectedQuotes[7] = "A synchronize doesn’t protect against Chuck Norris, if he wants the object, he takes it.";
        expectedQuotes[8] = "Chuck Norris doesn’t use javac, he codes java by using a binary editor on the class files.";
        expectedQuotes[9] = "Chuck Norris’ java code never needs to be optimized. His code is so fast that it broke the speed of light during a test run in Sun’s labs killing 37 people.";
        expectedQuotes[10] = "When someone attempts to use one of Chuck Norris’ deprecated methods, they automatically get a round-house kick to the face at compile time.";
        expectedQuotes[11] = "The java.lang package originally contained a ChuckNorris class, but it punched its way out the package during a design review and round-house kicked Bill Joy in the face.";
        expectedQuotes[12] = "Chuck Norris never has a bug in his code, EVER!";
        expectedQuotes[13] = "Chuck Norris doesn’t write code. He stares at a computer screen until he gets the program he wants.";
        expectedQuotes[14] = "Code runs faster when Chuck Norris watches it.";
        expectedQuotes[15] = "Chuck Norris’ binary edited classes ignore Java bytecode verifier.";
        expectedQuotes[16] = "Chuck Norris methods doesn’t catch exceptions because no one has the guts to throw any at them.";
        expectedQuotes[17] = "Chuck Norris will cast a value to any type just by staring at it.";
        expectedQuotes[18] = "If you get a ChuckNorrisException you’ll probably die.";
        expectedQuotes[19] = "Chuck Norris is the only one who can use goto and const in Java.";
        expectedQuotes[20] = "Chuck Norris can compile Java code in .NET Framework, obviously just by staring at it.";
        expectedQuotes[21] = "Chuck don't need to catch an Exception because Java is afraid of the “flying tornado kick” at the moment it throws.";
        expectedQuotes[22] = "Chuck Norris’s code can round-house kick all other Java Objects’ privates.";
        expectedQuotes[23] = "Java visibility levels are public, default, protected, private and “protected by Chuck Norris”, don’t try to access a field with this last modifier!!";
        expectedQuotes[24] = "Chuck Norris eats JavaBeans and Round-house Kicks JavaServer Faces!";
        expectedQuotes[25] = "Chuck Norris can divide by 0!";
        expectedQuotes[26] = "Garbage collector only runs on Chuck Norris code to collect the bodies.";
        expectedQuotes[27] = "Chuck Norris code uses aggressive heap natively.";
        expectedQuotes[28] = "Every single line code of Chuck Norris runs in real time. Even in a multi threading application.";
        expectedQuotes[29] = "When a CPU load a Chuck Norris class file, it doubles the speed.";
        expectedQuotes[30] = "Chuck Norris can execute 64bit length instructions in a 32bit CPU.";
        expectedQuotes[31] = "Chuck Norris implements “Indestructible”. All the other creatures implements “Killable”.";
        expectedQuotes[32] = "Chuck Norris only program Java web applications to get a .WAR in the end.";
        expectedQuotes[33] = "Chuck Norris once round-house kicked a Java class very hard. The result is known as a inner class.";
        expectedQuotes[34] = "Chuck Norris can do multiple inheritance in Java.";
        expectedQuotes[35] = "JVM never throws exceptions to Chuck Norris, not anymore. 753 killed Sun engineers is enough.";
        expectedQuotes[36] = "Chuck Norris doesn’t need unit tests because his code always work. ALWAYS.";
        expectedQuotes[37] = "Chuck Norris extends God.";
        expectedQuotes[38] = "Chuck Norris workstation has so memory and it’s so powerful that he could run all java applications in the world and get 2% of resources usage.";
        expectedQuotes[39] = "Chuck Norris codes generics since 1.3.";
        expectedQuotes[40] = "Chuck Norris’ classes can’t be decompiled… don’t bother trying.";
    }

    @Test
    public void testRegistrySize() throws Exception {
        assertEquals(expectedQuotes.length, registry.size());
    }

    @Test
    public void testGetAllQuotes() throws Exception {
        for (int i = 0; i < expectedQuotes.length; i++) {
            assertEquals("Mismatch in quote #" + i, expectedQuotes[i], registry.getNextQuote().getText());
        }
    }

    @Test
    public void testAfterLastQuoteFirstReturned() throws Exception {
        for (String ignored : expectedQuotes) {
            registry.getNextQuote();
        }
        assertEquals(expectedQuotes[0], registry.getNextQuote().getText());
    }

    @Test
    public void testGetQuote() throws Exception {
        for (int i = 0; i < expectedQuotes.length; i++) {
            assertEquals(expectedQuotes[i], registry.get(i).getText());
        }
    }

    @Test
    public void testRemove() throws Exception {
        final Quote toBeRemoved = registry.get(5);
        assertTrue(registry.getAll().contains(toBeRemoved));
        registry.remove(toBeRemoved.getIndex());
        assertFalse(registry.getAll().contains(toBeRemoved));
    }

    @Test
    public void testAdd() throws Exception {
        assertEquals(expectedQuotes.length, registry.size());
        registry.add("This is new very funny joke about Chuck");
        assertEquals(expectedQuotes.length + 1, registry.size());
        assertEquals("This is new very funny joke about Chuck", registry.get(registry.size() - 1).getText());
        registry.remove(registry.size() - 1);
    }
}
