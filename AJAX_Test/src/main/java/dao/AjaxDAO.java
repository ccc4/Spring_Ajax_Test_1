package dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Board;
import model.Search_helper;

@Repository
public class AjaxDAO {
	
	private String strNameSpace = "AjaxMapper";
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public int insert(Board board) {
		return sqlSession.insert(strNameSpace + ".insert", board);
	}
	
	public Board board_ajax_1(int idx) {
		return sqlSession.selectOne(strNameSpace + ".board_ajax_1", idx);
	}
	
	public List<Board> get_list(Search_helper search_helper) {
		return sqlSession.selectList(strNameSpace + ".get_list", search_helper);
	}
}
