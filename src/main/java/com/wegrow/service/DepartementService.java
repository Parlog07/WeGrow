
package com.wegrow.service;

import com.wegrow.dto.*;
import com.wegrow.entity.Departement;
import com.wegrow.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartementService {

    private final DepartementRepository departementRepository;
    private final EmployeRepository employeRepository;

    public DepartementService(
            DepartementRepository departementRepository,
            EmployeRepository employeRepository) {
        this.departementRepository = departementRepository;
        this.employeRepository = employeRepository;
    }

    @Transactional
    public DepartementResponse creer(DepartementRequest request) {

        if (departementRepository.existsByNom(request.nom())) {
            throw new IllegalStateException("Ce département existe déjà");
        }

        Departement departement = new Departement(
                request.nom(), request.description());

        Departement saved = departementRepository.save(departement);

        return new DepartementResponse(
                saved.getId(), saved.getNom(),
                saved.getDescription(), 0);
    }

    @Transactional(readOnly = true)
    public List<DepartementResponse> lister() {

        return departementRepository.findAll().stream()
                .map(d -> new DepartementResponse(
                        d.getId(),
                        d.getNom(),
                        d.getDescription(),
                        employeRepository.countByDepartementId(d.getId())
                ))
                .toList();
    }

    @Transactional
    public void supprimer(Long id) {

        if (!departementRepository.existsById(id)) {
            throw new java.util.NoSuchElementException(
                    "Département introuvable");
        }

        if (employeRepository.existsByDepartementId(id)) {
            throw new IllegalStateException(
                    "Impossible de supprimer un département avec des employés");
        }

        departementRepository.deleteById(id);
    }
}
