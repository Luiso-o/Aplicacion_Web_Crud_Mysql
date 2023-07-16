package cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.nom.s05.t01.n01.model.dto;

import java.util.Arrays;
import java.util.List;

public class SucursalDto {

    private Integer id;
    private String nombreSucursal;
    private String paisSucursal;
    private String tipoSucursal;
    private static final List<String> paisesUE = Arrays.asList("Austria", "Bélgica", "Bulgaria", "Croacia", "Chipre",
            "República Checa", "Dinamarca", "Estonia", "Finlandia", "Francia", "Alemania", "Grecia", "Hungría",
            "Irlanda", "Italia", "Letonia", "Lituania", "Luxemburgo", "Malta", "Holanda", "Polonia",
            "Portugal", "Rumania", "Eslovaquia", "Eslovenia", "España", "Suecia");

    public SucursalDto() {
    }

    public SucursalDto(String nombreSucursal, String paisSucursal) {
        this.nombreSucursal = nombreSucursal;
        this.paisSucursal = paisSucursal;
        this.tipoSucursal = determinarTipoSucursal(paisSucursal);
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

    public String getTipoSucursal() {
        return tipoSucursal;
    }

    public void setTipoSucursal(String tipoSucursal) {
        this.tipoSucursal = tipoSucursal;
    }

    private String determinarTipoSucursal(String pais) {
        if (paisesUE.contains(pais)) {
            return "UE";
        } else {
            return "Fuera UE";
        }
    }

    @Override
    public String toString() {
        return "SucursalDto{" +
                "id=" + id +
                ", nombreSucursal='" + nombreSucursal + '\'' +
                ", paisSucursal='" + paisSucursal + '\'' +
                ", tipoSucursal='" + tipoSucursal + '\'' +
                '}';
    }

}
