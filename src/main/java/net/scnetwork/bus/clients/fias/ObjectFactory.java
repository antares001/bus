
package net.scnetwork.bus.clients.fias;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the net.scnetwork.bus.clients.fias package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: net.scnetwork.bus.clients.fias
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAllDownloadFileInfoResponse }
     * @return GetAllDownloadFileInfoResponse
     */
    public GetAllDownloadFileInfoResponse createGetAllDownloadFileInfoResponse() {
        return new GetAllDownloadFileInfoResponse();
    }

    /**
     * Create an instance of {@link GetLastDownloadFileInfo }
     * @return GetLastDownloadFileInfo
     */
    public GetLastDownloadFileInfo createGetLastDownloadFileInfo() {
        return new GetLastDownloadFileInfo();
    }

    /**
     * Create an instance of {@link DownloadFileInfo }
     * @return DownloadFileInfo
     */
    public DownloadFileInfo createDownloadFileInfo() {
        return new DownloadFileInfo();
    }

    /**
     * Create an instance of {@link GetLastDownloadFileInfoResponse }
     * @return GetLastDownloadFileInfoResponse
     */
    public GetLastDownloadFileInfoResponse createGetLastDownloadFileInfoResponse() {
        return new GetLastDownloadFileInfoResponse();
    }

    /**
     * Create an instance of {@link GetAllDownloadFileInfo }
     * @return createGetAllDownloadFileInfo
     */
    public GetAllDownloadFileInfo createGetAllDownloadFileInfo() {
        return new GetAllDownloadFileInfo();
    }

    /**
     * Create an instance of {@link ArrayOfDownloadFileInfo }
     * @return ArrayOfDownloadFileInfo
     */
    public ArrayOfDownloadFileInfo createArrayOfDownloadFileInfo() {
        return new ArrayOfDownloadFileInfo();
    }

}
