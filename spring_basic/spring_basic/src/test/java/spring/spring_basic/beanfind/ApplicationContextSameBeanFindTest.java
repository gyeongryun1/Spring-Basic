package spring.spring_basic.beanfind;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.spring_basic.AppConfig;
import spring.spring_basic.member.MemoryRepository;
import spring.spring_basic.member.Repository;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextSameBeanFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면 오류 발생")
    void findBeanByTypeDuplicate() {
//        Object bean = ac.getBean(Repository.class);
        assertThrows(NoUniqueBeanDefinitionException.class, () -> ac.getBean(Repository.class));
    }
    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 빈 이름을 지정하면 된다")
    void findBeanByName() {
        Repository memberRepository = ac.getBean("memberRepository1", Repository.class);
        assertThat(memberRepository).isInstanceOf(Repository.class); }

    /**
     *
     */
    @Test
    @DisplayName("특정 타입을 모두 조회하기") void findAllBeanByType() {
        Map<String, Repository> beansOfType = ac.getBeansOfType(Repository.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " value = " + beansOfType.get(key));
        }
        System.out.println("beansOfType = " + beansOfType);
        assertThat(beansOfType.size()).isEqualTo(2);
    }
    @Configuration
    static class SameBeanConfig {
        @Bean
        public Repository memberRepository1() {
            return new MemoryRepository(); }
        @Bean
        public Repository memberRepository2() {
            return new MemoryRepository(); }
    }
}
