package ua.kpi.fpm.pma.oop.chuckquotes;

import ua.kpi.fpm.pma.oop.chuckquotes.dao.HardCodedQuoteDAO;
import ua.kpi.fpm.pma.oop.chuckquotes.dao.QuoteDAO;

import java.util.List;

public class QuotesRegistry {

    private int currentQuoteIndex;
    private final QuoteDAO dao;

    public QuotesRegistry() {
        dao = new HardCodedQuoteDAO();
    }

    public List<Quote> getAll() {
        return dao.getAllQuotes();
    }

    public Quote getNextQuote() {
        if(currentQuoteIndex >= size()){
            currentQuoteIndex = 0;
        }

        return get(currentQuoteIndex++);
    }

    public int size() {
        return getAll().size();
    }

    public Quote get(int index) {
        return dao.getQuote(index);
    }

    public void remove(int index) {
        dao.removeQuote(index);
    }

    public void add(String quoteText) {
        dao.addQuote(quoteText);
    }
}
