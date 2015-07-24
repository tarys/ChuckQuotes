package ua.jug.chuckquotes.quote.dao;

import ua.jug.chuckquotes.exceptions.QuoteException;
import ua.jug.chuckquotes.quote.Quote;
import ua.jug.chuckquotes.quote.QuotesRegistry;

import java.util.List;

public interface QuoteDao {
    List<Quote> getAllQuotes() throws QuoteException;

    Quote getQuote(int index) throws QuoteException;

    void removeQuote(int index) throws QuoteException;

    void addQuote(String quoteText) throws QuoteException;

    Quote getNextQuote() throws QuoteException;
}
