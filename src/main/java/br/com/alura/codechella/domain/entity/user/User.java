package br.com.alura.codechella.domain.entity.user;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/*
Toda regra de negócio deve ficar na parte de dominio da sua aplicação.
no nosso caso esse classe refere ao nosso usuário em nosso sistema, ela representa a nossa entidade.
Uma entidade é um objeto da nossa aplicação que tem um identificador único. Nesse caso será o CPF.
*/

public class User {

  private String cpf;
  private String nome;
  private LocalDate nascimento;
  private String email;
  
  public User(String cpf, String nome, LocalDate nascimento, String email) {

    if(cpf == null || cpf.isBlank() || cpf.matches("^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$")){
      throw new  IllegalArgumentException();
    }

    if(!verificarCpf(cpf)){
      throw new  IllegalArgumentException();
    }

    if(nome == null || nome.isBlank()){
      throw new  IllegalArgumentException();
    }

    if(nascimento == null) {
      throw new  IllegalArgumentException();
    }

    if (email == null || email.isBlank()) {
      throw new  IllegalArgumentException();
    }

    if(!verificarIdade(nascimento)){
      throw new  IllegalArgumentException();
    }

    this.cpf = cpf;
    this.nome = nome;
    this.nascimento = nascimento;
    this.email = email;

  }

  public Boolean verificarCpf(String cpf){

    // 1. Limpa a string removendo tudo que não for dígito
    String cpfLimpo = cpf.replaceAll("[^0-9]", "");

    // 2. Verifica se tem 11 dígitos ou se é uma sequência repetida conhecida
    if (cpfLimpo.length() != 11 || cpfLimpo.matches("(\\d)\\1{10}")) {
        return false;
    }

    try {
        // Converter a String limpa em um array de inteiros para facilitar o cálculo
        int[] num = new int[11];
        for (int i = 0; i < 11; i++) {
            num[i] = Character.getNumericValue(cpfLimpo.charAt(i));
        }

        // --- CÁLCULO DO 1º DÍGITO VERIFICADOR ---
        int soma1 = 0;
        int peso1 = 10;
        for (int i = 0; i < 9; i++) {
            soma1 += num[i] * peso1--;
        }
        int resto1 = (soma1 * 10) % 11;
        if (resto1 == 10) resto1 = 0;

        // --- CÁLCULO DO 2º DÍGITO VERIFICADOR ---
        int soma2 = 0;
        int peso2 = 11;
        for (int i = 0; i < 10; i++) {
            soma2 += num[i] * peso2--;
        }
        int resto2 = (soma2 * 10) % 11;
        if (resto2 == 10) resto2 = 0;

        // 3. Verifica se os restos calculados batem com os dígitos informados
        return (resto1 == num[9] && resto2 == num[10]);

    } catch (Exception e) {
        return false;
    }
  }

  public Boolean verificarIdade(LocalDate localDate){
    LocalDate hoje = LocalDate.now();

    long idade = ChronoUnit.YEARS.between(localDate, hoje);

    if (idade >= 18) {
      return true;
    } else {
      return false;
    }
  }

  public String getCpf() {
    return cpf;
  }
  public void setCpf(String cpf) {
    this.cpf = cpf;
  }
  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }
  public LocalDate getNascimento() {
    return nascimento;
  }
  public void setNascimento(LocalDate nascimento) {
    this.nascimento = nascimento;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }

  


}
