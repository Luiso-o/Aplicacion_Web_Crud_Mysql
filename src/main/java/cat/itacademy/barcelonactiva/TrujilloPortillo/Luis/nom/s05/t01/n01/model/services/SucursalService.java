package cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.nom.s05.t01.n01.model.services;

import cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.nom.s05.t01.n01.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.nom.s05.t01.n01.model.dto.SucursalDto;
import cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.nom.s05.t01.n01.model.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SucursalService {

    private final SucursalRepository sucursalRepository;

    @Autowired
    public SucursalService(SucursalRepository sucursalRepository) {
        this.sucursalRepository = sucursalRepository;
    }

    public List<SucursalDto> getAllSucursales() {
        List<Sucursal> sucursales = sucursalRepository.findAll();
        return sucursales.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public SucursalDto getSucursalById(Integer id) {
        Optional<Sucursal> sucursalOptional = sucursalRepository.findById(id);
        return sucursalOptional.map(this::convertToDto).orElse(null);
    }

    public void createSucursal(SucursalDto sucursalDTO) {
        Sucursal sucursal = convertToEntity(sucursalDTO);
        sucursalRepository.save(sucursal);
    }

    public void updateSucursal(Integer id, SucursalDto sucursalDTO) {
        Optional<Sucursal> sucursalOptional = sucursalRepository.findById(id);
        sucursalOptional.ifPresent(sucursal -> {
            sucursal.setNombreSucursal(sucursalDTO.getNombreSucursal());
            sucursal.setPaisSucursal(sucursalDTO.getPaisSucursal());
            sucursalRepository.save(sucursal);
        });
    }

    public void deleteSucursal(Integer id) {
        sucursalRepository.deleteById(id);
    }

    private SucursalDto convertToDto(Sucursal sucursal) {
        return new SucursalDto(sucursal.getNombreSucursal(), sucursal.getPaisSucursal());
    }

    private Sucursal convertToEntity(SucursalDto sucursalDTO) {
        return new Sucursal(sucursalDTO.getNombreSucursal(), sucursalDTO.getPaisSucursal());
    }
}
