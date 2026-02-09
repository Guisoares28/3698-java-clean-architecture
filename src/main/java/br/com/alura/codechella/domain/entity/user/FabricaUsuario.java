package br.com.alura.codechella.domain.entity.user;

import java.time.LocalDate;

import br.com.alura.codechella.domain.Endereco;

public class FabricaUsuario {

  private Usuario usuario;

  public Usuario build(String cpf, String nome, LocalDate nascimento, String email){
    this.usuario = new Usuario(cpf, nome, nascimento, email);
    return this.usuario;
  }

  public Usuario setEndereco(String cep, Integer numero, String complemento){
    this.usuario.setEndereco(new Endereco(cep, numero, complemento));
    return this.usuario;
  }



}
