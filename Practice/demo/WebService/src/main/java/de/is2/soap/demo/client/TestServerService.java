
package de.is2.soap.demo.client;

import javax.xml.namespace.QName;
import javax.xml.ws.*;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.0
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "TestServerService", targetNamespace = "http://service.demo.webservice.is2.de/", wsdlLocation = "http://localhost:8081/service/TestServer?wsdl")
public class TestServerService
    extends Service
{

    private final static URL TESTSERVERSERVICE_WSDL_LOCATION;
    private final static WebServiceException TESTSERVERSERVICE_EXCEPTION;
    private final static QName TESTSERVERSERVICE_QNAME = new QName("http://service.demo.webservice.is2.de/", "TestServerService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8081/service/TestServer?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        TESTSERVERSERVICE_WSDL_LOCATION = url;
        TESTSERVERSERVICE_EXCEPTION = e;
    }

    public TestServerService() {
        super(__getWsdlLocation(), TESTSERVERSERVICE_QNAME);
    }

    public TestServerService(WebServiceFeature... features) {
        super(__getWsdlLocation(), TESTSERVERSERVICE_QNAME, features);
    }

    public TestServerService(URL wsdlLocation) {
        super(wsdlLocation, TESTSERVERSERVICE_QNAME);
    }

    public TestServerService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, TESTSERVERSERVICE_QNAME, features);
    }

    public TestServerService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public TestServerService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns TestServer
     */
    @WebEndpoint(name = "TestServerPort")
    public TestServer getTestServerPort() {
        return super.getPort(new QName("http://service.demo.webservice.is2.de/", "TestServerPort"), TestServer.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns TestServer
     */
    @WebEndpoint(name = "TestServerPort")
    public TestServer getTestServerPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://service.demo.webservice.is2.de/", "TestServerPort"), TestServer.class, features);
    }

    private static URL __getWsdlLocation() {
        if (TESTSERVERSERVICE_EXCEPTION!= null) {
            throw TESTSERVERSERVICE_EXCEPTION;
        }
        return TESTSERVERSERVICE_WSDL_LOCATION;
    }

}
