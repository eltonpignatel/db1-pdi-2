package br.com.eltonpignatel.app.exceptions;

import javassist.NotFoundException;

public class UsuarioNotFound extends NotFoundException {

    public UsuarioNotFound(Long id ) { super("Usuário com id "+ id + " não encontrado");}

}
