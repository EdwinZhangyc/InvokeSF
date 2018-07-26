package com.zyc.demo.interfaces;

import com.zyc.demo.reqPojo.SFOrderReqPojo;
import com.zyc.demo.respPojo.SFOrderRespPojo;

public interface ISFApplyOrderService {
      public SFOrderRespPojo applyOrder(SFOrderReqPojo reqPojo) throws Exception;
}
