package com.letmego.proposalbackend.proposal.domain.service.impl;

import com.letmego.proposalbackend.proposal.domain.Proposal.model.Proposal;
import com.letmego.proposalbackend.proposal.domain.Proposal.repository.ProposalRepository;
import com.letmego.proposalbackend.proposal.domain.service.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProposalServiceImpl implements ProposalService {

    private final ProposalRepository proposalRepository;

    @Autowired
    public ProposalServiceImpl(ProposalRepository proposalRepository) {
        this.proposalRepository = proposalRepository;
    }

    @Override
    public Proposal createProposal(Proposal proposal) {
        return proposalRepository.save(proposal);
    }

    @Override
    public Proposal getProposalById(Long proposalId) {
        return proposalRepository.findById(proposalId).orElse(null);
    }

    @Override
    public List<Proposal> getAllProposals() {
        return proposalRepository.findAll();
    }

    @Override
    public Proposal updateProposal(Long proposalId, Proposal proposal) {
        Proposal existingProposal = proposalRepository.findById(proposalId).orElse(null);
        if (existingProposal != null) {
            existingProposal.setTitle(proposal.getTitle());
            existingProposal.setTravelDetail(proposal.getTravelDetail());
            existingProposal.setCustomerId(proposal.getCustomerId());
            existingProposal.setCustomerName(proposal.getCustomerName());
            existingProposal.setCustomerEmail(proposal.getCustomerEmail());
            existingProposal.setCustomerTelInfo(proposal.getCustomerTelInfo());
            existingProposal.setArea(proposal.getArea());
            existingProposal.setStartSchedule(proposal.getStartSchedule());
            existingProposal.setEndSchedule(proposal.getEndSchedule());
            existingProposal.setCntAdult(proposal.getCntAdult());
            existingProposal.setCntChild(proposal.getCntChild());
            existingProposal.setBudget(proposal.getBudget());
            existingProposal.setModifyTime(LocalDateTime.now());

            return proposalRepository.save(existingProposal);
        }
        return null;
    }

    @Override
    public boolean deleteProposalById(Long proposalId) {
        Proposal existingProposal = proposalRepository.findById(proposalId).orElse(null);
        if (existingProposal != null) {
            proposalRepository.delete(existingProposal);
            return true;
        }
        return false;
    }

    @Override
    public List<Proposal> getProposalListByRequirementId(Long requirementId) {
        return proposalRepository.findByRequirementId(requirementId);
    }
}
