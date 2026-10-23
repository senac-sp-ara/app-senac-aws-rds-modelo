package br.com.sp.awsmodelo.dto;

import java.time.LocalDate;

public record PessoaDTO(String nome, LocalDate dataNascimento) {
}
