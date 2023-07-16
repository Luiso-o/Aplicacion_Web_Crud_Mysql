package cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.nom.s05.t01.n01.model.domain;

import jakarta.persistence.*;

@Entity
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sucursal")
    private Integer id;
    @Column(name = "nombre_sucursal")
    private String nombreSucursal;
    @Column(name = "país_sucursal")
    private String paisSucursal;

    public Sucursal(){}

    public Sucursal(String nombreSucursal, String paisSucursal) {
        this.nombreSucursal = nombreSucursal;
        this.paisSucursal = paisSucursal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreSucursal() {
        return nombreSucursal;
    }

    public void setNombreSucursal(String nombreSucursal) {
        this.nombreSucursal = nombreSucursal;
    }

    public String getPaisSucursal() {
        return paisSucursal;
    }

    public void setPaisSucursal(String paisSucursal) {
        this.paisSucursal = paisSucursal;
    }
}
