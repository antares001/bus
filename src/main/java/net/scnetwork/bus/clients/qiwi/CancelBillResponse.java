
package net.scnetwork.bus.clients.qiwi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cancelBillResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cancelBillResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cancelBillResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cancelBillResponse", propOrder = {
    "cancelBillResult"
})
public class CancelBillResponse {

    protected int cancelBillResult;

    /**
     * Gets the value of the cancelBillResult property.
     * 
     */
    public int getCancelBillResult() {
        return cancelBillResult;
    }

    /**
     * Sets the value of the cancelBillResult property.
     * 
     */
    public void setCancelBillResult(int value) {
        this.cancelBillResult = value;
    }

}
