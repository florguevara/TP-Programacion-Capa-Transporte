package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    private Servidor servidor;
    private Socket socketAsociado;
    private String mensajeEnviado;
    private String mensajeRecibido;
    private Boolean conexionLiberadaCliente;

    public void socket(int nroPuerto){

        this.socketAsociado = new Socket(2, nroPuerto, true, false);

    }

    public void connect(Socket socketAccept){

        socketAccept.setConectado(true);
        System.out.println();
        System.out.println("Primitiva CONNECT: Se estableció en forma activa la conexión");
        System.out.println("   - Conexión: " + socketAccept.getConectado());

    }

    public void send(String mensaje){

        this.mensajeEnviado = mensaje;
        System.out.println();
        System.out.println("Primitiva SEND (Cliente): Se enviaron datos a través de la conexión");
        System.out.println("   - Mensaje cliente: '" + this.mensajeEnviado + "' ENVIADO");
        servidor.receive(this.mensajeEnviado);

    }

    public void receive(String mensaje){

        this.mensajeRecibido = mensaje;
        System.out.println();
        System.out.println("Primitiva RECEIVE (Cliente): Se recibieron los datos de la conexión");
        System.out.println("   - Mensaje servidor: '" + this.mensajeRecibido + "' RECIBIDO");

    }

    public void close(){

        this.conexionLiberadaCliente = true;

    }

}
