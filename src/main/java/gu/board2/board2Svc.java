package gu.board2;

//import gu.common.PageVO;

import gu.common.PageVO;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class board2Svc {

	@Autowired
	private SqlSessionTemplate sqlSession;	
		
    public List<?> selectBoardList(PageVO param) throws Exception {
		//return sqlSession.selectList("selectboard2List");
		return sqlSession.selectList("selectBoard2List", param);
    }
    
    public void insertBoard(boardVO param) throws Exception {
    	sqlSession.insert("insertBoard2", param);
    }
    public void updateBoard(boardVO param) throws Exception {
    	sqlSession.update("updateBoard2", param);
    }
 
    public boardVO selectBoardOne(String param) throws Exception {
		return sqlSession.selectOne("selectBoard2One", param);
    }
    
    public void deleteBoardOne(String param) throws Exception {
    	sqlSession.delete("deleteBoard2One", param);
    }
    
    //게시판 조회
    public void updateCount(String param) throws Exception {
    	sqlSession.update("updateBoard2Read", param);
    }
    
    public Integer selectBoardCount() throws Exception {
        return sqlSession.selectOne("selectBoard2Count");
    }
    
}
