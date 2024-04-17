package edu.kh.project.myPage.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.myPage.model.dto.UploadFile;

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

	/**
	 * 파일 정보를 DB 에 삽입
	 * 
	 * @param uf
	 * @return result
	 */
	int insertUploadFile(UploadFile uf);

	/**
	 * 파일 목록 조회
	 * 
	 * @return
	 */
	List<UploadFile> fileList();

	/**
	 * 프로필 이미지 변경
	 * 
	 * @param mem
	 * @return
	 */
	int profile(Member mem);

}
