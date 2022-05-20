package spring.core.autowired;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;
import spring.core.member.Member;

import java.util.Optional;

public class AutoWiredTest {

    @Test
    void AutoWiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

    }

    static class TestBean {

        // required = false : 값이 없으면 호출 자체가 안됨
        @Autowired(required = false)
        public void setNoBean1(Member noBean1) {
            System.out.println("noBean1 = " + noBean1);
        }

        // @Nullable : 호출 되고 값이 없을 시 null 호출
        @Autowired
        public void setNoBean2(@Nullable Member noBean2) {
            System.out.println("noBean2 = " + noBean2);
        }

        // Optional : 값이 없으면 Optional.empty 가 호출
        @Autowired
        public void setNoBean2(Optional<Member> noBean3) {
            System.out.println("noBean3 = " + noBean3);
        }
    }

}
