package com.ifsul.tcc.gerenciadorExames.api.Repository;

import com.ifsul.tcc.gerenciadorExames.api.Controller.Response.DadosConsultaResponse;
import com.ifsul.tcc.gerenciadorExames.api.DTO.ConsultaDTO;
import com.ifsul.tcc.gerenciadorExames.api.Entity.Consulta;
import com.ifsul.tcc.gerenciadorExames.api.Entity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ConsultaRepository extends CrudRepository<Consulta,Integer> {
    List<ConsultaDTO> findAllByUsuarioOrderByDataConsultaDesc(Usuario usuario);
    Optional<Consulta> findById(Integer id);
    DadosConsultaResponse findByIdAndUsuario(Integer id, Usuario usuario);
}
