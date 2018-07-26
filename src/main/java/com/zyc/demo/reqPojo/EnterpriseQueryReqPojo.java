package com.zyc.demo.reqPojo;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Request")
@XmlType(propOrder = { "Head", "BODY"})
public class EnterpriseQueryReqPojo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4365359792604774387L;
	@XmlElement(name="Head")
	private String Head;// ESB 请求公共报文 SYS_HEAD
    @XmlElement(name="BODY")
	private EnterpriseQueryReqBody BODY;// ESB 请求报文 BODY
	@Override
	public String toString() {
		return "EnterpriseQueryReqPojo [SYS_HEAD="  + ", APP_HEAD="
				 + ", BODY=" + BODY + "]";
	}




	
    
       
	
}
