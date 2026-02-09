package br.com.alura.codechella.domain.entity.user;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class UserTest {

  @Test
	void deveRetornarErroQuandoOCPFNaoCumprirComAsRegrasDeNegocio(){
    IllegalArgumentException exception = null;

    exception = assertThrows(IllegalArgumentException.class,
      () -> new User("111.111.111-11", "guilherme", LocalDate.of(1999, 2, 28), "gui@gmail.com")
    );

    assertEquals("CPF inválido", exception.getMessage());

    exception = assertThrows(IllegalArgumentException.class,
      () -> new User("36837353098", "guilherme", LocalDate.of(1999, 2, 28), "gui@gmail.com")
    );

    assertEquals("Formato de CPF inválido", exception.getMessage());

    exception = assertThrows(IllegalArgumentException.class,
      () -> new User("", "guilherme", LocalDate.of(1999, 2, 28), "gui@gmail.com")
    );

    exception = assertThrows(IllegalArgumentException.class,
      () -> new User(null, "guilherme", LocalDate.of(1999, 2, 28), "gui@gmail.com")
    );

	}

}
