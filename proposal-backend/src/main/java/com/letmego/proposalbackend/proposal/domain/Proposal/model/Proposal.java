package com.letmego.proposalbackend.proposal.domain.Proposal.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Proposal {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_generator")
    @SequenceGenerator(name = "seq_generator", sequenceName = "my_sequence", initialValue = 1, allocationSize = 1)
    private Long id;
    private Long requirementId;
    private String title;
    private String travelDetail;
    private String customerId;
    private String customerName;
    private String customerEmail;
    private String customerTelInfo;
    private String area;
    private String startSchedule;
    private String endSchedule;
    private String cntAdult;
    private String cntChild;
    private int budget;
    private LocalDateTime createTime;
    private LocalDateTime modifyTime;

    private String sellerId;
    private String sellerName;
    private String sellerTelInfo;
}
