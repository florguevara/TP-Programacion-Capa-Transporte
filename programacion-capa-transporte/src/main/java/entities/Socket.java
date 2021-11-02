package entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Socket {

    @NonNull
    private int idSocket;

    @NonNull
    private int nroPuerto;

    @NonNull
    private Boolean esCliente;

    @NonNull
    private Boolean esServidor;

    private String direcIP;
    private Boolean conectado;


}
