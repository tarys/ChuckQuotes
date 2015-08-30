package ua.jug.chuckquotes.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 */
@WebService
public interface ChuckQuotesSoapWebService extends Remote {

    @WebMethod
    String getNextQuote() throws RemoteException;
}
