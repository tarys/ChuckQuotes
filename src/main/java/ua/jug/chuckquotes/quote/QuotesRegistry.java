package ua.jug.chuckquotes.quote;

import ua.jug.chuckquotes.exceptions.QuoteException;
import ua.jug.chuckquotes.quote.dao.HardCodedQuoteDao;
import ua.jug.chuckquotes.quote.dao.MySQLQuoteDao;
import ua.jug.chuckquotes.quote.dao.QuoteDao;

import java.util.List;

public class QuotesRegistry {

    private static QuotesRegistry instance;
    private final QuoteDao dao;

    public static synchronized QuotesRegistry getInstance() {
        if (instance == null) {
            instance = new QuotesRegistry();
        }
        return instance;
    }

    private QuotesRegistry() {
        dao = new HardCodedQuoteDao();
    }

    public List<Quote> getAll() throws QuoteException {
        return dao.getAllQuotes();
    }

    public Quote getNextQuote() throws QuoteException {
        return dao.getNextQuote();
    }

    public int size() throws QuoteException {
        return getAll().size();
    }

    public Quote get(int id) throws QuoteException {
        return dao.getQuote(id);
    }

    public void remove(int id) throws QuoteException {
        dao.removeQuote(id);
    }

    public void add(String quoteText) throws QuoteException {
        dao.addQuote(quoteText);
    }
}
