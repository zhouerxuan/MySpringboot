package com.gf;

import com.gf.proxy.DynamicProxy;
import com.gf.service.TestInterface;
import com.gf.service.impl.TestInterfaceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DynamicProxyTest {
    @Test
    public void dynamicProxyTest() {
        DynamicProxy dynamicProxy = new DynamicProxy(new TestInterfaceImpl());
        TestInterface testInterface = (TestInterface) dynamicProxy.getProxy();
        testInterface.test();
    }
}
