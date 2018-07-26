package com.test;

import com.zyc.demo.Utils.HttpUtils;
import com.zyc.demo.commons.XmlToPojoForBank;
import org.springframework.beans.factory.annotation.Value;

import java.security.MessageDigest;
import java.util.Map;

public class InvokeMethod {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(InvokeMethod.class);
    //接口url
    @Value("${express.sf.url}")
    private String url = "http://bsp-oisp.sf-express.com/bsp-oisp/sfexpressService";
    String clientCode;
    String checkword;

    /**
     * 获取顺丰下订单接口xml
     * @param params
     * @return
     */
    private String getOrderServiceRequestXml(Map<String,String> params){
        //订单号
        String orderNo = params.get("orderNo");
        //收件人
        String receiverName = params.get("receiverName");
        //收件人电话
        String receiverMobile = params.get("receiverMobile");
        //收件人详细地址
        String receiverAddress = params.get("address");
        //商品名称
        String commodityName = params.get("commodityName");
        //商品数量
        String orderNum = params.get("orderNum");


        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("<Request service='OrderService' lang='zh-CN'>");
        strBuilder.append("<Head>" + clientCode + "</Head>");
        strBuilder.append("<Body>");
        strBuilder.append("<Order").append(" ");
        strBuilder.append("orderid='" + orderNo.toString().trim() + "" + "'").append(" ");
        //返回顺丰运单号
        strBuilder.append("is_gen_bill_no='1'").append(" ");
        //寄件方信息
        //strBuilder.append("j_company='" +  + "'").append(" ");
        //strBuilder.append("j_contact='" + j_contact + "'").append(" ");
        //strBuilder.append("j_tel='" + j_tel + "'").append(" ");
        //strBuilder.append("j_address='" + j_province+j_city+j_county+j_address + "'").append(" ");
        ////收件方信息
        //strBuilder.append("d_company='" + d_company + "'").append(" ");
        strBuilder.append("d_contact='" + receiverName.toString().trim() + "'").append(" ");
        strBuilder.append("d_tel='" + receiverMobile.toString().trim() + "'").append(" ");
        strBuilder.append("d_address='" + receiverAddress.toString().trim() + "'").append(" ");
        strBuilder.append(" > ");
        //货物信息
        strBuilder.append("<Cargo").append(" ");
        strBuilder.append("name='" + commodityName + "'").append(" ");
        strBuilder.append("count='" + orderNum.toString() + "'").append(" ");
        strBuilder.append("unit='双'").append(">");
        strBuilder.append("</Cargo>");

        strBuilder.append("</Order>");
        strBuilder.append("</Body>");
        strBuilder.append("</Request>");

        return strBuilder.toString();
    }

    /**
     * 获取顺丰路由查询接口xml
     * @param params
     * @return
     */
    private String getRouteServiceRequestXml(Map<String,String> params){
        String orderNo = params.get("orderNo");
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("<Request service='RouteService' lang='zh-CN'>");
        strBuilder.append("<Head>" + clientCode + "</Head>");
        strBuilder.append("<Body>");
        strBuilder.append("<RouteRequest").append(" ");
        strBuilder.append("tracking_type='2'").append(" ");
        strBuilder.append("tracking_number='" + orderNo.toString().trim() + "" + "'").append(" >");
        strBuilder.append("</RouteRequest>");
        strBuilder.append("</Body>");
        strBuilder.append("</Request>");
        return strBuilder.toString();
    }


    /**
     * 顺丰接口
     * @param params
     * @param type  1-下订单接口  2-订单结果查询接口 3-路由查询接口
     * @return
     */
    public SfExpressResponse sfExpressMethod(Map<String,String> params, int type) throws Exception{
        logger.info("进入顺丰接口:params={},type={}", params.toString(),type);
        if (type < 1){
            logger.warn("调用接口类型传错");
            return null;
        }
        String requestXml = "";
        String methodName = "";
        if (type == 1){
            //1.获取下单xml
            requestXml = getOrderServiceRequestXml(params);
            methodName = "orderSerivce";
        } else if (type == 3){
            //1.获取订单物流路由
            requestXml = getRouteServiceRequestXml(params);
            methodName = "routeService";
        }
        //2.xml+checkword
        String verifyCode = requestXml + checkword;
        //3.MD5加密 + Base64编码
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(verifyCode.getBytes("utf8"));
        verifyCode = Base64Util.encode(md5.digest());
        //4.post 请求
        SFReqPojo sfReqPojo = new SFReqPojo();
        sfReqPojo.setXml(requestXml);
        sfReqPojo.setVerifyCode(requestXml);
        String toHttpParams = XmlToPojoForBank.convertToXml(sfReqPojo);
        logger.info("请求顺丰接口"+methodName, toHttpParams.toString());
        String resultStr = HttpUtils.doPost("http", url, toHttpParams);
        logger.info("请求顺丰接口"+methodName+",result="+resultStr);
        SfExpressResponse response = (SfExpressResponse)
                XmlToPojoForBank.converyToJavaBean(resultStr, SfExpressResponse.class);
        return response;
    }
}