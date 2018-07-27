package com.zyc.demo.reqPojo;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * 丰桥请求报文体
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "Order" })
public class SFOrderServiceReqBody implements Serializable {

    @XmlElement(name = "Order")
    private SFBodyOrderReqPojo Order;

    @XmlAccessorType(XmlAccessType.NONE)
    public static class SFBodyOrderReqPojo {

        @XmlAttribute(name = "orderid")
        private String orderid;//客户订单号

        @XmlAttribute(name = "express_type")
        //快件产品类别，详见附录《快件产品类别表》，只有在商务上与顺丰约定的类别方可使用。
        private String express_type;

        @XmlAttribute(name = "j_province")
        //寄件方所在省份 字段填写要求：必须是标准的省名称称谓 如：广东省，如果是直辖市，请直接传北京、上海等。
        private String j_province;

        @XmlAttribute(name = "j_city")
        //寄件方所在城市名称，字段填写要求：必须是标准的城市称谓 如：深圳市。
        private String j_city;

        @XmlAttribute(name = "j_company")
        //寄件方公司名称，如果需要生成电子运单，则为必填。
        private String j_company;

        @XmlAttribute(name = "j_contact")
        //寄件方联系人，如果需要生成电子运单，则为必填。
        private String j_contact;

        @XmlAttribute(name = "j_tel")
        //寄件方联系电话，如果需要生成电子运单，则为必填。
        private String j_tel;

        @XmlAttribute(name = "j_address")
        //寄件方详细地址，包括省市区，示例：“广东省深圳市福田区新洲十一街万基商务大厦10楼” ，如果需要生成电子运单，则为必填。
        private String j_address;

        @XmlAttribute(name = "d_province")
        /*
        到件方所在省份，必须是标准的省名称称谓 如：广东省，如果是直辖市，请直接传北京、上海等。如果此字段与d_city字段都有值，
        系统则直接使用这两个值而不是通过对d_address进行地址识别获取。为避免地址识别不成功的风险，建议传输此字段。
         */
        private String d_province;

        @XmlAttribute(name = "d_city")
        /*
        到件方所在城市名称，必须是标准的城市称谓 如：深圳市，如果是直辖市，请直接传北京（或北京市）、上海（或上海市）等。如果此字段与d_province字段都有值，
        顺丰系统则直接使用这两个值而不是对d_address进行地址识别获取。为避免地址识别不成功的风险，建议传输此字段。
         */
        private String d_city;

        @XmlAttribute(name = "d_county")
        //到件方所在县/区，必须是标准的县/区称谓，示例：“福田区”。
        private String d_county;

        @XmlAttribute(name = "d_company")
        //到件方公司名称
        private String d_company;

        @XmlAttribute(name = "d_contact")
        //到件方联系人
        private String d_contact;

        @XmlAttribute(name = "d_tel")
        //到件方联系电话
        private String d_tel;

        @XmlAttribute(name = "d_address")
        //到件方详细地址
        private String d_address;

        @XmlAttribute(name = "parcel_quantity")
        //包裹数，一个包裹对应一个运单号，如果是大于1个包裹，则返回则按照子母件的方式返回母运单号和子运单号。
        private String parcel_quantity;

        @XmlAttribute(name = "pay_method")
        //付款方式：1:寄方付2:收方付3:第三方付
        private String pay_method;

        @XmlAttribute(name = "custid")
        //顺丰月结卡号
        private String custid;

        @XmlAttribute(name = "customs_batchs")
        //报关批次
        private String customs_batchs;

        @XmlElement(name = "AddedService")
        private SFOrderAddedService AddedService;

