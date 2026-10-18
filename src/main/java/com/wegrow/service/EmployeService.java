
package com.wegrow.service;

import com.wegrow.dto.*;
import com.wegrow.entity.*;
import com.wegrow.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EmployeService {

    private final EmployeRepository employeRepository;
    private final DepartementRepository departementRepository;

    public EmployeService(
            EmployeRepository employeRepository,
            DepartementRepository departementRepository) {
        this.employeRepository = employeRepository;
        this.departementRepository = departementRepository;
    }

    @Transactional
    public EmployeResponse ajouter(Long departementId, EmployeRequest request) {

        Departement departement = departementRepository.findById(departementId)
                .orElseThrow(() -> new NoSuchElementException(
                        "Département introuvable"));

        if (employeRepository.existsByMatricule(request.matricule())) {
            throw new IllegalStateException("Matricule déjà utilisé");
        }

        Employe employe = new Employe(
                request.matricule(),
                request.nom(),
                request.prenom(),
                request.poste(),
                request.contrat(),
                departement
        );

        Employe saved = employeRepository.save(employe);

        return new EmployeResponse(
                saved.getId(), saved.getMatricule(),
                saved.getNom(), saved.getPrenom(),
                saved.getPoste(), saved.getContrat());
    }

    @Transactional(readOnly = true)
    public List<EmployeResponse> lister(Long departementId) {

        if (!departementRepository.existsById(departementId)) {
            throw new NoSuchElementException("Département introuvable");
        }

        return employeRepository.findByDepartementId(departementId)
                .stream()
                .map(e -> new EmployeResponse(
                        e.getId(), e.getMatricule(),
                        e.getNom(), e.getPrenom(),
                        e.getPoste(), e.getContrat()
                ))
                .toList();
    }
}
