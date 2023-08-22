package com.app.Entities;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionData {

	@Id
	@GeneratedValue(generator = "SEQGEN")
	@SequenceGenerator(name = "SEQGEN",initialValue = 1000000,allocationSize = 1)
	private Long transactionId;
	
	@Enumerated(EnumType.STRING)
	private MembershipType membershipType;
	@FutureOrPresent
	private Date startDate;
	@Future
	private Date endDate;
	
	private Double rupees;
	
	
	
}
