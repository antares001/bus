
package net.scnetwork.bus.clients.qiwi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for checkRefund complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="checkRefund">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="login" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="txn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cancelIdx" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "checkRefund", propOrder = {
    "login",
    "password",
    "txn",
    "cancelIdx"
})
public class CheckRefund {

    protected String login;
    protected String password;
    protected String txn;
    protected int cancelIdx;

    /**
     * Gets the value of the login property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLogin() {
        return login;
    }

    /**
     * Sets the value of the login property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLogin(String value) {
        this.login = value;
    }

    /**
     * Gets the value of the password property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the value of the password property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * Gets the value of the txn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTxn() {
        return txn;
    }

    /**
     * Sets the value of the txn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTxn(String value) {
        this.txn = value;
    }

    /**
     * Gets the value of the cancelIdx property.
     * 
     */
    public int getCancelIdx() {
        return cancelIdx;
    }

    /**
     * Sets the value of the cancelIdx property.
     * 
     */
    public void setCancelIdx(int value) {
        this.cancelIdx = value;
    }

}
