package ua.jug.chuckquotes.quote.dao;

import ua.jug.chuckquotes.exceptions.QuoteException;
import ua.jug.chuckquotes.quote.Quote;
import ua.jug.chuckquotes.quote.QuotesRegistry;

import java.util.*;

public class HardCodedQuoteDao implements QuoteDao {

    private int currentQuoteIndex;
    private final Map<Integer, Quote> quotesMap;

    public HardCodedQuoteDao() {
        int id = 0;
        quotesMap = new TreeMap<>(); // order of elements matters

        quotesMap.put(id, new Quote(id++, "Chuck Norris can make a class that is both abstract and final."));
        quotesMap.put(id, new Quote(id++, "Chuck Norris serializes objects straight into human skulls."));
        quotesMap.put(id, new Quote(id++, "Chuck Norris doesn’t deploy web applications, he round-house kicks them into the server."));
        quotesMap.put(id, new Quote(id++, "Chuck Norris always uses his own design patterns, and his favorite is the Round-house Kick."));
        quotesMap.put(id, new Quote(id++, "Chuck Norris could use anything in java.util.* to kill you, including the javadocs."));
        quotesMap.put(id, new Quote(id++, "Chuck Norris can hit you so hard your web app will turn into a swing application, and a very bad swing application containing lots of icons of human skulls."));
        quotesMap.put(id, new Quote(id++, "Chuck Norris demonstrated the meaning of Float.POSITIVE_INFINITY by counting to it, twice."));
        quotesMap.put(id, new Quote(id++, "A synchronize doesn’t protect against Chuck Norris, if he wants the object, he takes it."));
        quotesMap.put(id, new Quote(id++, "Chuck Norris doesn’t use javac, he codes java by using a binary editor on the class files."));
        quotesMap.put(id, new Quote(id++, "Chuck Norris’ java code never needs to be optimized. His code is so fast that it broke the speed of light during a test run in Sun’s labs killing 37 people."));
        quotesMap.put(id, new Quote(id++, "When someone attempts to use one of Chuck Norris’ deprecated methods, they automatically get a round-house kick to the face at compile time."));
        quotesMap.put(id, new Quote(id++, "The java.lang package originally contained a ChuckNorris class, but it punched its way out the package during a design review and round-house kicked Bill Joy in the face."));
        quotesMap.put(id, new Quote(id++, "Chuck Norris never has a bug in his code, EVER!"));
        quotesMap.put(id, new Quote(id++, "Chuck Norris doesn’t write code. He stares at a computer screen until he gets the program he wants."));
        quotesMap.put(id, new Quote(id++, "Code runs faster when Chuck Norris watches it."));
        quotesMap.put(id, new Quote(id++, "Chuck Norris’ binary edited classes ignore Java bytecode verifier."));
        quotesMap.put(id, new Quote(id++, "Chuck Norris methods doesn’t catch exceptions because no one has the guts to throw any at them."));
        quotesMap.put(id, new Quote(id++, "Chuck Norris will cast a value to any type just by staring at it."));
        quotesMap.put(id, new Quote(id++, "If you get a ChuckNorrisException you’ll probably die."));
        quotesMap.put(id, new Quote(id++, "Chuck Norris is the only one who can use goto and const in Java."));
        quotesMap.put(id, new Quote(id++, "Chuck Norris can compile Java code in .NET Framework, obviously just by staring at it."));
        quotesMap.put(id, new Quote(id++, "Chuck don't need to catch an Exception because Java is afraid of the “flying tornado kick” at the moment it throws."));
        quotesMap.put(id, new Quote(id++, "Chuck Norris’s code can round-house kick all other Java Objects’ privates."));
        quotesMap.put(id, new Quote(id++, "Java visibility levels are public, default, protected, private and “protected by Chuck Norris”, don’t try to access a field with this last modifier!!"));
        quotesMap.put(id, new Quote(id++, "Chuck Norris eats JavaBeans and Round-house Kicks JavaServer Faces!"));
        quotesMap.put(id, new Quote(id++, "Chuck Norris can divide by 0!"));
        quotesMap.put(id, new Quote(id++, "Garbage collector only runs on Chuck Norris code to collect the bodies."));
        quotesMap.put(id, new Quote(id++, "Chuck Norris code uses aggressive heap natively."));
        quotesMap.put(id, new Quote(id++, "Every single line code of Chuck Norris runs in real time. Even in a multi threading application."));
        quotesMap.put(id, new Quote(id++, "When a CPU load a Chuck Norris class file, it doubles the speed."));
        quotesMap.put(id, new Quote(id++, "Chuck Norris can execute 64bit length instructions in a 32bit CPU."));
        quotesMap.put(id, new Quote(id++, "Chuck Norris implements “Indestructible”. All the other creatures implements “Killable”."));
        quotesMap.put(id, new Quote(id++, "Chuck Norris only program Java web applications to get a .WAR in the end."));
        quotesMap.put(id, new Quote(id++, "Chuck Norris once round-house kicked a Java class very hard. The result is known as a inner class."));
        quotesMap.put(id, new Quote(id++, "Chuck Norris can do multiple inheritance in Java."));
        quotesMap.put(id, new Quote(id++, "JVM never throws exceptions to Chuck Norris, not anymore. 753 killed Sun engineers is enough."));
        quotesMap.put(id, new Quote(id++, "Chuck Norris doesn’t need unit tests because his code always work. ALWAYS."));
        quotesMap.put(id, new Quote(id++, "Chuck Norris extends God."));
        quotesMap.put(id, new Quote(id++, "Chuck Norris workstation has so memory and it’s so powerful that he could run all java applications in the world and get 2% of resources usage."));
        quotesMap.put(id, new Quote(id++, "Chuck Norris codes generics since 1.3."));
        quotesMap.put(id, new Quote(id, "Chuck Norris’ classes can’t be decompiled… don’t bother trying."));
    }

    public List<Quote> getAllQuotes() {
        return new LinkedList<>(quotesMap.values());
    }

    @Override
    public Quote getQuote(int id) {
        return quotesMap.get(id);
    }

    @Override
    public void removeQuote(int id) {
        quotesMap.remove(id);
    }

    @Override
    public void addQuote(String quoteText) {
        int maxIndex = 0;
        for (Integer currentIndex : quotesMap.keySet()) {
            if (currentIndex > maxIndex) {
                maxIndex = currentIndex;
            }
        }

        final int newIndex = maxIndex + 1;
        quotesMap.put(newIndex, new Quote(newIndex, quoteText));
    }

    @Override
    public Quote getNextQuote() throws QuoteException {
        if(currentQuoteIndex >= quotesMap.size()){
            currentQuoteIndex = 0;
        }

        return getQuote(currentQuoteIndex++);
    }
}
