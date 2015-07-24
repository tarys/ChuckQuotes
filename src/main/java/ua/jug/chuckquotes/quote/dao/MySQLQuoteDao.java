package ua.jug.chuckquotes.quote.dao;

import ua.jug.chuckquotes.exceptions.QuoteException;
import ua.jug.chuckquotes.quote.Quote;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class MySQLQuoteDao implements QuoteDao {

    private Map<Integer, Quote> cachedQuotes;
    private Iterator<Integer> currentMapKeysIterator;

    public MySQLQuoteDao() {
        this.cachedQuotes = new HashMap<>();
        this.currentMapKeysIterator = this.cachedQuotes.keySet().iterator();
    }

    @Override
    public List<Quote> getAllQuotes() throws QuoteException {
        rebuildCache();
        return new LinkedList<>(this.cachedQuotes.values());
    }

    @Override
    public Quote getQuote(int index) throws QuoteException {
        return this.cachedQuotes.get(index);
    }

    @Override
    public void removeQuote(int index) throws QuoteException {
        try (final Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/chuck_quotes", "root", "root");
             final PreparedStatement preparedStatement = connection.prepareStatement("DELETE * FROM quotes WHERE id = ?")) {
            preparedStatement.setInt(1, index);
            final boolean failedToDelete = preparedStatement.executeUpdate() != 1;
            if (failedToDelete) {
                throw new QuoteException("Error during deleting quote with id: " + index);
            }

        } catch (Exception e) {
            throw new QuoteException(e);
        }

        rebuildCache();
    }

    @Override
    public void addQuote(String quoteText) throws QuoteException {
        try (final Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/chuck_quotes", "root", "root");
             final PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO quotes (text) VALUES (?)")) {
            preparedStatement.setString(1, quoteText);
            final boolean failedToInsert = preparedStatement.executeUpdate() != 1;
            if (failedToInsert) {
                throw new QuoteException("Error during insertion of quote: " + quoteText);
            }

        } catch (Exception e) {
            throw new QuoteException(e);
        }

        rebuildCache();
    }

    @Override
    public Quote getNextQuote() throws QuoteException {

        if (!currentMapKeysIterator.hasNext()) {
            if (cachedQuotes.isEmpty()) {
                rebuildCache();
                if (cachedQuotes.isEmpty()) {
                    return null;
                }
            }
            currentMapKeysIterator = cachedQuotes.keySet().iterator();
        }

        int index = currentMapKeysIterator.next();
        return getQuote(index);
    }

    private void rebuildCache() throws QuoteException {
        this.cachedQuotes.clear();
        try (final Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/chuck_quotes", "root", "root");
             final PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM quotes")) {

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                final int index = resultSet.getInt("id");
                final String text = resultSet.getString("text");
                this.cachedQuotes.put(index, new Quote(index, text));
            }

        } catch (Exception e) {
            throw new QuoteException(e);
        }
    }
}
