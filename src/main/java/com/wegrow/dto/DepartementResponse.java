
package com.wegrow.dto;

public record DepartementResponse(
        Long id,
        String nom,
        String description,
        long nombreEmployes
) {}
