package com.zyc.demo.interfaces.Impl;


import java.com.demo.Utils.HttpUtils;
import java.com.demo.Utils.ReflectUtil;
import java.com.demo.commons.XmlToPojoForBank;
import java.com.demo.interfaces.ISFApplyOrderService;
import java.com.demo.reqPojo.*;
import java.com.demo.respPojo.EnterpriseQueryRespPojo;
import java.com.demo.respPojo.SFOrderRespPojo;

//@Service("enterpriseQueryServiceImpl")
//@Validated
public class SFApplyOrderServiceImpl implements ISFApplyOrderService {
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(SFApplyOrderServiceImpl.class);
//	@Value("${bohf.enterprise.query.url}")
//	private String url;
//	@Value("${bohf.esb.url}")
	private String url;
	//@Value("${bohf.enterprise.query.appid}")
	private String appid;
	
	//@Value("${bohf.enterprise.query.privatekey}")
	private String privatekey;
	
//	@Value("${test.flag}")
//	private String testFlag;
	
	//@Value("${merchant.check}")
	private String merchantCheck;
//	private String merchantCheck = "1";


	@Override
	public SFOrderRespPojo applyOrder(SFOrderReqPojo reqPojo) throws Exception {
		if ("0".equals(merchantCheck)) {
			SFOrderRespPojo resp = new SFOrderRespPojo();
			resp.setRespCode("000000");
	        resp.setRespMsg("我是挡板！");
			return resp;
		}
		reqPojo.setAppId(appid);
		reqPojo.setSessionKey(privatekey);
		/* 调用请求信息转换String报文方法 */
		String json = reqPojoToXml(reqPojo);
		// 调用大数据平台企业工商数据查询服务 ，获得响应报文
		String xmlresp = HttpUtils.doPost("http", url, json);
		/* 将响应json报文转换成服务响应信息Pojo */
		SFOrderRespPojo resp = jsonToRespPojo(xmlresp);

		return resp;

	}


	private String reqPojoToXml(SFOrderReqPojo reqPojo) throws Exception {
		log.info("对请求pojo类SFOrderReqPojo进行xml报文转换："+reqPojo);
		/* 创建请求报文 */
		EnterpriseQueryReqPojo req=new EnterpriseQueryReqPojo();
		/* 创建请求公共报文 SYS_HEAD*/
		EsbPubReqSysHead sys=new EsbPubReqSysHead();
	    /* 创建请求公共报文 APP_HEAD*/
		EsbPubReqAppHead app=new EsbPubReqAppHead();
		/* 创建请求报文 BODY*/
		EnterpriseQueryReqBody body=new EnterpriseQueryReqBody();
		/* 设置请求报文 SYS_HEAD、APP_HEAD、BODY*/
		setReq(reqPojo,sys,app,body);
		req.setSYS_HEAD(sys);
		req.setAPP_HEAD(app);
		/* 给业务请求参数赋值*/
		req.setBODY(body);
		/* 将请求参数转换成xml报文 */
		String reqXml= XmlToPojoForBank.convertToXml(req);
		return reqXml;
	}

	/**
	 * @Method: setReq
	 * @Description: 设置请求报文
	 * @return void
	 */
	private void setReq(SFOrderReqPojo req, EsbPubReqSysHead sys, EsbPubReqAppHead app, EnterpriseQueryReqBody body) {
		/* 设置请求报文头sys_head */
		sys.setSvcId("120030041");// 服务Id
		sys.setSvcScnId("10");// 服务场景Id
		sys.setCnsmSysId("0022");// 调用方系统Id
		sys.setChnlType("");// 渠道类型
		sys.setSrcSysId("0020");// 源发起系统Id
		//sys.setCnsmSysSeqNo(reqPojo.getSerialNo());// 调用方系统流水号
		//sys.setSrcSysSeqNo(reqPojo.getAccountOrgNo());// 源发起系统流水号
		sys.setMac("");// MAC字段
		sys.setMacOrgId("");// MAC机构号
		sys.setTranMode("ONLINE");// 交易模式
		//sys.setTranDate(reqPojo.getBizDate());// 交易日期
		//sys.setTranTime(reqPojo.getBizTime());// 交易时间
		sys.setTmnlNo("");// 终端号
		sys.setSrcSySysnlNo("");// 源发起系统终端号
		sys.setCnsmSysSvrId("");// 调用方系统服务器Id
		sys.setSrcSysSvrId("");// 源发起系统服务器Id

		/* 设置请求报文头app_head */
		app.setTellerId("");// 柜员Id
		app.setBranchId("");// 机构Id
		app.setTlrPswd("");// 柜员密码
		app.setTlrLvl("");// 柜员级别
		app.setTlrType("");// 柜员类别
		app.setChkFlag("");// 复核标志
		app.setAuthFlag("");// 授权标志
		app.setAuthTlrId("");// 授权柜员Id
		app.setAuthTlrPswd("");// 授权柜员密码
		app.setAuthBrchId("");// 授权机构Id
		

		/* 设置请求报文体BODY */
		ReflectUtil.respTransmission(req, body);
	}

	/**
	 * @Method: jsonToRespPojo
	 * @Description: 反馈报文转换解析
	 */
	private SFOrderRespPojo jsonToRespPojo(String respJson) throws Exception {
		/** 声明服务请求反馈对象 */
		SFOrderRespPojo resp = new SFOrderRespPojo();
		resp.setRespCode("00");
		resp.setRespMsg("00");
		EnterpriseQueryRespPojo respInfo=XmlToPojoForBank.converyToJavaBean(respJson, EnterpriseQueryRespPojo.class);
		
        //String respCode=respInfo.getSYS_HEAD().getArray().get(0).getRetCode();
        //if("000000000000".equals(respCode)){
        //	respPojo.setRespCode(EnumRespMsg.SUCCESS.getRespCode());
    		//respPojo.setRespMsg(EnumRespMsg.SUCCESS.getRespMsg());
    		//respPojo.setOrgname(respInfo.getBODY().getQryRcrdMsg().getCoBscMsg().getCorpName());
    		//
    		////20170803将社会统一信用码及营业执照返回
    		//respPojo.setCreditCode(respInfo.getBODY().getQryRcrdMsg().getCoBscMsg().getCrdtCode());//社会统一信用码
    		//respPojo.setBusinessLicense(respInfo.getBODY().getQryRcrdMsg().getCoBscMsg().getBsnsLcnsNo());//营业执照
        //}
        //else
        //{
    		//respPojo.setRespMsg(respInfo.getSYS_HEAD().getArray().get(0).getRetMsg());
        //}
		return resp;
	}

}
