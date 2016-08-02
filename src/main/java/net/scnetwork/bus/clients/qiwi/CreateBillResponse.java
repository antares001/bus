
package net.scnetwork.bus.clients.qiwi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for createBillResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="createBillResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="createBillResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createBillResponse", propOrder = {
    "createBillResult"
})
public class CreateBillResponse {

    protected int createBillResult;

    /**
     * Gets the value of the createBillResult property.
     * 
     */
    public int getCreateBillResult() {
        return createBillResult;
    }

    /**
     * Sets the value of the createBillResult property.
     * 
     */
    public void setCreateBillResult(int value) {
        this.createBillResult = value;
    }

}
