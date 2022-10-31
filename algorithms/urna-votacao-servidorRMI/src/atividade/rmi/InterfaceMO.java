/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade.rmi;

import java.rmi.RemoteException;
import java.rmi.Remote;

/**
 *
 * @author nelsontoneze
 */
public interface InterfaceMO extends Remote {
    void contarVotos() throws RemoteException;
    boolean cadastrarVotos(String nome, int votos) throws RemoteException;
}
