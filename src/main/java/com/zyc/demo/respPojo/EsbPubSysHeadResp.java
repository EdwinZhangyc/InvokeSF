package com.zyc.demo.respPojo;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * ESB 响应公共报文 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "SvcId", "SvcScnId", "CnsmSysId", "PrvdSysId", "CnsmSysSeqNo", 
		"PrvdSysSeqNo", "Mac", "MacOrgId", "TranDate", "TranTime", "TranRetSt", "PrvdSysSvrId" })
public class EsbPubSysHeadResp implements Serializable {
	/* ESB 响应公共报文 SYS_HEAD*/
	@XmlElement(name = "SvcId")
	private String SvcId;//服务Id  
	@XmlElement(name = "SvcScnId")
	private String SvcScnId;//服务场景Id  
	@XmlElement(name = "CnsmSysId")
	private String CnsmSysId;//调用方系统Id 
	@XmlElement(name = "PrvdSysId")
	private String PrvdSysId;//提供方系统Id
	@XmlElement(name = "CnsmSysSeqNo")
	private String CnsmSysSeqNo;//调用方系统流水号
	@XmlElement(name = "PrvdSysSeqNo")
	private String PrvdSysSeqNo;//提供方系统流水号
	@XmlElement(name = "Mac")
	private String Mac;//MAC字段     
	@XmlElement(name = "MacOrgId")
	private String MacOrgId;//MAC机构号   
	@XmlElement(name = "TranDate")
	private String TranDate;//交易日期    
	@XmlElement(name = "TranTime")
	private String TranTime;//交易时间 
	@XmlElement(name = "TranRetSt")
	private String TranRetSt;//交易返回状态  
	@XmlElementWrapper(name="array")

	@XmlElement(name = "PrvdSysSvrId")
	private String PrvdSysSvrId;//提供方系统服务器Id  
	public String getSvcId() {
		return SvcId;
	}
	public void setSvcId(String svcId) {
		SvcId = svcId;
	}
	public String getSvcScnId() {
		return SvcScnId;
	}
	public void setSvcScnId(String svcScnId) {
		SvcScnId = svcScnId;
	}
	public String getCnsmSysId() {
		return CnsmSysId;
	}
	public void setCnsmSysId(String cnsmSysId) {
		CnsmSysId = cnsmSysId;
	}
	public String getPrvdSysId() {
		return PrvdSysId;
	}
	public void setPrvdSysId(String prvdSysId) {
		PrvdSysId = prvdSysId;
	}
	public String getCnsmSysSeqNo() {
		return CnsmSysSeqNo;
	}
	public void setCnsmSysSeqNo(String cnsmSysSeqNo) {
		CnsmSysSeqNo = cnsmSysSeqNo;
	}
	public String getPrvdSysSeqNo() {
		return PrvdSysSeqNo;
	}
	public void setPrvdSysSeqNo(String prvdSysSeqNo) {
		PrvdSysSeqNo = prvdSysSeqNo;
	}
	public String getMac() {
		return Mac;
	}
	public void setMac(String mac) {
		Mac = mac;
	}
	public String getMacOrgId() {
		return MacOrgId;
	}
	public void setMacOrgId(String macOrgId) {
		MacOrgId = macOrgId;
	}
	public String getTranDate() {
		return TranDate;
	}
	public void setTranDate(String tranDate) {
		TranDate = tranDate;
	}
	public String getTranTime() {
		return TranTime;
	}
	public void setTranTime(String tranTime) {
		TranTime = tranTime;
	}
	public String getTranRetSt() {
		return TranRetSt;
	}
	public void setTranRetSt(String tranRetSt) {
		TranRetSt = tranRetSt;
	}
	public String getPrvdSysSvrId() {
		return PrvdSysSvrId;
	}
	public void setPrvdSysSvrId(String prvdSysSvrId) {
		PrvdSysSvrId = prvdSysSvrId;
	}
	@Override
	public String toString() {
		return "EsbPubSysHeadResp [SvcId=" + SvcId + ", SvcScnId=" + SvcScnId + ", CnsmSysId=" + CnsmSysId
				+ ", PrvdSysId=" + PrvdSysId + ", CnsmSysSeqNo=" + CnsmSysSeqNo + ", PrvdSysSeqNo=" + PrvdSysSeqNo
				+ ", Mac=" + Mac + ", MacOrgId=" + MacOrgId + ", TranDate=" + TranDate + ", TranTime=" + TranTime
				+ ", TranRetSt=" + TranRetSt + ", PrvdSysSvrId=" + PrvdSysSvrId + "]";
	}
	
	
   
	
	
}
