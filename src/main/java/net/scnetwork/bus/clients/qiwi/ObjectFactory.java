
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
    private final  QName _CheckBill_QNAME = new QName(URL, "checkBill");
    private final  QName _CreateBill_QNAME = new QName(URL, "createBill");
    private final  QName _CreateBillResponse_QNAME = new QName(URL, "createBillResponse");
    private final  QName _CancelBillResponse_QNAME = new QName(URL, "cancelBillResponse");
    private final  QName _CreateBillCcyResponse_QNAME = new QName(URL, "createBillCcyResponse");
    private final  QName _CreateBillExtResponse_QNAME = new QName(URL, "createBillExtResponse");
    private final  QName _GetBillListResponse_QNAME = new QName(URL, "getBillListResponse");
    private final  QName _GetBillList_QNAME = new QName(URL, "getBillList");
    private final  QName _CancelBillPayedAmountResponse_QNAME = new QName(URL, "cancelBillPayedAmountResponse");
    private final  QName _CreateBillExt_QNAME = new QName(URL, "createBillExt");
    private final  QName _CheckBillResponse_QNAME = new QName(URL, "checkBillResponse");
    private final  QName _CheckRefund_QNAME = new QName(URL, "checkRefund");
    private final  QName _CheckRefundResponse_QNAME = new QName(URL, "checkRefundResponse");
    private final  QName _CancelBillPayedAmount_QNAME = new QName(URL, "cancelBillPayedAmount");
    private final  QName _CreateBillCcy_QNAME = new QName(URL, "createBillCcy");
    private final  QName _CancelBill_QNAME = new QName(URL, "cancelBill");

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
        return new JAXBElement<>(_CheckBill_QNAME, CheckBill.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateBill }{@code >}}
     * @param value createBill
     * @return element
     */
    @XmlElementDecl(namespace = "http://server.ishop.mw.ru/", name = "createBill")
    public JAXBElement<CreateBill> createCreateBill(CreateBill value) {
        return new JAXBElement<>(_CreateBill_QNAME, CreateBill.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateBillResponse }{@code >}}
     * @param value createBillResponse
     * @return element
     */
    @XmlElementDecl(namespace = "http://server.ishop.mw.ru/", name = "createBillResponse")
    public JAXBElement<CreateBillResponse> createCreateBillResponse(CreateBillResponse value) {
        return new JAXBElement<>(_CreateBillResponse_QNAME, CreateBillResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelBillResponse }{@code >}}
     * @param value cancelBillReponse
     * @return element
     */
    @XmlElementDecl(namespace = "http://server.ishop.mw.ru/", name = "cancelBillResponse")
    public JAXBElement<CancelBillResponse> createCancelBillResponse(CancelBillResponse value) {
        return new JAXBElement<>(_CancelBillResponse_QNAME, CancelBillResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateBillCcyResponse }{@code >}}
     * @param value createBillCcyResponse
     * @return element
     */
    @XmlElementDecl(namespace = "http://server.ishop.mw.ru/", name = "createBillCcyResponse")
    public JAXBElement<CreateBillCcyResponse> createCreateBillCcyResponse(CreateBillCcyResponse value) {
        return new JAXBElement<>(_CreateBillCcyResponse_QNAME, CreateBillCcyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateBillExtResponse }{@code >}}
     * @param value createBillExtResponse
     * @return element
     */
    @XmlElementDecl(namespace = "http://server.ishop.mw.ru/", name = "createBillExtResponse")
    public JAXBElement<CreateBillExtResponse> createCreateBillExtResponse(CreateBillExtResponse value) {
        return new JAXBElement<>(_CreateBillExtResponse_QNAME, CreateBillExtResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBillListResponse }{@code >}}
     * @param value getBillListReponse
     * @return element
     */
    @XmlElementDecl(namespace = "http://server.ishop.mw.ru/", name = "getBillListResponse")
    public JAXBElement<GetBillListResponse> createGetBillListResponse(GetBillListResponse value) {
        return new JAXBElement<>(_GetBillListResponse_QNAME, GetBillListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBillList }{@code >}}
     * @param value getBillList
     * @return element
     */
    @XmlElementDecl(namespace = "http://server.ishop.mw.ru/", name = "getBillList")
    public JAXBElement<GetBillList> createGetBillList(GetBillList value) {
        return new JAXBElement<>(_GetBillList_QNAME, GetBillList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelBillPayedAmountResponse }{@code >}}
     * @param value cancelBillPayedAmountResponse
     * @return element
     */
    @XmlElementDecl(namespace = "http://server.ishop.mw.ru/", name = "cancelBillPayedAmountResponse")
    public JAXBElement<CancelBillPayedAmountResponse> createCancelBillPayedAmountResponse(CancelBillPayedAmountResponse value) {
        return new JAXBElement<>(_CancelBillPayedAmountResponse_QNAME, CancelBillPayedAmountResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateBillExt }{@code >}}
     * @param value createBillExt
     * @return element
     */
    @XmlElementDecl(namespace = "http://server.ishop.mw.ru/", name = "createBillExt")
    public JAXBElement<CreateBillExt> createCreateBillExt(CreateBillExt value) {
        return new JAXBElement<>(_CreateBillExt_QNAME, CreateBillExt.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckBillResponse }{@code >}}
     * @param value checkBillResponse
     * @return element
     */
    @XmlElementDecl(namespace = "http://server.ishop.mw.ru/", name = "checkBillResponse")
    public JAXBElement<CheckBillResponse> createCheckBillResponse(CheckBillResponse value) {
        return new JAXBElement<>(_CheckBillResponse_QNAME, CheckBillResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckRefund }{@code >}}
     * @param value checkRefund
     * @return element
     */
    @XmlElementDecl(namespace = "http://server.ishop.mw.ru/", name = "checkRefund")
    public JAXBElement<CheckRefund> createCheckRefund(CheckRefund value) {
        return new JAXBElement<>(_CheckRefund_QNAME, CheckRefund.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CheckRefundResponse }{@code >}}
     * @param value checkRefundResponse
     * @return element
     */
    @XmlElementDecl(namespace = "http://server.ishop.mw.ru/", name = "checkRefundResponse")
    public JAXBElement<CheckRefundResponse> createCheckRefundResponse(CheckRefundResponse value) {
        return new JAXBElement<>(_CheckRefundResponse_QNAME, CheckRefundResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelBillPayedAmount }{@code >}}
     * @param value cancelBillPayedAmount
     * @return element
     */
    @XmlElementDecl(namespace = "http://server.ishop.mw.ru/", name = "cancelBillPayedAmount")
    public JAXBElement<CancelBillPayedAmount> createCancelBillPayedAmount(CancelBillPayedAmount value) {
        return new JAXBElement<>(_CancelBillPayedAmount_QNAME, CancelBillPayedAmount.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateBillCcy }{@code >}}
     * @param value createBillCcy
     * @return element
     */
    @XmlElementDecl(namespace = "http://server.ishop.mw.ru/", name = "createBillCcy")
    public JAXBElement<CreateBillCcy> createCreateBillCcy(CreateBillCcy value) {
        return new JAXBElement<>(_CreateBillCcy_QNAME, CreateBillCcy.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CancelBill }{@code >}}
     * @param value cancelBill
     * @return element
     */
    @XmlElementDecl(namespace = "http://server.ishop.mw.ru/", name = "cancelBill")
    public JAXBElement<CancelBill> createCancelBill(CancelBill value) {
        return new JAXBElement<>(_CancelBill_QNAME, CancelBill.class, null, value);
    }

}
