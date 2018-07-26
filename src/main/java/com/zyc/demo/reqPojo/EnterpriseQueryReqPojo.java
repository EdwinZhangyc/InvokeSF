package com.zyc.demo.reqPojo;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * 
 * @ClassName EsbBalanceReconReqPojo
 * @Description 工商信息查询
 * @date 2016年9月10日
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "service")
@XmlType(propOrder = { "SYS_HEAD", "APP_HEAD","BODY"})
public class EnterpriseQueryReqPojo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4365359792604774387L;
	@XmlElement(name="SYS_HEAD")
	private EsbPubReqSysHead SYS_HEAD;// ESB 请求公共报文 SYS_HEAD
    @XmlElement(name="APP_HEAD")
	private EsbPubReqAppHead APP_HEAD;// ESB 请求公共报文 APP_HEAD
    @XmlElement(name="BODY")
	private EnterpriseQueryReqBody BODY;// ESB 请求报文 BODY
	public EsbPubReqSysHead getSYS_HEAD() {
		return SYS_HEAD;
	}
	public void setSYS_HEAD(EsbPubReqSysHead sYS_HEAD) {
		SYS_HEAD = sYS_HEAD;
	}
	public EsbPubReqAppHead getAPP_HEAD() {
		return APP_HEAD;
	}
	public void setAPP_HEAD(EsbPubReqAppHead aPP_HEAD) {
		APP_HEAD = aPP_HEAD;
	}
	public EnterpriseQueryReqBody getBODY() {
		return BODY;
	}
	public void setBODY(EnterpriseQueryReqBody bODY) {
		BODY = bODY;
	}
	@Override
	public String toString() {
		return "EnterpriseQueryReqPojo [SYS_HEAD=" + SYS_HEAD + ", APP_HEAD="
				+ APP_HEAD + ", BODY=" + BODY + "]";
	}




	
    
       
	
}
