
package net.scnetwork.bus.clients.qiwi;

import net.scnetwork.bus.utils.LogBus;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the net.scnetwork.bus.clients.qiwi package. 
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
    private static final String URL = "http://server.ishop.mw.ru/";
    private static final QName checkBill = new QName(URL, "checkBill");
    private static final QName createBill = new QName(URL, "createBill");
    private static final QName createBillResponse = new QName(URL, "createBillResponse");
    private static final QName cancelBillResponse = new QName(URL, "cancelBillResponse");
    private static final QName createBillCcyResponse = new QName(URL, "createBillCcyResponse");
    private static final QName createBillExtResponse = new QName(URL, "createBillExtResponse");
    private static final QName getBillListResponse = new QName(URL, "getBillListResponse");
    private static final QName getBillList = new QName(URL, "getBillList");
    private static final QName cancelBillPayedAmountResponse = new QName(URL, "cancelBillPayedAmountResponse");
    private static final QName createBillExt = new QName(URL, "createBillExt");
    private static final QName checkBillResponse = new QName(URL, "checkBillResponse");
    private static final QName checkRefund = new QName(URL, "checkRefund");
    private static final QName checkRefundResponse = new QName(URL, "checkRefundResponse");
    private static final QName cancelBillPayedAmount = new QName(URL, "cancelBillPayedAmount");
    private static final QName createBillCcy = new QName(URL, "createBillCcy");
    private static final QName cancelBill = new QName(URL, "cancelBill");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: net.scnetwork.bus.clients.qiwi
     * 
     */
    public ObjectFactory() {
        LogBus.info("QIWI started");
    }

    /**
     * Create an instance of {@link CancelBillResponse }
     * @return CancelBillResponse
     */
    public CancelBillResponse createCancelBillResponse() {
        return new CancelBillResponse();
    }

    /**
     * Create an instance of {@link CheckRefund }
     * @return CheckRefund
     */
    public CheckRefund createCheckRefund() {
        return new CheckRefund();
    }

    /**
     * Create an instance of {@link CancelBillPayedAmountResponse }
     * @return CancelBillPayedAmountResponse
     */
    public CancelBillPayedAmountResponse createCancelBillPayedAmountResponse() {
        return new CancelBillPayedAmountResponse();
    }

    /**
     * Create an instance of {@link CreateBillCcy }
     * @return CreateBillCcy
     */
    public CreateBillCcy createCreateBillCcy() {
        return new CreateBillCcy();
    }

    /**
     * Create an instance of {@link CheckRefundResponse }
     * @return CheckRefundResponse
     */
    public CheckRefundResponse createCheckRefundResponse() {
        return new CheckRefundResponse();
    }

    /**
     * Create an instance of {@link GetBillListResponse }
     * @return GetBillListResponse
     */
    public GetBillListResponse createGetBillListResponse() {
        return new GetBillListResponse();
    }

    /**
     * Create an instance of {@link CreateBillExt }
     * @return CreateBillExt
     */
    public CreateBillExt createCreateBillExt() {
        return new CreateBillExt();
    }

    /**
     * Create an instance of {@link GetBillList }
     * @return GetBillList
     */
    public GetBillList createGetBillList() {
        return new GetBillList();
    }

    /**
     * Create an instance of {@link CheckBillResponse }
     * @return CheckBillResponse
     */
    public CheckBillResponse createCheckBillResponse() {
        return new CheckBillResponse();
    }

    /**
     * Create an instance of {@link CreateBillResponse }
     * @return CreateBillResponse
     */
    public CreateBillResponse createCreateBillResponse() {
        return new CreateBillResponse();
    }

    /**
     * Create an instance of {@link CancelBill }
     * @return CancelBill
     */
    public CancelBill createCancelBill() {
        return new CancelBill();
    }

    /**
     * Create an instance of {@link CreateBillCcyResponse }
     * @return CreateBillCcyResponse
     */
    public CreateBillCcyResponse createCreateBillCcyResponse() {
        return new CreateBillCcyResponse();
    }

    /**
     * Create an instance of {@link CheckBill }
     * @return CheckBill
     */
    public CheckBill createCheckBill() {
        return new CheckBill();
    }

    /**
     * Create an instance of {@link CancelBillPayedAmount }
     * @return CancelBillPayedAmount
     */
    public CancelBillPayedAmount createCancelBillPayedAmount() {
        return new CancelBillPayedAmount();
    }

    /**
     * Create an instance of {@link CreateBillExtResponse }
     * @return CreateBillExtResponse
     */
    public CreateBillExtResponse createCreateBillExtResponse() {
        return new CreateBillExtResponse();
    }

    /**
     * Create an instance of {@link CreateBill }
     * @return CreateBill
     */
    public CreateBill createCreateBill() {
        return new CreateBill();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckBill }{@code >}}
     * @param value checkBill
     * @return element
     */
    @XmlElementDecl(namespace = "http://server.ishop.mw.ru/", name = "checkBill")
    public JAXBElement<CheckBill> createCheckBill(CheckBill value) {
        return new JAXBElement<>(checkBill, CheckBill.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateBill }{@code >}}
     * @param value createBill
     * @return element
     */
    @XmlElementDecl(namespace = "http://server.ishop.mw.ru/", name = "createBill")
    public JAXBElement<CreateBill> createCreateBill(CreateBill value) {
        return new JAXBElement<>(createBill, CreateBill.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateBillResponse }{@code >}}
     * @param value createBillResponse
     * @return element
     */
    @XmlElementDecl(namespace = "http://server.ishop.mw.ru/", name = "createBillResponse")
    public JAXBElement<CreateBillResponse> createCreateBillResponse(CreateBillResponse value) {
        return new JAXBElement<>(createBillResponse, CreateBillResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelBillResponse }{@code >}}
     * @param value cancelBillReponse
     * @return element
     */
    @XmlElementDecl(namespace = "http://server.ishop.mw.ru/", name = "cancelBillResponse")
    public JAXBElement<CancelBillResponse> createCancelBillResponse(CancelBillResponse value) {
        return new JAXBElement<>(cancelBillResponse, CancelBillResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateBillCcyResponse }{@code >}}
     * @param value createBillCcyResponse
     * @return element
     */
    @XmlElementDecl(namespace = "http://server.ishop.mw.ru/", name = "createBillCcyResponse")
    public JAXBElement<CreateBillCcyResponse> createCreateBillCcyResponse(CreateBillCcyResponse value) {
        return new JAXBElement<>(createBillCcyResponse, CreateBillCcyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateBillExtResponse }{@code >}}
     * @param value createBillExtResponse
     * @return element
     */
    @XmlElementDecl(namespace = "http://server.ishop.mw.ru/", name = "createBillExtResponse")
    public JAXBElement<CreateBillExtResponse> createCreateBillExtResponse(CreateBillExtResponse value) {
        return new JAXBElement<>(createBillExtResponse, CreateBillExtResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBillListResponse }{@code >}}
     * @param value getBillListReponse
     * @return element
     */
    @XmlElementDecl(namespace = "http://server.ishop.mw.ru/", name = "getBillListResponse")
    public JAXBElement<GetBillListResponse> createGetBillListResponse(GetBillListResponse value) {
        return new JAXBElement<>(getBillListResponse, GetBillListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBillList }{@code >}}
     * @param value getBillList
     * @return element
     */
    @XmlElementDecl(namespace = "http://server.ishop.mw.ru/", name = "getBillList")
    public JAXBElement<GetBillList> createGetBillList(GetBillList value) {
        return new JAXBElement<>(getBillList, GetBillList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelBillPayedAmountResponse }{@code >}}
     * @param value cancelBillPayedAmountResponse
     * @return element
     */
    @XmlElementDecl(namespace = "http://server.ishop.mw.ru/", name = "cancelBillPayedAmountResponse")
    public JAXBElement<CancelBillPayedAmountResponse> createCancelBillPayedAmountResponse(CancelBillPayedAmountResponse value) {
        return new JAXBElement<>(cancelBillPayedAmountResponse, CancelBillPayedAmountResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateBillExt }{@code >}}
     * @param value createBillExt
     * @return element
     */
    @XmlElementDecl(namespace = "http://server.ishop.mw.ru/", name = "createBillExt")
    public JAXBElement<CreateBillExt> createCreateBillExt(CreateBillExt value) {
        return new JAXBElement<>(createBillExt, CreateBillExt.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckBillResponse }{@code >}}
     * @param value checkBillResponse
     * @return element
     */
    @XmlElementDecl(namespace = "http://server.ishop.mw.ru/", name = "checkBillResponse")
    public JAXBElement<CheckBillResponse> createCheckBillResponse(CheckBillResponse value) {
        return new JAXBElement<>(checkBillResponse, CheckBillResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckRefund }{@code >}}
     * @param value checkRefund
     * @return element
     */
    @XmlElementDecl(namespace = "http://server.ishop.mw.ru/", name = "checkRefund")
    public JAXBElement<CheckRefund> createCheckRefund(CheckRefund value) {
        return new JAXBElement<>(checkRefund, CheckRefund.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckRefundResponse }{@code >}}
     * @param value checkRefundResponse
     * @return element
     */
    @XmlElementDecl(namespace = "http://server.ishop.mw.ru/", name = "checkRefundResponse")
    public JAXBElement<CheckRefundResponse> createCheckRefundResponse(CheckRefundResponse value) {
        return new JAXBElement<>(checkRefundResponse, CheckRefundResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelBillPayedAmount }{@code >}}
     * @param value cancelBillPayedAmount
     * @return element
     */
    @XmlElementDecl(namespace = "http://server.ishop.mw.ru/", name = "cancelBillPayedAmount")
    public JAXBElement<CancelBillPayedAmount> createCancelBillPayedAmount(CancelBillPayedAmount value) {
        return new JAXBElement<>(cancelBillPayedAmount, CancelBillPayedAmount.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateBillCcy }{@code >}}
     * @param value createBillCcy
     * @return element
     */
    @XmlElementDecl(namespace = "http://server.ishop.mw.ru/", name = "createBillCcy")
    public JAXBElement<CreateBillCcy> createCreateBillCcy(CreateBillCcy value) {
        return new JAXBElement<>(createBillCcy, CreateBillCcy.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelBill }{@code >}}
     * @param value cancelBill
     * @return element
     */
    @XmlElementDecl(namespace = "http://server.ishop.mw.ru/", name = "cancelBill")
    public JAXBElement<CancelBill> createCancelBill(CancelBill value) {
        return new JAXBElement<>(cancelBill, CancelBill.class, null, value);
    }

}
