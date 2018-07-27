package com.zyc.demo.commons;

import com.sf.csim.express.service.CallExpressServiceTools;

/**
 * 调用丰桥接口工具类
 */
public class InvokeSFTool {

    /**
     * 调用入口
     * @param reqURL 请求地址
     * @param urlXML 请求报文文件路径
     * @param clientCode 丰桥平台获取的顾客编码
     * @param checkword 丰桥平台获取的校验码
     * @return
     */
    @SuppressWarnings("static-access")
    public static String invokeSF (String reqURL, String urlXML, String clientCode, String checkword){
        //String reqXml = "";
        //try{
        //    @SuppressWarnings("resource")
        //    InputStream is = new FileInputStream(urlXML);//下订单
        //    byte[] bs = new byte[is.available()];
        //    is.read(bs);
        //    reqXml = new String(bs);
        //}catch(Exception e){
        //    e.printStackTrace();
        //}
        CallExpressServiceTools client=CallExpressServiceTools.getInstance();
        String myReqXML=urlXML.replace("SLKJ2019",clientCode);
        System.out.println("请求报文：\n"+myReqXML);
        System.out.println("加密报文：\n"+checkword);
        String respXml= client.callSfExpressServiceByCSIM(reqURL, myReqXML, clientCode, checkword);
        return respXml;
    }
}