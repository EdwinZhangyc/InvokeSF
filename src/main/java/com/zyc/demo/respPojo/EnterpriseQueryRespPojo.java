package com.zyc.demo.respPojo;

import javax.xml.bind.annotation.*;
import java.io.Serializable;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "service")
@XmlType(propOrder = { "SYS_HEAD", "APP_HEAD", "BODY" })
public class EnterpriseQueryRespPojo implements Serializable {
	@XmlElement(name = "SYS_HEAD")
	private EsbPubSysHeadResp SYS_HEAD;
	@XmlElement(name = "APP_HEAD")
	private EsbPubAppHeadResp APP_HEAD;
	@XmlElement(name = "BODY")
	private EsbEnterpriseQueryRespBody BODY;
	
	public EsbPubSysHeadResp getSYS_HEAD() {
		return SYS_HEAD;
	}
	public void setSYS_HEAD(EsbPubSysHeadResp sYS_HEAD) {
		SYS_HEAD = sYS_HEAD;
	}
	public EsbPubAppHeadResp getAPP_HEAD() {
		return APP_HEAD;
	}
	public void setAPP_HEAD(EsbPubAppHeadResp aPP_HEAD) {
		APP_HEAD = aPP_HEAD;
	}
	public EsbEnterpriseQueryRespBody getBODY() {
		return BODY;
	}
	public void setBODY(EsbEnterpriseQueryRespBody bODY) {
		BODY = bODY;
	}
	@Override
	public String toString() {
		return "EnterpriseQueryRespPojo [SYS_HEAD=" + SYS_HEAD + ", APP_HEAD="
				+ APP_HEAD + ", BODY=" + BODY + "]";
	}

	
}
