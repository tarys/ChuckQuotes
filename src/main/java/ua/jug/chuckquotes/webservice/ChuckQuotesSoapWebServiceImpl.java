package ua.jug.chuckquotes.webservice;

import ua.jug.chuckquotes.exceptions.QuoteException;
import ua.jug.chuckquotes.quote.QuotesRegistry;

import javax.jws.WebService;
import java.rmi.RemoteException;

/**
 *
 */
@WebService(endpointInterface = "ua.jug.chuckquotes.webservice.ChuckQuotesSoapWebService")
public class ChuckQuotesSoapWebServiceImpl implements ChuckQuotesSoapWebService {
    @Override
    public String getNextQuote() throws RemoteException {
        final String quoteText;
        try {
            quoteText = QuotesRegistry.getInstance().getNextQuote().getText();
        } catch (QuoteException e) {
            throw new RemoteException("Error during service invocation", e);
        }

        return quoteText;
    }
}
