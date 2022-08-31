package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

//@Service
@Transactional //JPA를 쓸때 서비스 계층에 있어야 함
public class MemberService {

    private final MemberRepository memberRepository;

    //@Autowired
    //의존성주입 알아서 해줌
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    /**
     * 회원가입
     */
    public Long join(Member member) {
        //같은이름이 있는 회원 거절
        validateDuplicateMember(member);//메서드 사용하여 코드정리
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) { //중복회원 검증로직의 메서드화
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다");
                });
    }
/**전체 회원 조 **/
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
