package com.letmego.requirementbackend.requirement.domain.service.impl;

import com.letmego.requirementbackend.requirement.domain.Requirement.model.Requirement;
import com.letmego.requirementbackend.requirement.domain.Requirement.repository.RequirementRepository;
import com.letmego.requirementbackend.requirement.domain.service.RequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RequirementServiceImpl implements RequirementService {

    @Autowired
    private RequirementRepository requirementRepository;

    @Override
    public Requirement createRequirement(Requirement requirement) {
        requirement.setCreateTime(LocalDateTime.now());
        requirement.setModifyTime(LocalDateTime.now());
        return requirementRepository.save(requirement);
    }

    @Override
    public List<Requirement> getAllRequirements() {
        return requirementRepository.findAll();
    }

    @Override
    public Requirement getRequirementById(Long requirementId) {
        return requirementRepository.findById(requirementId).orElse(null);
    }

    @Override
    public Requirement updateRequirement(Long requirementId, Requirement requirement) {
        Requirement existingRequirement = requirementRepository.findById(requirementId).orElse(null);
        if (existingRequirement == null) {
            throw new IllegalArgumentException("Invalid requirement ID: " + requirementId);
        }
        existingRequirement.setTitle(requirement.getTitle());
        existingRequirement.setTravelDetail(requirement.getTravelDetail());
        existingRequirement.setCustomerId(requirement.getCustomerId());
        existingRequirement.setCustomerName(requirement.getCustomerName());
        existingRequirement.setCustomerEmail(requirement.getCustomerEmail());
        existingRequirement.setCustomerTelInfo(requirement.getCustomerTelInfo());
        existingRequirement.setArea(requirement.getArea());
        existingRequirement.setStartSchedule(requirement.getStartSchedule());
        existingRequirement.setEndSchedule(requirement.getEndSchedule());
        existingRequirement.setCntAdult(requirement.getCntAdult());
        existingRequirement.setCntChild(requirement.getCntChild());
        existingRequirement.setBudget(requirement.getBudget());
        existingRequirement.setModifyTime(LocalDateTime.now());
        return requirementRepository.save(existingRequirement);
    }

    @Override
    public void deleteRequirement(Long requirementId) {
        requirementRepository.deleteById(requirementId);
    }
}