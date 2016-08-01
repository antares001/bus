
package net.scnetwork.bus.clients.qiwi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for createBillExtResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="createBillExtResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="createBillExtResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createBillExtResponse", propOrder = {
    "createBillExtResult"
})
public class CreateBillExtResponse {

    protected int createBillExtResult;

    /**
     * Gets the value of the createBillExtResult property.
     * 
     */
    public int getCreateBillExtResult() {
        return createBillExtResult;
    }

    /**
     * Sets the value of the createBillExtResult property.
     * 
     */
    public void setCreateBillExtResult(int value) {
        this.createBillExtResult = value;
    }

}
