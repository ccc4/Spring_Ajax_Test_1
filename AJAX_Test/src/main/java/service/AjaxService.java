package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.AjaxDAO;
import model.Board;
import model.Search_helper;

@Service
public class AjaxService {
	
	private static final int ITEM_COUNT = 2;	// 한번에 불러올 게시물(아이템) 개수
	
	@Autowired
	private AjaxDAO dao;
	
	/*
	public int insert() {	// 디비에 데이터 넣는 용도
		try {
			for(int i=1;i<=10;i++) {
//				Board board = new Board();
//				board.setName(i+"번째이름");
//				board.setTitle(i+"번째제목");
				Board board = new Board(i+"번째이름", i+"번째제목");
				dao.insert(board);
			}
			return 1;
		} catch (Exception e) {
			return 0;
		}
	} 
	*/
	
	public Board board_ajax_1(int idx) {	// 해당 idx 로 가져온 게시물 데이터를 ajax 로 각각 보여줄 수 있는지 테스트
		return dao.board_ajax_1(idx);
	}
	
	// 처음 게시판으로 들어올 땐 LIMIT 0, 2 가 되게끔
	// 그 이후부터 버튼 눌러서 불러올 경우 2, 2 -> 4, 2 -> 6, 2 
	public List<Board> get_list(int mark) {
		Search_helper search_helper = new Search_helper(mark, ITEM_COUNT);
		return dao.get_list(search_helper);
	}
	
	public String add_list(int mark) {
		Search_helper search_helper = new Search_helper(mark, ITEM_COUNT);
		List<Board> list = dao.get_list(search_helper);
		if(list != null) {
			String str = "";
			
			for(int i=0;i<list.size();i++) {
				str += "<tr>";
				str += "<td>" + list.get(i).getIdx() + "</td>";
				str += "<td>" + list.get(i).getName() + "</td>";
				str += "<td>" + list.get(i).getTitle() + "</td>";
				str += "<td>" + list.get(i).getWriteDate() + "</td>";
				str += "</tr>";
			}
			return str;
		} else {
			return "";
		}
	}
}
