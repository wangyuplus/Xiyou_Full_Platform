package com.fznsys.xiyou_full_platform;

import com.fznsys.xiyou_full_platform.mapper.UserMapper;
import com.fznsys.xiyou_full_platform.service.UserService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore
public class XiyouFullPlatformApplicationTests {
    @Autowired
    UserService userService;
    @Autowired
    UserMapper mapper;
    @Test
    public void contextLoads() {
//        System.out.println(mapper.LoginByUsernameAndPassword("test","a123456")==null);
//        lifePaymentMapper.addPayment(UUID.randomUUID().toString(),"11","0",
//                "12.12",DateFormat.getDateTimeInstance().format(new Date()),"0","");
//        ArrayList<LifePayment> list=lifePaymentMapper.getLifePaymentByuserid("11");
//        for (LifePayment l:
//             list) {
//            System.out.println(l.getNum());
//        }
//        lifePaymentMapper.DeleteByID("d683ee67-09a5-4784-95b3-dabbcc85a6e9");
    }

}
