package gn.traore.demo1cicdgaglo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class Demo1CicdGagloApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void assertThatOnePlusOneIsTwo() {
		int somme = 1 + 1;
		assertThat(somme).isNotNull();
		assertThat(somme).isEqualTo(2);
	}

	@Test
	void assertThatOnePlusTwoIsThree() {
		int somme = 1 + 2;
		assertThat(somme).isNotNull();
		assertThat(somme).isEqualTo(2);
	}

}
