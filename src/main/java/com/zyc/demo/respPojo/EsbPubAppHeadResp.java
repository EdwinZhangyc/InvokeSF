package com.zyc.demo.respPojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * ESB 响应公共报文
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "TellerId", "BranchId", "TlrPswd", "TlrLvl", "TlrType", "ChkFlag", "AuthFlag", "AuthTlrId",
		"AuthBrchId" })
public class EsbPubAppHeadResp implements Serializable {

	/* ESB 响应公共报文 APP_HEAD */
	@XmlElement(name = "TellerId")
	private String TellerId;// 柜员Id
	@XmlElement(name = "BranchId")
	private String BranchId;// 机构Id
	@XmlElement(name = "TlrPswd")
	private String TlrPswd;// 柜员密码
	@XmlElement(name = "TlrLvl")
	private String TlrLvl;// 柜员级别
	@XmlElement(name = "TlrType")
	private String TlrType;// 柜员类别
	@XmlElement(name = "ChkFlag")
	private String ChkFlag;// 复核标志
	@XmlElement(name = "AuthFlag")
	private String AuthFlag;// 授权标志
	@XmlElement(name = "AuthTlrId")
	private String AuthTlrId;// 授权柜员Id
	@XmlElement(name = "AuthBrchId")
	private String AuthBrchId;// 授权机构Id

	public String getTellerId() {
		return TellerId;
	}

	public void setTellerId(String tellerId) {
		TellerId = tellerId;
	}

	public String getBranchId() {
		return BranchId;
	}

	public void setBranchId(String branchId) {
		BranchId = branchId;
	}

	public String getTlrPswd() {
		return TlrPswd;
	}

	public void setTlrPswd(String tlrPswd) {
		TlrPswd = tlrPswd;
	}

	public String getTlrLvl() {
		return TlrLvl;
	}

	public void setTlrLvl(String tlrLvl) {
		TlrLvl = tlrLvl;
	}

	public String getTlrType() {
		return TlrType;
	}

	public void setTlrType(String tlrType) {
		TlrType = tlrType;
	}

	public String getChkFlag() {
		return ChkFlag;
	}

	public void setChkFlag(String chkFlag) {
		ChkFlag = chkFlag;
	}

	public String getAuthFlag() {
		return AuthFlag;
	}

	public void setAuthFlag(String authFlag) {
		AuthFlag = authFlag;
	}

	public String getAuthTlrId() {
		return AuthTlrId;
	}

	public void setAuthTlrId(String authTlrId) {
		AuthTlrId = authTlrId;
	}

	public String getAuthBrchId() {
		return AuthBrchId;
	}

	public void setAuthBrchId(String authBrchId) {
		AuthBrchId = authBrchId;
	}

	@Override
	public String toString() {
		return "EsbPubAppHeadResp [TellerId=" + TellerId + ", BranchId=" + BranchId + ", TlrPswd=" + TlrPswd
				+ ", TlrLvl=" + TlrLvl + ", TlrType=" + TlrType + ", ChkFlag=" + ChkFlag + ", AuthFlag=" + AuthFlag
				+ ", AuthTlrId=" + AuthTlrId + ", AuthBrchId=" + AuthBrchId + "]";
	}

}
