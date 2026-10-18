
package com.wegrow.controller;

import com.wegrow.dto.DepartementRequest;
import com.wegrow.dto.DepartementResponse;
import com.wegrow.service.DepartementService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departements")
public class DepartementController {

    private final DepartementService service;

    public DepartementController(DepartementService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<DepartementResponse> creer(
            @RequestBody DepartementRequest request) {

        DepartementResponse response = service.creer(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<DepartementResponse>> lister() {
        return ResponseEntity.ok(service.lister());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        service.supprimer(id);
        return ResponseEntity.noContent().build();
    }
}
