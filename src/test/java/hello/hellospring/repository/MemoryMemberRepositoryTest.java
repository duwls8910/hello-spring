package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    //중요 테스트를 진행 할때는 앞의테스트들과의 의존관계가 없어야 한다 그래서 꼭 테스트후 지워준다
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring"); //이름을 세팅해주는 부분

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        //j unit 방식 Assertions.assertEquals(member, result);
        assertThat(member).isEqualTo(result);
        //멤버객체가 리저트와 같나?
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1); //저장소에 이름저장

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        //spring1,2라는 회원이 가입이 된(레포지토리 저장)상태

        Member result = repository.findByName("spring1").get();//get()을 쓰면 optional되있는거 까서 쓸수있음
        //리저트에 저장소에서 검색한 내용중 spring1이 있는지 조회한값을 담음 불리언?
        assertThat(member1).isEqualTo(result);
        //리저트 값이 멤버1에 저장된값과 같은지 확인
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1); //저장소에 이름저장

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}
