package com.letmego.proposalbackend.proposal.controller;

import com.letmego.proposalbackend.proposal.domain.Proposal.model.Proposal;
import com.letmego.proposalbackend.proposal.domain.service.ProposalService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@Slf4j
@RequestMapping("/proposals")
public class ProposalController {

    private final ProposalService proposalService;

    @GetMapping(path = "/test")
    public String proposalTest() {
        log.info("proposal test success");
        return "proposal page";
    }


    // @Autowired
    public ProposalController(ProposalService proposalService) {
        this.proposalService = proposalService;
    }

    // API to create a new proposal
    @PostMapping
    public ResponseEntity<Proposal> createProposal(@RequestBody Proposal proposal) {
        Proposal createdProposal = proposalService.createProposal(proposal);
        return new ResponseEntity<>(createdProposal, HttpStatus.CREATED);
    }

    // API to get a proposal by ID
    @GetMapping("/{proposalId}")
    public ResponseEntity<Proposal> getProposalById(@PathVariable Long proposalId) {
        Proposal proposal = proposalService.getProposalById(proposalId);
        if (proposal != null) {
            System.out.println(proposal.toString()); // 해당 Proposal 객체를 출력합니다.
            return new ResponseEntity<>(proposal, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // API to get all proposals
    @GetMapping
    public ResponseEntity<List<Proposal>> getAllProposals() {
        List<Proposal> proposals = proposalService.getAllProposals();
        // return new ResponseEntity<>(proposals, HttpStatus.OK);
        if (!proposals.isEmpty()) {
            for (Proposal proposal : proposals) {
                System.out.println(proposal.toString()); // 해당 Proposal 객체를 출력합니다.
            }
        }
        return new ResponseEntity<>(proposals, HttpStatus.OK);
    }

    // API to update a proposal
    @PutMapping("/{proposalId}")
    public ResponseEntity<Proposal> updateProposal(
            @PathVariable Long proposalId,
            @RequestBody Proposal proposal) {
        Proposal updatedProposal = proposalService.updateProposal(proposalId, proposal);
        if (updatedProposal != null) {
            return new ResponseEntity<>(updatedProposal, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // API to delete a proposal by ID
    @DeleteMapping("/{proposalId}")
    public ResponseEntity<Void> deleteProposalById(@PathVariable Long proposalId) {
        boolean deleted = proposalService.deleteProposalById(proposalId);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/requirement/{requirementId}")
    public List<Proposal> getProposalListByRequirementId(@PathVariable Long requirementId) {
        return proposalService.getProposalListByRequirementId(requirementId);
    }
}
