package com.letmego.requirementbackend.requirement.domain.Requirement.repository;

import com.letmego.requirementbackend.requirement.domain.Requirement.model.Requirement;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RequirementRepository extends JpaRepository<Requirement, Long> {
//    List<Requirement> findByRequirementId(Long requirementId);
}
