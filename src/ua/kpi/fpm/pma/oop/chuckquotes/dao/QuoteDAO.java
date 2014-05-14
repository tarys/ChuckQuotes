package ua.kpi.fpm.pma.oop.chuckquotes.dao;

import ua.kpi.fpm.pma.oop.chuckquotes.Quote;

import java.util.List;

public interface QuoteDAO {
    List<Quote> getAllQuotes();

    Quote getQuote(int index);

    void removeQuote(int index);
}
