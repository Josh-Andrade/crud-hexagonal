package com.estudo.hexagonal.adapters.inbound;

import com.estudo.hexagonal.adapters.dto.UsuarioRequest;
import com.estudo.hexagonal.adapters.dto.UsuarioResponse;
import com.estudo.hexagonal.ports.UsuarioControllerPort;
import com.estudo.hexagonal.ports.UsuarioServicePort;
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
        return ResponseEntity.created(null).body(usuarioService.salvarUsuario(usuario));
    }

    @Override
    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioResponse>> listar() {
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }

    @Override
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletar(@PathVariable String id) throws Throwable {
        usuarioService.deletarUsuario(id);
        return ResponseEntity.ok(null);
    }

    @Override
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<UsuarioResponse> atualizarUsuario(@RequestBody @Valid UsuarioRequest usuario, @PathVariable String id) throws Throwable {
        return ResponseEntity.ok(usuarioService.atualizarUsuario(usuario, id));
    }

    @Override
    @GetMapping("/buscar/{nome}")
    public ResponseEntity<UsuarioResponse> buscarUsuario(@PathVariable String nome) throws Throwable {
        return ResponseEntity.ok(usuarioService.buscarUsuario(nome));
    }

}
