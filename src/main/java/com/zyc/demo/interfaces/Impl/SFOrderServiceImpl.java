package com.zyc.demo.interfaces.Impl;


import com.zyc.demo.Utils.ReflectUtil;
import com.zyc.demo.commons.InvokeSFTool;
import com.zyc.demo.commons.SFEncryption;
import com.zyc.demo.commons.XmlToPojoForBank;
import com.zyc.demo.interfaces.ISFOrderService;
import com.zyc.demo.reqPojo.SFOrderReqPojo;
import com.zyc.demo.reqPojo.SFOrderServiceReqBody;
import com.zyc.demo.reqPojo.SFOrderServiceReqPojo;
import com.zyc.demo.respPojo.SFOrderRespPojo;
import com.zyc.demo.respPojo.SFOrderServiceRespPojo;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 * 顺风下订单实现类
 */
@Service("SFOrderServiceImpl")
@Validated
public class SFOrderServiceImpl implements ISFOrderService {

	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(SFOrderServiceImpl.class);
	private String url = "http://bsp-oisp.sf-express.com/bsp-oisp/sfexpressService";
	private String SFCheck = "1";
	//private String checkword = "SLKJ2019";
	private String checkword = "XMFJSJ";
	private String service = "OrderService";
	private String lang = "zh-CN";

	public SFOrderRespPojo applyOrder(SFOrderReqPojo reqPojo) throws Exception {

		//此处测试时使用添加挡板
		if ("0".equals(this.SFCheck)) {
			SFOrderRespPojo resp = new SFOrderRespPojo();
			resp.setRespCode("ok");
	        resp.setRespMsg("我是挡板！");
			return resp;
		}
		/* 调用请求信息转换String报文方法 */
		String urlXML = reqPojoToXml(reqPojo);

		//String urlXML = "D:\\softWare\\windows\\IT\\主桥\\SF-CSIM-EXPRESS-SDK-V1.3\\callExpressRequest\\1.order.txt";
		// 调用主桥方法得到响应
		String xmlresp = InvokeSFTool.invokeSF(url, urlXML, checkword, SFEncryption.md5EncryptAndBase64(urlXML + checkword));

		// 将响应json报文转换成服务响应信息Pojo
		SFOrderRespPojo resp = jsonToRespPojo(xmlresp);

		return resp;
	}

	private String reqPojoToXml(SFOrderReqPojo reqPojo) throws Exception {

		/* 创建请求报文 */
		SFOrderServiceReqPojo req=new SFOrderServiceReqPojo();
		/* 设置根标签属性 */
		req.setService(service);
		req.setLang(lang);
		/* 创建请求公共报文 Head*/
		req.setHead(checkword);
		/* 创建请求报文 BODY*/
		SFOrderServiceReqBody body=new SFOrderServiceReqBody();
		/* 设置请求报文 BODY*/
		setReq(reqPojo, body);
		/* 给业务请求参数赋值*/
		req.setBody(body);
		/* 将请求参数转换成xml报文 */
		String reqXml= XmlToPojoForBank.convertToXml(req);

		return reqXml;
	}

	private void setReq(SFOrderReqPojo reqPojo, SFOrderServiceReqBody body) {

		SFOrderServiceReqBody.SFBodyOrderReqPojo sfBodyOrderReqPojo = new SFOrderServiceReqBody.SFBodyOrderReqPojo();
		SFOrderServiceReqBody.SFOrderAddedService sfOrderAddedService = new SFOrderServiceReqBody.SFOrderAddedService();
		ReflectUtil.respTransmission(reqPojo, sfOrderAddedService);
		ReflectUtil.respTransmission(reqPojo, sfBodyOrderReqPojo);
		sfBodyOrderReqPojo.setAddedService(sfOrderAddedService);
		body.setOrder(sfBodyOrderReqPojo);

	}


	/**
	 * @Method: jsonToRespPojo
	 * @Description: 反馈报文转换解析
	 */
	private SFOrderRespPojo jsonToRespPojo(String respJson) throws Exception {

		///** 声明服务请求反馈对象 */
		SFOrderRespPojo resp = new SFOrderRespPojo();
		SFOrderServiceRespPojo respInfo=XmlToPojoForBank.converyToJavaBean(respJson, SFOrderServiceRespPojo.class);

		if(respInfo.getHead().equals("OK")){
			resp.setRespCode("OK");
			resp.setRespMsg("下单成功");
			resp.setOrderid(respInfo.getBody().getOrderResponse().getOrderId());//客户订单号
			/*
			顺丰运单号，一个订单只能有一个母单号，如果是子母单的情况，以半角逗号分隔，主单号在第一个位置，
			如“755123456789,001123456789,002123456789” ，可用于顺丰电子运单标签打印。
			 */
			resp.setMailno(respInfo.getBody().getOrderResponse().getMailNo());
		} else {
			resp.setRespCode("ERR");
			resp.setRespMsg(respInfo.getERROR().getText());
		}
		System.out.println("响应报文内容为： \n" + resp.toString());
		return resp;
	}


	public static void main(String[] args){

		SFOrderServiceImpl bean = new SFOrderServiceImpl();
		SFOrderReqPojo sfOrderReqPojo = new SFOrderReqPojo();
		sfOrderReqPojo.setOrderid("QIAO-20180524001");
		sfOrderReqPojo.setExpress_type("2");
		sfOrderReqPojo.setJ_province("广东省");
		sfOrderReqPojo.setJ_city("深圳市");
		sfOrderReqPojo.setJ_company("顺丰镖局");
		sfOrderReqPojo.setJ_contact("张哥");
		sfOrderReqPojo.setJ_tel("15012345678");
		sfOrderReqPojo.setJ_address("福田区新洲十一街万基商务大厦26楼");
		sfOrderReqPojo.setD_province("广东省");
		sfOrderReqPojo.setD_city("广州市");
		sfOrderReqPojo.setD_county("");
		sfOrderReqPojo.setD_company("神罗科技");
		sfOrderReqPojo.setD_contact("风一样的超哥");
		sfOrderReqPojo.setD_tel("15611677703");
		sfOrderReqPojo.setD_address("海珠区宝芝林大厦701室");
		sfOrderReqPojo.setParcel_quantity("1");
		sfOrderReqPojo.setPay_method("3");
		sfOrderReqPojo.setCustid("7551234567");
		//sfOrderReqPojo.setCustoms_batchs("");
		sfOrderReqPojo.setName("COD");
		sfOrderReqPojo.setValue("1.01");
		try {
			bean.applyOrder(sfOrderReqPojo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
