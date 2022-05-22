package spring.core.order;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring.core.discount.DiscountPolicy;
import spring.core.discount.FixDiscountPolicy;
import spring.core.discount.RateDiscountPolicy;
import spring.core.member.Member;
import spring.core.member.MemberRepository;
import spring.core.member.MemoryMemberRepository;

@Component
@RequiredArgsConstructor    // final 이 붙은 것들을 파라미터로 받는 생성자를 자동으로 만들어 준다.
public class OrderServiceImpl implements OrderService{

//    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;
    // 수정자 주입 (setter 주입)
//    private  MemberRepository memberRepository;

    // 필드 주입 @Autowired => 스프링에서 추천하지 않는다. 차라리 setter에 @Autowired 를 붙여서 사용하는 편이 낫다.
    // 애플리케이션의 실제 코드와 관계없는 테스트 코드에서는 사용 해도 됨 / @Configuration 에서는 사용
//    @Autowired private MemberRepository memberRepository;
//
//    @Autowired(required = false)    //선택적으로 주입 required = false
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }

    // 할인정책 변경 될 때 코드를 수정해야 함
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    private final DiscountPolicy discountPolicy;


// @ReqiuredArgsConstructor
//    @Autowired  // 생성자가 1개만 있다면 @Autowired 를 생략 가능
//    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
