package edu.kh.demo.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@Setter
@Getter
public class TestDTO {
	private String memberName;
	private int memberAge;
	private String memberAddress;

}
