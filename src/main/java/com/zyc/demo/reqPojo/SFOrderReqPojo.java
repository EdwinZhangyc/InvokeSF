package com.zyc.demo.reqPojo;


public class SFOrderReqPojo extends BaseNormalReqPojo {
	/**
	 * @Fields serialVersionUID : TODO
	 */
	//组织机构号不要了改换成社会统一认证码
	private static final long serialVersionUID = -5541907644896398593L;
	//private String cid;// 组织机构代码
//	private String registrationCode;// 营业执照号码
//	private String cname;// 机构名称
//	private String creditCode;//社会统一认证码
	
	private String AppId;  //应用ID
	private String SessionKey;//私钥
	private String ValidTerm;//时效性
	private String PageType; //分页类型
	private String OrgCode; //组织机构代码
	private String OrgName; //机构名称
	private String CrdtCode;//信用代码
	private String BsnsLcnsNo; //营业执照号码
	private String ClientName; //客户名称
	private String QueryList; //查询列表

//	public String getCreditCode() {
//		return creditCode;
//	}
//	public void setCreditCode(String creditCode) {
//		this.creditCode = creditCode;
//	}
	//	public String getCid() {
//		return cid;
//	}
//	public void setCid(String cid) {
//		this.cid = cid;
//	}
//	public String getRegistrationCode() {
//		return registrationCode;
//	}
//	public void setRegistrationCode(String registrationCode) {
//		this.registrationCode = registrationCode;
//	}
//	public String getCname() {
//		return cname;
//	}
//	public void setCname(String cname) {
//		this.cname = cname;
//	}


	@Override
	public String toString() {
		return "SFOrderReqPojo [SessionKey=" + SessionKey + ", ValidTerm=" +ValidTerm + ", PageType=" + PageType
				+", OrgCode=" +OrgCode +", OrgName=" +OrgName +", CrdtCode=" +CrdtCode 
				+", BsnsLcnsNo=" +BsnsLcnsNo + ", ClientName=" +ClientName +", QueryList=" +QueryList + "]";
	}
	public String getAppId() {
		return AppId;
	}
	public void setAppId(String appId) {
		AppId = appId;
	}
	public String getSessionKey() {
		return SessionKey;
	}
	public void setSessionKey(String sessionKey) {
		SessionKey = sessionKey;
	}
	public String getValidTerm() {
		return ValidTerm;
	}
	public void setValidTerm(String validTerm) {
		ValidTerm = validTerm;
	}
	public String getPageType() {
		return PageType;
	}
	public void setPageType(String pageType) {
		PageType = pageType;
	}
	public String getOrgCode() {
		return OrgCode;
	}
	public void setOrgCode(String orgCode) {
		OrgCode = orgCode;
	}
	public String getOrgName() {
		return OrgName;
	}
	public void setOrgName(String orgName) {
		OrgName = orgName;
	}
	public String getCrdtCode() {
		return CrdtCode;
	}
	public void setCrdtCode(String crdtCode) {
		CrdtCode = crdtCode;
	}
	public String getBsnsLcnsNo() {
		return BsnsLcnsNo;
	}
	public void setBsnsLcnsNo(String bsnsLcnsNo) {
		BsnsLcnsNo = bsnsLcnsNo;
	}
	public String getClientName() {
		return ClientName;
	}
	public void setClientName(String clientName) {
		ClientName = clientName;
	}
	public String getQueryList() {
		return QueryList;
	}
	public void setQueryList(String queryList) {
		QueryList = queryList;
	}
	

}
