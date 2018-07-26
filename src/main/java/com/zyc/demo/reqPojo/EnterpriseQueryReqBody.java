package com.zyc.demo.reqPojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;

/**
 * 
 * @ClassName EsbBalanceReconReqBody
 * @Description 市场通查询现金管理出入金明细
 * @author 
 * @date 2016年9月10日
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"AppId","SessionKey","ValidTerm","PageType","OrgCode","OrgName","CrdtCode","BsnsLcnsNo","ClientName","QueryList"})
public class EnterpriseQueryReqBody implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2961981178445499310L;
	@XmlElement(name="AppId")
	private String AppId;  //应用ID
	@XmlElement(name="SessionKey")
	private String SessionKey;//私钥
	@XmlElement(name="ValidTerm")
	private String ValidTerm;//时效性
	@XmlElement(name="PageType")
	private String PageType; //分页类型
	@XmlElement(name="OrgCode")
	private String OrgCode; //组织机构代码
	@XmlElement(name="OrgName")
	private String OrgName; //机构名称
	@XmlElement(name="CrdtCode")
	private String CrdtCode;//信用代码
	@XmlElement(name="BsnsLcnsNo")
	private String BsnsLcnsNo; //营业执照号码
	@XmlElement(name="ClientName")
	private String ClientName; //客户名称
	@XmlElement(name="QueryList")
	private String QueryList; //查询列表

	@Override
	public String toString() {
		return "EnterpriseQueryReqBody [AppId=" + AppId + ", SessionKey="
				+ SessionKey + ", ValidTerm=" + ValidTerm + ", PageType=" + PageType
				+ ", OrgCode=" + OrgCode+ ", OrgName=" + OrgName + ", CrdtCode=" + CrdtCode 
				+ ", BsnsLcnsNo=" + BsnsLcnsNo + ", ClientName=" + ClientName+ ", QueryList=" + QueryList +"]";
	}


    
       
	
}
