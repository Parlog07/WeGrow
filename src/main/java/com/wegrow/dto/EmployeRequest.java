
package com.wegrow.dto;

import com.wegrow.entity.Contrat;

public record EmployeRequest(
        String matricule,
        String nom,
        String prenom,
        String poste,
        Contrat contrat
) {}

