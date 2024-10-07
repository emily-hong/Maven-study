package com.service.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.Board;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public static final String NS = "ns.sql.Board.";
	
	public void write(Board vo) {
		sqlSession.insert(NS+"write", vo);
	}
	
	public String selectByNoForDate(int no) {
		return sqlSession.selectOne(NS+"selectByNoForDate", no);
	}

	// 게시물 목록
	public List<Board> getBoardList() {
		List<Board> list = sqlSession.selectList(NS+"getBoardList");
		return list;
	}

	// 게시물 상세
	public Board showContent(int no) {
		Board board = sqlSession.selectOne(NS+"showContent", no);
		return board;
	}
	
	public void deleteBoard(int no) {
		sqlSession.delete(NS+"deleteBoard", no);		
	}	
	public void updateCount(int no) {
		sqlSession.update(NS+"updateCount", no);		
	}

	public void updateBoard(Board vo) {
		sqlSession.update(NS+"updateBoard", vo);		
	}	
}
