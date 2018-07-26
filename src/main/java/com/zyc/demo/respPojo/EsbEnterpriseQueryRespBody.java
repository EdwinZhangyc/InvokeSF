package com.zyc.demo.respPojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * 
 * @ClassName EsbBalanceReconRespBody
 * @Description 市场通余额对账
 * @author zhaochen17273@hundsun.com
 * @date 2016年9月10日
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = { "ErrCode","RetNum","PageType","StartDate","EndDate"})
public class EsbEnterpriseQueryRespBody implements Serializable{
	
	@XmlElement(name = "ErrCode")
	private String ErrCode;
	@XmlElement(name = "RetNum")
	private String RetNum;
	@XmlElement(name = "PageType")
	private String PageType;
	@XmlElement(name = "StartDate")
	private String StartDate;
	@XmlElement(name = "EndDate")
	private String EndDate;

	
	public String getErrCode() {
		return ErrCode;
	}

	public void setErrCode(String errCode) {
		ErrCode = errCode;
	}

	public String getPageType() {
		return PageType;
	}


	public void setPageType(String pageType) {
		PageType = pageType;
	}


	public String getStartDate() {
		return StartDate;
	}


	public void setStartDate(String startDate) {
		StartDate = startDate;
	}


	public String getEndDate() {
		return EndDate;
	}


	public void setEndDate(String endDate) {
		EndDate = endDate;
	}

	
	public String getRetNum() {
		return RetNum;
	}
	public void setRetNum(String retNum) {
		RetNum = retNum;
	}

	@Override
	public String toString() {
		return "EsbEnterpriseQueryRespBody [ErrCode=" + ErrCode + ", RetNum=" + RetNum + ", PageType=" + PageType
				+ ", QryRcrdMsg=" +"]";
	}
	

}
