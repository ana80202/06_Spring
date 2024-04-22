package edu.kh.project.board.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.project.board.model.dto.Board;
import edu.kh.project.board.model.dto.Pagination;
import edu.kh.project.board.model.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;

@Transactional
@Service
@RequiredArgsConstructor // 코드줄여줌
public class BoardServuceImpl implements BoardService {

	private final BoardMapper mapper;

	// 게시판 종류 조회
	@Override
	public List<Map<String, Object>> selectBoardTypeList() {
		return mapper.selectBoardTypeList();
	}

	// 틍정 게시판의 지정된 페이지 목록 조회
	@Override
	public Map<String, Object> selectBoardList(int boardCode, int cp) {

		// 1. 지정된 게시판 (boardCode) 에서
		// 삭제 되지 않은 게시글 수를 조회
		int listCount = mapper.getListCount(boardCode);

		// 2. 1번의 결과 + cp를 이용해서
		// Pagination 객체를 생성
		// * Pagination 객체 : 게시글 목록 구성에 필요한 값을 저장한 객체
		Pagination pagination = new Pagination(cp, listCount);

		// 3. 특정 게시판의 지정된 페이지 목록 조회
		/*ROWBOUNDS 객체 (Mybatis에서 제공해주는 객체)
		 * -지정된 크기 만큼 건너뛰고 (offset)
		 *  제한된 크기(limit) 만큼의 행을 조회하는 객체
		 * 
		 * --> 페이징 처리가 굉장히 간단해진다.
		 * */
		int limit = pagination.getLimit();
		int offset = (cp - 1) * limit;
		RowBounds rowBounds = new RowBounds(offset, limit);

		/*Mapper 메서드 호출 시
		 * -첫 번재 매개변수 -> SQL 에 전달할 파라미터
		 * -두 번째 매개변수 -> RowBounds 객체 전달
		 * 
		 * 
		 * */
		List<Board> boaordList = mapper.selectBoardList(boardCode, rowBounds);

		// 4. 목록 조회 결과 + pagination 객체르 Map 으로 묶음(반환할떄 하나만 반환할 수 있어서 map으로 묶어서 보내는 거임!)
		Map<String, Object> map = new HashMap<>();

		map.put("pagination", pagination);
		map.put("boardList", boaordList);

		// 5.결과 반환
		return map;
	}

}
