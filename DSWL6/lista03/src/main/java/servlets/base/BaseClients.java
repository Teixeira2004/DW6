package servlets.base;

import java.util.ArrayList;
import java.util.List;
import models.Cliente;

public class BaseClients {
	
    private static BaseClients instanciaUnica = null;
    
    private List<Cliente> clientes;

    private BaseClients() {
        clientes = new ArrayList<Cliente>();
    }

    public static BaseClients getInstance() {
        if (instanciaUnica == null) {
            instanciaUnica = new BaseClients();
        }
        return instanciaUnica;
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public List<Cliente> listarClientes() {
        return clientes;
    }
}
