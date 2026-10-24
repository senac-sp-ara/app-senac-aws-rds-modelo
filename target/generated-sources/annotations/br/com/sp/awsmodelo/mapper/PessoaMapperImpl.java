package br.com.sp.awsmodelo.mapper;

import br.com.sp.awsmodelo.dto.PessoaDTO;
import br.com.sp.awsmodelo.entity.PessoaEntity;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-10-23T21:14:23-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.6 (Amazon.com Inc.)"
)
@Component
public class PessoaMapperImpl implements PessoaMapper {

    @Override
    public PessoaDTO toDto(PessoaEntity entity) {
        if ( entity == null ) {
            return null;
        }

        String nome = null;
        LocalDate dataNascimento = null;

        nome = entity.getNome();
        dataNascimento = entity.getDataNascimento();

        PessoaDTO pessoaDTO = new PessoaDTO( nome, dataNascimento );

        return pessoaDTO;
    }

    @Override
    public List<PessoaDTO> toDtoList(List<PessoaEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<PessoaDTO> list = new ArrayList<PessoaDTO>( entities.size() );
        for ( PessoaEntity pessoaEntity : entities ) {
            list.add( toDto( pessoaEntity ) );
        }

        return list;
    }
}
