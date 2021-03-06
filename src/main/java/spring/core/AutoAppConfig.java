package spring.core;    // basePackages 가 없을 시 해당 패키지 하위를 모두 탐색 한다.

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import spring.core.member.MemberRepository;
import spring.core.member.MemoryMemberRepository;

@Configuration
@ComponentScan(
//        basePackages = "spring.core.member",    //member만 @componentScan 대상이 됨
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)  //AppConfig.class 를 제외한다.
)
public class AutoAppConfig {

    // 빈 중복 등록과 충돌을 위한 소스
//    @Bean(name = "memoryMemberRepository")
//    MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }
}
