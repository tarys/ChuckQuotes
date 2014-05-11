package ua.kpi.fpm.pma.oop.chuckquotes;

import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class QuotesRegistry {

    private ListIterator<String> iterator;
    private final QuoteDAO dao;

    public QuotesRegistry() {
        dao = new HardCodedQuoteDAO();
    }

    public List<String> getAllQuotes() {
        return dao.getAllQuotes();
    }

    public String getNextQuote() {
        if (iterator == null) {
            iterator = getAllQuotes().listIterator();
        }
        String nextQuote;
        try {
            nextQuote = iterator.next();
        } catch (NoSuchElementException e) {
            rewindToFirstElement();
            nextQuote = iterator.next();
        }
        return nextQuote;
    }

    public int size() {
        return getAllQuotes().size();
    }

    private void rewindToFirstElement() {
        while (iterator.hasPrevious()) iterator.previous();
    }
}
