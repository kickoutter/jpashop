package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * 회원 기능 테스트 요구사항
 * - 회원가입을 성공해야 한다.
 * - 회원가입 할 때, 같은 이름이 있으면 예외가 발생해야 한다.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    public void 회원가입() throws Exception {
        //given
        Member member = new Member();
        member.setName("kim");

        //when
        Long saveId = memberService.join(member);

        //then
        assertEquals(member, memberRepository.findOne(saveId));
    }

//    @Test
    @Test(expected = IllegalStateException.class)
    public void 중복_회원_예외() throws Exception {
        //given
        Member member1 = new Member();
        member1.setName("kim");

        Member member2 = new Member();
        member2.setName("kim");

        //when

//        memberService.join(member1);
//        try {
//            memberService.join(member2); // 여기서 예외가 발생해야 한다.
//        } catch (IllegalStateException e) {
//            return;
//        }

        /**
         * @Test(expected = IllegalStateException.class) 적용 후
         * 코드가 간결해짐
         */
        memberService.join(member1);
        memberService.join(member2); // 여기서 예외가 발생해야 한다.

        //then
        fail("예외가 발생해야 한다.");
    }
}
