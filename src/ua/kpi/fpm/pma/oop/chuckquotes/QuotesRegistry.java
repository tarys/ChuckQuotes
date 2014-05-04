package ua.kpi.fpm.pma.oop.chuckquotes;

import java.util.Iterator;
import java.util.List;

public class QuotesRegistry {

    private Iterator<String> iterator;
    private final QuoteDAO dao;

    public QuotesRegistry() {
        dao = new HardCodedQuoteDAO();
    }

    public List<String> getAllQuotes() {
        return dao.getAllQuotes();
    }

    public String getNextQuote() {
        if (iterator == null) {
            iterator = getAllQuotes().iterator();
        }
        return iterator.next();
    }
}
