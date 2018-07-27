package com.zyc.demo.reqPojo;

import java.io.Serializable;

public class SFReqPojo implements Serializable {

    private String xml;

    private String verifyCode;

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public String getXml() {

        return xml;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }
}