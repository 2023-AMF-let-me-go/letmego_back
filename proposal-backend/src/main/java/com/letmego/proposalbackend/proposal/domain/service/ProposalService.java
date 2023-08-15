package com.letmego.proposalbackend.proposal.domain.service;

import com.letmego.proposalbackend.proposal.domain.Proposal.model.Proposal;

import java.util.List;

public interface ProposalService {
    Proposal createProposal(Proposal proposal);
    Proposal getProposalById(Long proposalId);
    List<Proposal> getAllProposals();
    Proposal updateProposal(Long proposalId, Proposal proposal);
    boolean deleteProposalById(Long proposalId);
    List<Proposal> getProposalListByRequirementId(Long requirementId);
}
