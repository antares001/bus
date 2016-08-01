
package net.scnetwork.bus.clients.qiwi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for createBillCcyResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="createBillCcyResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="createBillCcyResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createBillCcyResponse", propOrder = {
    "createBillCcyResult"
})
public class CreateBillCcyResponse {

    protected int createBillCcyResult;

    /**
     * Gets the value of the createBillCcyResult property.
     * 
     */
    public int getCreateBillCcyResult() {
        return createBillCcyResult;
    }

    /**
     * Sets the value of the createBillCcyResult property.
     * 
     */
    public void setCreateBillCcyResult(int value) {
        this.createBillCcyResult = value;
    }

}
