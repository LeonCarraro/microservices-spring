package com.leoncarraro.customerservice.domain.vo;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerVO {

	@NotBlank
	private String firstName;

	@NotBlank
	private String lastName;

	@NotBlank
	private String email;

}
