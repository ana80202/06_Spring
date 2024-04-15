package edu.kh.project.myPage.model.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.project.member.model.dto.Member;

@Mapper
public interface MyPageMapper { // Mapper 는 반드시 interface로 만들어야 한다!

	/**
	 * 회원 정보 수정
	 * 
	 * @param inputMember
	 * @return result
	 */
	int updateInfo(Member inputMember);

	/**
	 * 회원의 비밀번호 조회
	 * 
	 * @param memberNo
	 * @return 암호화 된 비밀번호
	 */
	String selectPw(int memberNo);

	/**
	 * 비밀번호 변경
	 * 
	 * @param paramMap
	 * @return result
	 */
	int changePw(Map<String, Object> paramMap);

	/**
	 * 회원탈퇴
	 * 
	 * @param memberNo
	 * @return result
	 */
	int secession(int memberNo);

}
