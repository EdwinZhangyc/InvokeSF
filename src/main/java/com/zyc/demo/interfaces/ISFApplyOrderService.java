package com.zyc.demo.interfaces;


import java.com.demo.reqPojo.SFOrderReqPojo;
import java.com.demo.respPojo.SFOrderRespPojo;

public interface ISFApplyOrderService {
      public SFOrderRespPojo applyOrder(SFOrderReqPojo reqPojo) throws Exception;
}
