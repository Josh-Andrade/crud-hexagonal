package com.estudo.hexagonal.adapters.inbound;

import com.estudo.hexagonal.adapters.inbound.dto.UsuarioRequest;
import com.estudo.hexagonal.adapters.inbound.dto.UsuarioResponse;
import com.estudo.hexagonal.application.ports.UsuarioControllerPort;
import com.estudo.hexagonal.application.ports.UsuarioServicePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/hexagonal")
public class UsuarioControllerImpl implements UsuarioControllerPort {

    private final UsuarioServicePort usuarioService;

    public UsuarioControllerImpl(UsuarioServicePort usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Override
    @PostMapping("/salvar")
    public ResponseEntity<UsuarioResponse> salvar(@RequestBody @Valid UsuarioRequest usuario) {
        return ResponseEntity.ok(usuarioService.salvarUsuario(usuario));
    }

    @Override
    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioResponse>> listar() {
        return ResponseEntity.ok(usuarioService.buscarUsuarios());
    }
}
