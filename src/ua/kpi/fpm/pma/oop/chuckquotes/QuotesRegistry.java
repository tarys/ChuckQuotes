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

    public List<Quote> getAllQuotes() {
        return dao.getAllQuotes();
    }

    public Quote getNextQuote() {
        if(currentQuoteIndex >= size()){
            currentQuoteIndex = 0;
        }

        return getQuote(currentQuoteIndex++);
    }

    public int size() {
        return getAllQuotes().size();
    }

    public Quote getQuote(int index) {
        return dao.getQuote(index);
    }
}
