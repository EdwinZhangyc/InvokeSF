package com.zyc.demo.reqPojo;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * 组装丰桥xml报文，总JavaBean
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Request")
@XmlType(propOrder = { "service", "lang", "Head", "Body"})
public class SFOrderServiceReqPojo implements Serializable{

	@XmlAttribute(name = "service")
	private String service;
	@XmlAttribute(name = "lang")
	private String lang;
	@XmlElement(name="Head")
	private String Head;// 丰桥客户编码
    @XmlElement(name="Body")
	private SFOrderServiceReqBody Body;// 丰桥系统报文体

	@Override
	public String toString() {
		return "SFOrderServiceReqPojo{" +
				"service='" + service + '\'' +
				", lang='" + lang + '\'' +
				", Head='" + Head + '\'' +
				", Body=" + Body +
				'}';
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getHead() {
		return Head;
	}

	public void setHead(String head) {
		Head = head;
	}

	public SFOrderServiceReqBody getBody() {
		return Body;
	}

	public void setBody(SFOrderServiceReqBody body) {
		Body = body;
	}

}
