
package com.wegrow.dto;

import com.wegrow.entity.Contrat;

public record EmployeResponse(
        Long id,
        String matricule,
        String nom,
        String prenom,
        String poste,
        Contrat contrat
) {}
