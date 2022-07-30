package hello.hellospring.repository;

import hello.hellospring.damain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
//회원을 저장하면 저장된 회원을 바로 반환하는 기능
    Optional<Member> findById(Long id);
//자바8에들어가는 기능으로 null을 처리할때(파인드 아이디나 네임에 널값이 들어갈수 있다)
//널이 발생 할 가능성이 있으먄 널그대로 반환하는게 아니라 옵셔널로 감싸서 반환하는 방법을 많이 선호함
    Optional<Member> findByName(String name);

    List<Member> findAll();
    //지금까지 저장된 모든 회원 리스트반환
}
