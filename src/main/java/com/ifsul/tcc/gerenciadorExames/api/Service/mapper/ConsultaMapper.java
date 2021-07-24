package com.ifsul.tcc.gerenciadorExames.api.Service.mapper;

import com.ifsul.tcc.gerenciadorExames.api.Controller.Request.NewDadosConsultaRequest;
import com.ifsul.tcc.gerenciadorExames.api.Entity.Consulta;
import com.ifsul.tcc.gerenciadorExames.api.Entity.Instituicao;
import com.ifsul.tcc.gerenciadorExames.api.Entity.Usuario;

public class ConsultaMapper {
    private ConsultaMapper() {throw new IllegalStateException("Utility class");}

    public static Consulta createEntity(NewDadosConsultaRequest dados, Instituicao instituicao, Usuario usuario) {
        Consulta consulta = new Consulta();
        consulta.setDiagnostico(dados.getDiagnostico());
        consulta.setPrescricao(dados.getPrescricao());
        consulta.setNomeMedico(dados.getNomeMedico());
        consulta.setIdArquivo(dados.getIdArquivo());
        consulta.setDataConsulta(dados.getDataConsulta());
        consulta.setInstituicao( instituicao );
        consulta.setUsuario( usuario );
        return consulta;
    }
}
