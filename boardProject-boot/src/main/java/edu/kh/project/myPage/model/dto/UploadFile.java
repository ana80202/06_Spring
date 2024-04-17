package edu.kh.project.myPage.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor // 기본 생성자 (mybatis 가 사용하는 기본생성자 꼭 생성해줘야한다!)
@Setter
@Getter
@ToString
@Builder
public class UploadFile {

	// @Builder : 빌더 패턴을 이용해 객체 생성 및 초기화를 쉽게 진행
	// -> 기본 생성자가 생성이 안된다
	// ->Mybatis 조회 결과를 담을 때 기본생성자로 객체를 만들기 때문이다!

	private int fileNo;
	private String filePath;
	private String fileOriginalName;
	private String fileRename;
	private String fileUploadDate;
	private int memberNo;
	private String memberNickname;

}
