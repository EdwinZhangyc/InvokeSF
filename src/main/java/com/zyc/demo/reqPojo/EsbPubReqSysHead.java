package com.zyc.demo.reqPojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "SvcId", "SvcScnId", "CnsmSysId", "ChnlType", "SrcSysId", 
		"CnsmSysSeqNo", "SrcSysSeqNo", "Mac", "MacOrgId", "TranMode", "TranDate",
		"TranTime", "TmnlNo","SrcSySysnlNo","CnsmSysSvrId","SrcSysSvrId"})

public class EsbPubReqSysHead implements Serializable {
	/* ESB 请求公共报文 SYS_HEAD*/
	@XmlElement(name="SvcId")
	private String SvcId; // 服务Id
	@XmlElement(name="SvcScnId")
	private String SvcScnId; // 服务场景Id
	@XmlElement(name="CnsmSysId")
	private String CnsmSysId; // 调用方系统Id
	@XmlElement(name="ChnlType")
	private String ChnlType; // 渠道类型
	@XmlElement(name="SrcSysId")
	private String SrcSysId; // 源发起系统Id
	@XmlElement(name="CnsmSysSeqNo")
	private String CnsmSysSeqNo; // 调用方系统流水号
	@XmlElement(name="SrcSysSeqNo")
	private String SrcSysSeqNo; // 源发起系统流水号
	@XmlElement(name="Mac")
	private String Mac; // MAC字段
	@XmlElement(name="MacOrgId")
	private String MacOrgId; // MAC机构号
	@XmlElement(name="TranMode")
	private String TranMode; // 交易模式
	@XmlElement(name="TranDate")
	private String TranDate; // 交易日期
	@XmlElement(name="TranTime")
	private String TranTime; // 交易时间
	@XmlElement(name="TmnlNo")
	private String TmnlNo; // 终端号
	@XmlElement(name="SrcSySysnlNo")
	private String SrcSySysnlNo; // 源发起系统终端号
	@XmlElement(name="CnsmSysSvrId")
	private String CnsmSysSvrId; // 调用方系统服务器Id
	@XmlElement(name="SrcSysSvrId")
	private String SrcSysSvrId; // 源发起系统服务器Id
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
	public String getChnlType() {
		return ChnlType;
	}
	public void setChnlType(String chnlType) {
		ChnlType = chnlType;
	}
	public String getSrcSysId() {
		return SrcSysId;
	}
	public void setSrcSysId(String srcSysId) {
		SrcSysId = srcSysId;
	}
	public String getCnsmSysSeqNo() {
		return CnsmSysSeqNo;
	}
	public void setCnsmSysSeqNo(String cnsmSysSeqNo) {
		CnsmSysSeqNo = cnsmSysSeqNo;
	}
	public String getSrcSysSeqNo() {
		return SrcSysSeqNo;
	}
	public void setSrcSysSeqNo(String srcSysSeqNo) {
		SrcSysSeqNo = srcSysSeqNo;
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
	public String getTranMode() {
		return TranMode;
	}
	public void setTranMode(String tranMode) {
		TranMode = tranMode;
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
	public String getTmnlNo() {
		return TmnlNo;
	}
	public void setTmnlNo(String tmnlNo) {
		TmnlNo = tmnlNo;
	}
	public String getSrcSySysnlNo() {
		return SrcSySysnlNo;
	}
	public void setSrcSySysnlNo(String srcSySysnlNo) {
		SrcSySysnlNo = srcSySysnlNo;
	}
	public String getCnsmSysSvrId() {
		return CnsmSysSvrId;
	}
	public void setCnsmSysSvrId(String cnsmSysSvrId) {
		CnsmSysSvrId = cnsmSysSvrId;
	}
	public String getSrcSysSvrId() {
		return SrcSysSvrId;
	}
	public void setSrcSysSvrId(String srcSysSvrId) {
		SrcSysSvrId = srcSysSvrId;
	}
	@Override
	public String toString() {
		return "EsbPubReqSysHead [SvcId=" + SvcId + ", SvcScnId=" + SvcScnId
				+ ", CnsmSysId=" + CnsmSysId + ", ChnlType=" + ChnlType
				+ ", SrcSysId=" + SrcSysId + ", CnsmSysSeqNo=" + CnsmSysSeqNo
				+ ", SrcSysSeqNo=" + SrcSysSeqNo + ", Mac=" + Mac
				+ ", MacOrgId=" + MacOrgId + ", TranMode=" + TranMode
				+ ", TranDate=" + TranDate + ", TranTime=" + TranTime
				+ ", TmnlNo=" + TmnlNo + ", SrcSySysnlNo=" + SrcSySysnlNo
				+ ", CnsmSysSvrId=" + CnsmSysSvrId + ", SrcSysSvrId="
				+ SrcSysSvrId + "]";
	}
	

	
   
	
}
