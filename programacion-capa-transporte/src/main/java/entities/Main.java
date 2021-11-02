package entities;

public class Main {

    public static void main(String[] args) {

        Cliente cliente = new Cliente();
        Servidor servidor = new Servidor();
        cliente.setServidor(servidor);
        servidor.setCliente(cliente);

        servidor.socket(1234);
        servidor.bind("192.168.3.2");
        servidor.listen("Solicitud Cliente 1");
        servidor.accept();

        cliente.send("Soy un cliente, te envío un mensaje");

        servidor.send("Soy el servidor, te devuelvo el mensaje");

        cliente.close();
        servidor.close();
        servidor.closeConnection();

    }
}
