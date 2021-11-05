package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Servidor {

    private Socket socketAsociado;
    private Cliente cliente;
    private List<String> solicitudesClientes = new ArrayList<>();
    private String mensajeEnviado;
    private String mensajeRecibido;
    private Boolean conexionLiberadaServidor;

    public void socket(int nroPuerto){

        this.socketAsociado = new Socket(1, nroPuerto, false, true);
        System.out.println();
        System.out.println("Primitiva SOCKET (Servidor): se creó un nuevo punto terminal de comunicación en el servidor");
        System.out.println("   - ID Socket: " + socketAsociado.getIdSocket());
        System.out.println("   - Número de Puerto: " + socketAsociado.getNroPuerto());
        cliente.socket(nroPuerto);

    }

    public void bind(String direcIP){

        this.socketAsociado.setDirecIP(direcIP);
        System.out.println();
        System.out.println("Primitiva BIND: Se asoció una dirección local con el socket");
        System.out.println("   - Dirección IP: " + socketAsociado.getDirecIP());

    }

    public void listen(String solicitudCliente){

        solicitudesClientes.add(solicitudCliente);
        System.out.println();
        System.out.println("Primitiva LISTEN: Se anunció la disposición de aceptar conexiones");
        System.out.println("   - Tamaño de la cola: " + solicitudesClientes.size());

    }

    public void accept (){

        for(int i=0; i<solicitudesClientes.size(); i++){

            Socket socketAccept = new Socket(3+i, socketAsociado.getNroPuerto(), socketAsociado.getEsCliente(), socketAsociado.getEsServidor());
            System.out.println();
            System.out.println("Primitiva ACCEPT: Se estableció en forma pasiva la conexión entrante");
            System.out.println("   - ID Socket: " + socketAccept.getIdSocket());
            System.out.println("   - Número de Puerto: " + socketAccept.getNroPuerto());
            cliente.connect(socketAccept);

        }

    }

    public void send(String mensaje){

        this.mensajeEnviado = mensaje;
        System.out.println();
        System.out.println("Primitiva SEND (Servidor): Se enviaron datos a través de la conexión");
        System.out.println("   - Mensaje servidor: '" + this.mensajeEnviado + "' ENVIADO");
        cliente.receive(this.mensajeEnviado);

    }

    public void receive(String mensaje){

        this.mensajeRecibido = mensaje;
        System.out.println();
        System.out.println("Primitiva RECEIVE (Servidor): Se recibieron los datos de la conexión");
        System.out.println("   - Mensaje cliente: '" + this.mensajeRecibido + "' RECIBIDO");

    }

    public void close(){

        this.conexionLiberadaServidor = true;

    }

    public void closeConnection(){

        if(this.conexionLiberadaServidor && cliente.getConexionLiberadaCliente()){

            System.out.println();
            System.out.println("Primitiva CLOSE: Se liberó la conexión");

        }else {

            System.out.println("Aun no se liberó la conexión - El cliente y/o servidor aún están recibiendo datos");

        }

    }

}
