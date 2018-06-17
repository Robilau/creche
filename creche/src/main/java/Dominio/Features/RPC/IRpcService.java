/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio.Features.RPC;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author T0KS1CK
 */
public interface IRpcService {
    Rpc adicionar(Rpc rpc) throws SQLException, Exception;

    Rpc atualizar(Rpc rpc) throws SQLException, Exception;

    Rpc pegar(Rpc rpc) throws SQLException, Exception;

    List<Rpc> pegarTodas() throws SQLException;

    boolean deletar(Rpc rpc)  throws SQLException, Exception;
}
