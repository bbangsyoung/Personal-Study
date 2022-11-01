package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class MemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();


    //하나끝날떄마다 클리어
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }


    @DisplayName("테스트네임뜨는지보기")
    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        //System.out.println("(result == member) = " + (result == member));
        //Assertions.assertEquals(member,result);
        //Assertions.assertThat(member).isEqualTo(result);
        assertThat(member).isEqualTo(result);
        //위처럼 짧게 쓰는것이 목표!
    }

    @DisplayName("findByName임다")
    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);
        
        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);
        
        Member result = repository.findByName("spring2").get();
        assertThat(result).isEqualTo(member2);


    }


    @DisplayName("findByAll입니당")
    @Test
    public void findByAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);


    }



}
