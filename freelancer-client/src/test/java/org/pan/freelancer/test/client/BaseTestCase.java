package org.pan.freelancer.test.client;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Nikola Zivkov
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "/freelancer-spring.xml",
        "/freelancer4j-spring-service.xml",
        "/elance4j-spring-service.xml",
        "/oDesk4j-spring-service.xml",
        "/linkedin4j-spring-service.xml"
    })
public class BaseTestCase extends AbstractJUnit4SpringContextTests {

}
