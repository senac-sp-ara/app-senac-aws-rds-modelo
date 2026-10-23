package br.com.sp.awsmodelo.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.com.sp.awsmodelo.dto.PessoaDTO;
import br.com.sp.awsmodelo.entity.PessoaEntity;

@Mapper(componentModel = "spring")
public interface PessoaMapper {

    PessoaDTO toDto(PessoaEntity entity);

    List<PessoaDTO> toDtoList(List<PessoaEntity> entities);
}
