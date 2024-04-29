package edu.kh.project.board.model.service;

import java.util.List;

import edu.kh.project.board.model.dto.Comment;

public interface CommentService {

	/**
	 * 댓글목록조회
	 * 
	 * @param boardNo
	 * @return commentList
	 */
	List<Comment> select(int boardNo);

	// 댓글 작성
	int insert(Comment comment);

	// 댓글 수정
	int update(Comment comment);

	// 댓글 삭제
	int delete(int commentNo);

}
