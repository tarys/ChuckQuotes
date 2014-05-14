package ua.kpi.fpm.pma.oop.chuckquotes.dao;

import ua.kpi.fpm.pma.oop.chuckquotes.Quote;

import java.util.*;

public class HardCodedQuoteDAO implements QuoteDAO {

    private final Map<Integer, Quote> quotesMap;

    public HardCodedQuoteDAO() {
        int index = 0;
        quotesMap = new TreeMap<>(); // order of elements matters

        quotesMap.put(index, new Quote(index++, "Chuck Norris can make a class that is both abstract and final."));
        quotesMap.put(index, new Quote(index++, "Chuck Norris serializes objects straight into human skulls."));
        quotesMap.put(index, new Quote(index++, "Chuck Norris doesn’t deploy web applications, he round-house kicks them into the server."));
        quotesMap.put(index, new Quote(index++, "Chuck Norris always uses his own design patterns, and his favorite is the Round-house Kick."));
        quotesMap.put(index, new Quote(index++, "Chuck Norris could use anything in java.util.* to kill you, including the javadocs."));
        quotesMap.put(index, new Quote(index++, "Chuck Norris can hit you so hard your web app will turn into a swing application, and a very bad swing application containing lots of icons of human skulls."));
        quotesMap.put(index, new Quote(index++, "Chuck Norris demonstrated the meaning of Float.POSITIVE_INFINITY by counting to it, twice."));
        quotesMap.put(index, new Quote(index++, "A synchronize doesn’t protect against Chuck Norris, if he wants the object, he takes it."));
        quotesMap.put(index, new Quote(index++, "Chuck Norris doesn’t use javac, he codes java by using a binary editor on the class files."));
        quotesMap.put(index, new Quote(index++, "Chuck Norris’ java code never needs to be optimized. His code is so fast that it broke the speed of light during a test run in Sun’s labs killing 37 people."));
        quotesMap.put(index, new Quote(index++, "When someone attempts to use one of Chuck Norris’ deprecated methods, they automatically get a round-house kick to the face at compile time."));
        quotesMap.put(index, new Quote(index++, "The java.lang package originally contained a ChuckNorris class, but it punched its way out the package during a design review and round-house kicked Bill Joy in the face."));
        quotesMap.put(index, new Quote(index++, "Chuck Norris never has a bug in his code, EVER!"));
        quotesMap.put(index, new Quote(index++, "Chuck Norris doesn’t write code. He stares at a computer screen until he gets the program he wants."));
        quotesMap.put(index, new Quote(index++, "Code runs faster when Chuck Norris watches it."));
        quotesMap.put(index, new Quote(index++, "Chuck Norris’ binary edited classes ignore Java bytecode verifier."));
        quotesMap.put(index, new Quote(index++, "Chuck Norris methods doesn’t catch exceptions because no one has the guts to throw any at them."));
        quotesMap.put(index, new Quote(index++, "Chuck Norris will cast a value to any type just by staring at it."));
        quotesMap.put(index, new Quote(index++, "If you get a ChuckNorrisException you’ll probably die."));
        quotesMap.put(index, new Quote(index++, "Chuck Norris is the only one who can use goto and const in Java."));
        quotesMap.put(index, new Quote(index++, "Chuck Norris can compile Java code in .NET Framework, obviously just by staring at it."));
        quotesMap.put(index, new Quote(index++, "Chuck don't need to catch an Exception because Java is afraid of the “flying tornado kick” at the moment it throws."));
        quotesMap.put(index, new Quote(index++, "Chuck Norris’s code can round-house kick all other Java Objects’ privates."));
        quotesMap.put(index, new Quote(index++, "Java visibility levels are public, default, protected, private and “protected by Chuck Norris”, don’t try to access a field with this last modifier!!"));
        quotesMap.put(index, new Quote(index++, "Chuck Norris eats JavaBeans and Round-house Kicks JavaServer Faces!"));
        quotesMap.put(index, new Quote(index++, "Chuck Norris can divide by 0!"));
        quotesMap.put(index, new Quote(index++, "Garbage collector only runs on Chuck Norris code to collect the bodies."));
        quotesMap.put(index, new Quote(index++, "Chuck Norris code uses aggressive heap natively."));
        quotesMap.put(index, new Quote(index++, "Every single line code of Chuck Norris runs in real time. Even in a multi threading application."));
        quotesMap.put(index, new Quote(index++, "When a CPU load a Chuck Norris class file, it doubles the speed."));
        quotesMap.put(index, new Quote(index++, "Chuck Norris can execute 64bit length instructions in a 32bit CPU."));
        quotesMap.put(index, new Quote(index++, "Chuck Norris implements “Indestructible”. All the other creatures implements “Killable”."));
        quotesMap.put(index, new Quote(index++, "Chuck Norris only program Java web applications to get a .WAR in the end."));
        quotesMap.put(index, new Quote(index++, "Chuck Norris once round-house kicked a Java class very hard. The result is known as a inner class."));
        quotesMap.put(index, new Quote(index++, "Chuck Norris can do multiple inheritance in Java."));
        quotesMap.put(index, new Quote(index++, "JVM never throws exceptions to Chuck Norris, not anymore. 753 killed Sun engineers is enough."));
        quotesMap.put(index, new Quote(index++, "Chuck Norris doesn’t need unit tests because his code always work. ALWAYS."));
        quotesMap.put(index, new Quote(index++, "Chuck Norris extends God."));
        quotesMap.put(index, new Quote(index++, "Chuck Norris workstation has so memory and it’s so powerful that he could run all java applications in the world and get 2% of resources usage."));
        quotesMap.put(index, new Quote(index++, "Chuck Norris codes generics since 1.3."));
        quotesMap.put(index, new Quote(index, "Chuck Norris’ classes can’t be decompiled… don’t bother trying."));
    }

    public List<Quote> getAllQuotes() {
        return new LinkedList<>(quotesMap.values());
    }

    @Override
    public Quote getQuote(int index) {
        return quotesMap.get(index);
    }

    @Override
    public void removeQuote(int index) {
        quotesMap.remove(index);
    }
}
