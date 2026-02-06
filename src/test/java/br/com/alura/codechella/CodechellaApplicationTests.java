package br.com.alura.codechella;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.alura.codechella.domain.entity.user.User;

@SpringBootTest
class CodechellaApplicationTests {

	@Test
	void deveRetornarUmErroAoTentarCriarAInstanciaDeUsuario(){

		assertThrows(IllegalArgumentException.class,
			() -> {
				new User("123.456.789-99", "guilherme", LocalDate.of(2026, 02, 28), "gui@mgmail.com");
			}
		);

		assertThrows(IllegalArgumentException.class,
			() -> {
				new User("", "guilherme", LocalDate.of(2026, 02, 28), "gui@mgmail.com");
			}
		);

		assertThrows(IllegalArgumentException.class,
			() -> {
				new User(null, "guilherme", LocalDate.of(2026, 02, 28), "gui@mgmail.com");
			}
		);

		assertThrows(IllegalArgumentException.class,
			() -> {
				new User("111.111.111-11", "guilherme", LocalDate.of(2026, 02, 28), "gui@mgmail.com");
			}
		);

		assertThrows(IllegalArgumentException.class,
			() -> {
				new User("467.906.058-19", "guilherme", LocalDate.of(2023, 02, 28), "gui@mgmail.com");
			}
		);

	}

}
