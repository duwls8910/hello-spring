package hello.hellospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//이 어노테이션으로부터 시작하여 1번의 패키지안에  하위들은 자동으로 스프링 다뒤져서 스프링 빈으로 등록함
public class  HelloSpringApplication {

	public static void main(String[] args) { //자바는 메인메서드로부터 모든것을 시작한다

		SpringApplication.run(HelloSpringApplication.class, args);
		System.out.println("Hello World!");
	}

}
//스프링부트는 tomcat이라는 웹서버를 내장하고있다.
//gradle 같은 라이브러리는 의존관계를 관리해준다.
//어떻게 로그를 볼건지 (logback(어떤 구현체로   출력할지)+slf4(인터페이스))