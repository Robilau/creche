/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio.Features.Crianca;

import Dominio.Base.Entidade;
import Dominio.Base.Pessoa;
import Dominio.Fatures.Relatorio.Relatorio;
import Dominio.Features.RPC.Rpc;
import Dominio.Features.Turma.Turma;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;

/**
 * A classe crianca possibilita instanciar crianças e extende sua funcionalidade
 * a partir das super-classses <b>Pessoa</b> <b>Entidade</b>. Possui atributos,
 * e métodos diversos para acessar esses atributos sempre utilizando-se dos
 * principios de POO como por exemplo encapsulamento.
 *
 * @author Gabriel Celestino, Leticia Ventura, Lucas Chaves
 * @version 1.0
 * @since Vr 1.0
 * @see Pessoa
 * @see Rpc
 * @see Entidade
 */
public class Crianca extends Pessoa {

    private Date dataNascimento;
    private Rpc responsavelPelaCrianca;
    private Turma turma;
    private List<Relatorio> relatorios;

    public Crianca() {
    }

    public List<Relatorio> getRelatorios() {
        return relatorios;
    }

    public void setRelatorios(List<Relatorio> relatorios) {
        this.relatorios = relatorios;
    }    

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Rpc getResponsavelPelaCrianca() {
        return responsavelPelaCrianca;
    }

    public void setResponsavelPelaCrianca(Rpc responsavelPelaCrianca) {
        this.responsavelPelaCrianca = responsavelPelaCrianca;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    @Override
    public void validar() throws Exception {
        super.validar();
        if (responsavelPelaCrianca == null) {
            throw new Exception("Responsável pela crianca não pode ser nulo");
        }
        if (turma == null) {
            throw new Exception("a turma não pode estar nula");
        }
        if (dataNascimento == null) {
            throw new Exception("a data de nascimento não pode estar vazia");
        }
    }

    @Override
    public String toString() {
        return String.format("Nome: %-20sDataNascimento: %-20sTurma: %-20sRPC: %s", this.getNome(), DateFormat.getDateInstance(3).format(dataNascimento), turma.getNome(), responsavelPelaCrianca.getNome());
    }

}
