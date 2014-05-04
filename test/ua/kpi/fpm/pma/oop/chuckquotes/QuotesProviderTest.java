package ua.kpi.fpm.pma.oop.chuckquotes;

import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertTrue;

public class QuotesProviderTest {

    @Test
    public void testGetAllQuotes() throws Exception {
        QuoteDAO dao = new HardCodedQuoteDAO();
        LinkedList<String> quotes = dao.getAllQuotes();

        String q1 = "Chuck Norris can make a class that is both abstract and final.";
        String q2 = "Chuck Norris serializes objects straight into human skulls.";
        String q3 = "Chuck Norris doesn’t deploy web applications, he round-house kicks them into the server.";
        String q4 = "Chuck Norris always uses his own design patterns, and his favorite is the Round-house Kick.";
        String q5 = "Chuck Norris could use anything in java.util.* to kill you, including the javadocs.";
        String q6 = "Chuck Norris can hit you so hard your web app will turn into a swing application, and a very bad swing application containing lots of icons of human skulls.";
        String q7 = "Chuck Norris demonstrated the meaning of Float.POSITIVE_INFINITY by counting to it, twice.";
        String q8 = "A synchronize doesn’t protect against Chuck Norris, if he wants the object, he takes it.";
        String q9 = "Chuck Norris doesn’t use javac, he codes java by using a binary editor on the class files.";
        String q10 = "Chuck Norris’ java code never needs to be optimized. His code is so fast that it broke the speed of light during a test run in Sun’s labs killing 37 people.";
        String q11 = "When someone attempts to use one of Chuck Norris’ deprecated methods, they automatically get a round-house kick to the face at compile time.";
        String q12 = "The java.lang package originally contained a ChuckNorris class, but it punched its way out the package during a design review and round-house kicked Bill Joy in the face.";
        String q13 = "Chuck Norris never has a bug in his code, EVER!";
        String q14 = "Chuck Norris doesn’t write code. He stares at a computer screen until he gets the progam he wants.";
        String q15 = "Code runs faster when Chuck Norris watches it.";
        String q16 = "Chuck Norris’ binary edited classes ignore Java bytecode verifier.";
        String q17 = "Chuck Norris methods doesn’t catch exceptions becuase no one has the guts to throw any at them.";
        String q18 = "Chuck Norris will cast a value to any type just by staring at it.";
        String q19 = "If you get a ChuckNorrisException you’ll probably die.";
        String q20 = "Chuck Norris is the only one who can use goto and const in Java.";
        String q21 = "Chuck Norris can compile Java code in .NET Framework, obviously just by staring at it.";
        String q22 = "Chuck dont need to catch an Exception because Java is afraid of the “flying tornado kick” at the moment it throws.";
        String q23 = "Chuck Norris’s code can round-house kick all other Java Objects’ privates.";
        String q24 = "Java visibility levels are public, default, protected, private and “protected by Chuck Norris”, don’t try to access a field with this last modifier!!";
        String q25 = "Chuck Norris eats JavaBeans and Round-house Kicks JavaServer Faces!";
        String q26 = "Chuck Norris can divide by 0!";
        String q27 = "Garbage collector only runs on Chuck Norris code to collect the bodies.";
        String q28 = "Chuck Norris code uses agressive heap natively.";
        String q29 = "Every single line code of Chuck Norris runs in real time. Even in a multi threading application.";
        String q30 = "When a CPU load a Chuck Norris class file, it doubles the speed.";
        String q31 = "Chuck Norris can execute 64bit length instructions in a 32bit CPU.";
        String q32 = "Chuck Norris implements “Indestructible”. All the other creatures implements “Killable”.";
        String q33 = "Chuck Norris only program Java web applications to get a .WAR in the end.";
        String q34 = "Chuck Norris once round-house kicked a Java class very hard. The result is known as a inner class.";

        assertTrue(quotes.contains(q1));
        assertTrue(quotes.contains(q2));
        assertTrue(quotes.contains(q3));
        assertTrue(quotes.contains(q4));
        assertTrue(quotes.contains(q5));
        assertTrue(quotes.contains(q6));
        assertTrue(quotes.contains(q7));
        assertTrue(quotes.contains(q8));
        assertTrue(quotes.contains(q9));
        assertTrue(quotes.contains(q10));
        assertTrue(quotes.contains(q11));
        assertTrue(quotes.contains(q12));
        assertTrue(quotes.contains(q13));
        assertTrue(quotes.contains(q14));
        assertTrue(quotes.contains(q15));
        assertTrue(quotes.contains(q16));
        assertTrue(quotes.contains(q17));
        assertTrue(quotes.contains(q18));
        assertTrue(quotes.contains(q19));
        assertTrue(quotes.contains(q20));
        assertTrue(quotes.contains(q21));
        assertTrue(quotes.contains(q22));
        assertTrue(quotes.contains(q23));
        assertTrue(quotes.contains(q24));
        assertTrue(quotes.contains(q25));
        assertTrue(quotes.contains(q26));
        assertTrue(quotes.contains(q27));
        assertTrue(quotes.contains(q28));
        assertTrue(quotes.contains(q29));
        assertTrue(quotes.contains(q30));
        assertTrue(quotes.contains(q31));
        assertTrue(quotes.contains(q32));
        assertTrue(quotes.contains(q33));
        assertTrue(quotes.contains(q34));
        assertTrue(quotes.contains("Chuck Norris can do multiple inheritance in Java."));
        assertTrue(quotes.contains("JVM never throws exceptions to Chuck Norris, not anymore. 753 killed Sun engineers is enough."));
        assertTrue(quotes.contains("Chuck Norris doesn’t need unit tests because his code always work. ALWAYS."));
        assertTrue(quotes.contains("Chuck Norris extends God."));
        assertTrue(quotes.contains("Chuck Norris workstation has so memory and it’s so powerful that he could run all java applications in the world and get 2% of resources usage."));
        assertTrue(quotes.contains("Chuck Norris codes generics since 1.3."));
        assertTrue(quotes.contains("Chuck Norris’ classes can’t be decompiled… don’t bother trying."));
    }

}
