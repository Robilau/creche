package Aplicacao;

import Dominio.Features.Usuario.TipoUsuario;
import Dominio.Features.Usuario.Usuario;
import Infraestrutura.Login.IConfiguracoesLogin;
import Infraestrutura.Login.ILoginService;

/**
 *
 * @author T0KS1CK
 */
public class LoginService implements ILoginService{

    IConfiguracoesLogin config;

    public LoginService(IConfiguracoesLogin config) {
        this.config = config;
    }

    @Override
    public Usuario verificarUsuario(String login, String senha) throws Exception{
        Usuario user = null;
        {
            if (config.VerificarLoginGerente(login, senha)) {
                user = new Usuario();
                user.setLogin(login);
                user.setTipoUsuario(TipoUsuario.GERENTE);
            } else if (config.VerificarLoginCuidador(login, senha)) {
                user = new Usuario();
                user.setLogin(login);
                user.setTipoUsuario(TipoUsuario.CUIDADOR);
            }
            if (user == null) throw new Exception("Usuário ou senha não conferem");
            return user;
        }
    }

    @Override
    public boolean modificarSenha(Usuario user, String senha, String novaSenha) throws Exception {
        user = verificarUsuario(user.getLogin(), senha);
        if (user.getTipoUsuario() == TipoUsuario.GERENTE)  return config.modificarSenhaGerente(user.getLogin(), senha, novaSenha);
        else if (user.getTipoUsuario() == TipoUsuario.CUIDADOR) return config.modificarSenhaCuidador(user.getLogin(), senha, novaSenha);
       return false;
    }
}
