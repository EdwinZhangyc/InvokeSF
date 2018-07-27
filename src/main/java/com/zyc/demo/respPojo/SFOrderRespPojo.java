package com.zyc.demo.respPojo;

/**
 * 丰桥响应POJO
 */
public class SFOrderRespPojo extends BaseNormalRespPojo {

	private String orderid;//客户订单号
	private String mailno;//顺丰运单号，一个订单只能有一个母单号，如果是子母单的情况，以半角逗号分隔，主单号在第一个位置，如“755123456789,001123456789,002123456789” ，可用于顺丰电子运单标签打印。
	private String return_tracking_no;//顺丰签回单服务运单号
	private String origincode;//原寄地区域代码，可用于顺丰电子运单标签打印。
	private String destcode;//目的地区域代码，可用于顺丰电子运单标签打印。
	private String filter_result;//筛单结果：1：人工确认2：可收派3：不可以收派
	private String remark;//如果filter_result=3时为必填，不可以收派的原因代码：1：收方超范围2：派方超范围3-：其它原因
	private String agentMailno;//代理单号
	private String mapping_mark;//地址映射码

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getMailno() {
		return mailno;
	}

	public void setMailno(String mailno) {
		this.mailno = mailno;
	}

	public String getReturn_tracking_no() {
		return return_tracking_no;
	}

	public void setReturn_tracking_no(String return_tracking_no) {
		this.return_tracking_no = return_tracking_no;
	}

	public String getOrigincode() {
		return origincode;
	}

	public void setOrigincode(String origincode) {
		this.origincode = origincode;
	}

	public String getDestcode() {
		return destcode;
	}

	public void setDestcode(String destcode) {
		this.destcode = destcode;
	}

	public String getFilter_result() {
		return filter_result;
	}

	public void setFilter_result(String filter_result) {
		this.filter_result = filter_result;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getAgentMailno() {
		return agentMailno;
	}

	public void setAgentMailno(String agentMailno) {
		this.agentMailno = agentMailno;
	}

	public String getMapping_mark() {
		return mapping_mark;
	}

	public void setMapping_mark(String mapping_mark) {
		this.mapping_mark = mapping_mark;
	}

	@Override
	public String toString() {
		return  super.toString() + ",\n" +
				"SFOrderRespPojo{" +
				"orderid='" + orderid + '\'' +
				", mailno='" + mailno + '\'' +
				", return_tracking_no='" + return_tracking_no + '\'' +
				", origincode='" + origincode + '\'' +
				", destcode='" + destcode + '\'' +
				", filter_result='" + filter_result + '\'' +
				", remark='" + remark + '\'' +
				", agentMailno='" + agentMailno + '\'' +
				", mapping_mark='" + mapping_mark + '\'' +
				'}';
	}
}
