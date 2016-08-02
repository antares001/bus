
package net.scnetwork.bus.clients.qiwi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for cancelBillPayedAmountResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cancelBillPayedAmountResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cancelBillPayedAmountResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cancelBillPayedAmountResponse", propOrder = {
    "cancelBillPayedAmountResult"
})
public class CancelBillPayedAmountResponse {

    protected int cancelBillPayedAmountResult;

    /**
     * Gets the value of the cancelBillPayedAmountResult property.
     * 
     */
    public int getCancelBillPayedAmountResult() {
        return cancelBillPayedAmountResult;
    }

    /**
     * Sets the value of the cancelBillPayedAmountResult property.
     * 
     */
    public void setCancelBillPayedAmountResult(int value) {
        this.cancelBillPayedAmountResult = value;
    }

}
