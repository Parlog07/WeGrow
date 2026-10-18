
package com.wegrow.controller;

import com.wegrow.dto.EmployeRequest;
import com.wegrow.dto.EmployeResponse;
import com.wegrow.service.EmployeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departements/{id}/employes")
public class EmployeController {

    private final EmployeService service;

    public EmployeController(EmployeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<EmployeResponse> ajouter(
            @PathVariable Long id,
            @RequestBody EmployeRequest request) {

        EmployeResponse response = service.ajouter(id, request);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<EmployeResponse>> lister(
            @PathVariable Long id) {

        return ResponseEntity.ok(service.lister(id));
    }
}