        @Override
        public String toString() {
            return "SFOrderReqPojo{" +
                    "orderid='" + orderid + '\'' +
                    ", express_type='" + express_type + '\'' +
                    ", j_province='" + j_province + '\'' +
                    ", j_city='" + j_city + '\'' +
                    ", j_company='" + j_company + '\'' +
                    ", j_contact='" + j_contact + '\'' +
                    ", j_tel='" + j_tel + '\'' +
                    ", j_address='" + j_address + '\'' +
                    ", d_province='" + d_province + '\'' +
                    ", d_city='" + d_city + '\'' +
                    ", d_county='" + d_county + '\'' +
                    ", d_company='" + d_company + '\'' +
                    ", d_contact='" + d_contact + '\'' +
                    ", d_tel='" + d_tel + '\'' +
                    ", d_address='" + d_address + '\'' +
                    ", parcel_quantity='" + parcel_quantity + '\'' +
                    ", pay_method='" + pay_method + '\'' +
                    ", custid='" + custid + '\'' +
                    ", customs_batchs='" + customs_batchs + '\'' +
                    ", AddedService=" + AddedService +
                    '}';
        }

        public String getOrderid() {
            return orderid;
        }

        public void setOrderid(String orderid) {
            this.orderid = orderid;
        }

        public String getExpress_type() {
            return express_type;
        }

        public void setExpress_type(String express_type) {
            this.express_type = express_type;
        }

        public String getJ_province() {
            return j_province;
        }

        public void setJ_province(String j_province) {
            this.j_province = j_province;
        }

        public String getJ_city() {
            return j_city;
        }

        public void setJ_city(String j_city) {
            this.j_city = j_city;
        }

        public String getJ_company() {
            return j_company;
        }

        public void setJ_company(String j_company) {
            this.j_company = j_company;
        }

        public String getJ_contact() {
            return j_contact;
        }

        public void setJ_contact(String j_contact) {
            this.j_contact = j_contact;
        }

        public String getJ_tel() {
            return j_tel;
        }

        public void setJ_tel(String j_tel) {
            this.j_tel = j_tel;
        }

        public String getJ_address() {
            return j_address;
        }

        public void setJ_address(String j_address) {
            this.j_address = j_address;
        }

        public String getD_province() {
            return d_province;
        }

        public void setD_province(String d_province) {
            this.d_province = d_province;
        }

        public String getD_city() {
            return d_city;
        }

        public void setD_city(String d_city) {
            this.d_city = d_city;
        }

        public String getD_county() {
            return d_county;
        }

        public void setD_county(String d_county) {
            this.d_county = d_county;
        }

        public String getD_company() {
            return d_company;
        }

        public void setD_company(String d_company) {
            this.d_company = d_company;
        }

        public String getD_contact() {
            return d_contact;
        }

        public void setD_contact(String d_contact) {
            this.d_contact = d_contact;
        }

        public String getD_tel() {
            return d_tel;
        }

        public void setD_tel(String d_tel) {
            this.d_tel = d_tel;
        }

        public String getD_address() {
            return d_address;
        }

        public void setD_address(String d_address) {
            this.d_address = d_address;
        }

        public String getParcel_quantity() {
            return parcel_quantity;
        }

        public void setParcel_quantity(String parcel_quantity) {
            this.parcel_quantity = parcel_quantity;
        }

        public String getPay_method() {
            return pay_method;
        }

        public void setPay_method(String pay_method) {
            this.pay_method = pay_method;
        }

        public String getCustid() {
            return custid;
        }

        public void setCustid(String custid) {
            this.custid = custid;
        }

        public String getCustoms_batchs() {
            return customs_batchs;
        }

        public void setCustoms_batchs(String customs_batchs) {
            this.customs_batchs = customs_batchs;
        }

        public SFOrderAddedService getAddedService() {
            return AddedService;
        }

        public void setAddedService(SFOrderAddedService addedService) {
            AddedService = addedService;
        }
    }

    @XmlRootElement(name="AddedService")
    @XmlAccessorType(XmlAccessType.NONE)
    public static class SFOrderAddedService {
        @XmlAttribute(name = "name")
        private String name;
        @XmlAttribute(name = "value")
        private String value;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "SFOrderAddedService{" +
                    "name='" + name + '\'' +
                    ", value='" + value + '\'' +
                    '}';
        }
    }

    public SFBodyOrderReqPojo getOrder() {
        return Order;
    }

    public void setOrder(SFBodyOrderReqPojo order) {
        Order = order;
    }

    @Override
    public String toString() {
        return "SFOrderServiceReqBody{" +
                "Order=" + Order +
                '}';
    }
}