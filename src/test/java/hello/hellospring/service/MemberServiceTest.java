package hello.hellospring.service;

import hello.hellospring.damain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }


    @AfterEach
    //중요 테스트를 진행 할때는 앞의테스트들과의 의존관계가 없어야 한다 그래서 꼭 테스트후 지워준다
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void join() {
        //given 무언가가 주어졌을때
        Member member = new Member();
        member.setName("spring1");

        //when 뭔가를 실행하면
        Long saveId = memberService.join(member);

        //then 결과는 이렇게 나와야 한다
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }
    @Test
    public void 중복_회원_예외() {
        //given 무언가가 주어졌을때
        Member member1 = new Member();
        member1.setName("spring1");

        Member member2 = new Member();
        member2.setName("spring1");
        //when 뭔가를 실행하면
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        //then 결과는 이렇게 나와야 한다
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");
    }
    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}