package com.letmego.requirementbackend.requirement.domain.Requirement.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Requirement {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_generator")
    @SequenceGenerator(name = "seq_generator", sequenceName = "my_sequence", initialValue = 1, allocationSize = 1)
    Long id;
    String title;
    String travelDetail;
    String customerId;
    String customerName;
    String customerEmail;
    String customerTelInfo;
    String area;
    String startSchedule;
    String endSchedule;
    String cntAdult;
    String cntChild;
    int budget;
    LocalDateTime createTime;
    LocalDateTime modifyTime;

}
