package com.zyc.demo.respPojo;


public class SFOrderRespPojo extends BaseNormalRespPojo {
	/**
	 * @Fields serialVersionUID : TODO
	 */
	
	private static final long serialVersionUID = 1L;
	private String orgno;// 组织机构代码
	private String orgname;// 机构名称
	private String legal;// 法定代表人
	private String legalIdCardType;// 法人证件类型
	private String legalidcardno;// 法人身份证号
	
	//20170803添加两个字段营业执照及社会统一信用码
	private String creditCode;//社会统一信用码
	
	private String businessLicense;//营业执照
	
	

	public String getCreditCode() {
		return creditCode;
	}

	public void setCreditCode(String creditCode) {
		this.creditCode = creditCode;
	}

	public String getBusinessLicense() {
		return businessLicense;
	}

	public void setBusinessLicense(String businessLicense) {
		this.businessLicense = businessLicense;
	}

	public String getOrgno() {
		return orgno;
	}

	public void setOrgno(String orgno) {
		this.orgno = orgno;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public String getLegal() {
		return legal;
	}

	public void setLegal(String legal) {
		this.legal = legal;
	}

	public String getLegalIdCardType() {
		return legalIdCardType;
	}

	public void setLegalIdCardType(String legalIdCardType) {
		this.legalIdCardType = legalIdCardType;
	}

	public String getLegalidcardno() {
		return legalidcardno;
	}

	public void setLegalidcardno(String legalidcardno) {
		this.legalidcardno = legalidcardno;
	}

	@Override
	public String toString() {
		return "SFOrderRespPojo [orgno=" + orgno + ", orgname=" + orgname + ", legal=" + legal + ", legalIdCardType="
				+ legalIdCardType + ", legalidcardno=" + legalidcardno + ", creditCode=" + creditCode
				+ ", businessLicense=" + businessLicense + "]";
	}

	

}
