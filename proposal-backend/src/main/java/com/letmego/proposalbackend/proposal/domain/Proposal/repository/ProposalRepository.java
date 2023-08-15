package com.letmego.proposalbackend.proposal.domain.Proposal.repository;

import com.letmego.proposalbackend.proposal.domain.Proposal.model.Proposal;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProposalRepository extends JpaRepository<Proposal, Long> {
    List<Proposal> findByRequirementId(Long requirementId);
}
