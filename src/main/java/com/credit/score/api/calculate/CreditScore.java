package com.credit.score.api.calculate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="CREDIT_SCORE_TB")
public class CreditScore {

    @Id
    @Column
    private String id;

    @Column(name = "SSN_NUMBER")
    private String ssnNumber;

    @Column
    private Integer score;

}
