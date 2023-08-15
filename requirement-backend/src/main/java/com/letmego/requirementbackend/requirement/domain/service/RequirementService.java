package com.letmego.requirementbackend.requirement.domain.service;

import com.letmego.requirementbackend.requirement.domain.Requirement.model.Requirement;

import java.util.List;

public interface RequirementService {
    Requirement createRequirement(Requirement requirement);
    List<Requirement> getAllRequirements();
    Requirement getRequirementById(Long requirementId);
    Requirement updateRequirement(Long requirementId, Requirement requirement);
    void deleteRequirement(Long requirementId);
}