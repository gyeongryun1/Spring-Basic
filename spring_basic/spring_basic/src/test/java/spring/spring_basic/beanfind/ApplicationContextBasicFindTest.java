package spring.spring_basic.beanfind;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.spring_basic.AppConfig;
import spring.spring_basic.member.Service;
import spring.spring_basic.member.ServiceImpl;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회하기")
    public void findBeanByName() {
        Service service = ac.getBean("service", Service.class);
        assertThat(service).isInstanceOf(ServiceImpl.class);
    }

    @Test
    @DisplayName("이름 없이 타입으로 조회")
    public void findBeanByType() {
        Service service = ac.getBean(Service.class);
        assertThat(service).isInstanceOf(ServiceImpl.class);
    }

    @Test
    @DisplayName("구체 타입으로 조회") void findBeanByName2() {
        ServiceImpl service = ac.getBean("service", ServiceImpl.class);
        assertThat(service).isInstanceOf(ServiceImpl.class); }

    @Test
    @DisplayName("빈 이름으로 조회X") void findBeanByNameX() {
//    ac.getBean("xxxxx", Service.class);
    assertThrows(NoSuchBeanDefinitionException.class, () -> ac.getBean("xxxxx", Service.class));
    }
}
