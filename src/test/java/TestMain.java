import com.config.RootConfig;
import com.zyc.demo.interfaces.Impl.SFOrderServiceImpl;
import com.zyc.demo.reqPojo.SFOrderReqPojo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class TestMain {


    @Test
    public void TestReqXML(){
        //AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(RootConfig.class);
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:context/applicationContext.xml");
        SFOrderServiceImpl bean = (SFOrderServiceImpl)applicationContext.getBean("SFOrderServiceImpl");
        SFOrderReqPojo sfOrderReqPojo = new SFOrderReqPojo();
        sfOrderReqPojo.setOrderid("QIAO-20180524001");
        sfOrderReqPojo.setExpress_type("2");
        sfOrderReqPojo.setJ_province("广东省");
        sfOrderReqPojo.setJ_city("深圳市");
        sfOrderReqPojo.setJ_company("顺丰镖局");
        sfOrderReqPojo.setJ_contact("张哥");
        sfOrderReqPojo.setJ_tel("15012345678");
        sfOrderReqPojo.setJ_address("福田区新洲十一街万基商务大厦26楼");
        sfOrderReqPojo.setD_province("广东省");
        sfOrderReqPojo.setD_city("广州市");
        sfOrderReqPojo.setD_county("");
        sfOrderReqPojo.setD_company("神罗科技");
        sfOrderReqPojo.setD_contact("风一样的超哥");
        sfOrderReqPojo.setD_tel("15611677703");
        sfOrderReqPojo.setD_address("海珠区宝芝林大厦701室");
        sfOrderReqPojo.setParcel_quantity("1");
        sfOrderReqPojo.setPay_method("3");
        sfOrderReqPojo.setCustid("7551234567");
        //sfOrderReqPojo.setCustoms_batchs("");
        sfOrderReqPojo.setName("COD");
        sfOrderReqPojo.setValue("1.01");
        try {
            bean.applyOrder(sfOrderReqPojo);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}