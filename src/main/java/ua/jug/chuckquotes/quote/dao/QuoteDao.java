package ua.jug.chuckquotes.quote.dao;

import ua.jug.chuckquotes.quote.Quote;

import java.util.List;

public interface QuoteDao {
    List<Quote> getAllQuotes();

    Quote getQuote(int index);

    void removeQuote(int index);

    void addQuote(String quoteText);
}
