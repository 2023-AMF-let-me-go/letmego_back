package com.letmego.requirementbackend.requirement.controller;


import com.letmego.requirementbackend.requirement.domain.Requirement.model.Requirement;
import com.letmego.requirementbackend.requirement.domain.Requirement.repository.RequirementRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/requirements")
public class RequirementController {

    @Autowired
    private RequirementRepository requirementRepository;


    @PostMapping
    public Requirement createRequirement(@RequestBody Requirement requirement) {
        requirement.setCreateTime(LocalDateTime.now());
        requirement.setModifyTime(LocalDateTime.now());
        return requirementRepository.save(requirement);
    }

    @GetMapping
    public List<Requirement> getAllRequirements() {
        return requirementRepository.findAll();
    }

    @GetMapping("/{requirementId}")
    public Requirement getRequirementById(@PathVariable Long requirementId) {
        return requirementRepository.findById(requirementId).orElse(null);
    }

    @PutMapping("/{requirementId}")
    public Requirement updateRequirement(@PathVariable Long requirementId, @RequestBody Requirement requirement) {
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

    @DeleteMapping("/{requirementId}")
    public void deleteRequirement(@PathVariable Long requirementId) {
        requirementRepository.deleteById(requirementId);
    }

}