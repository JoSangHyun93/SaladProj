package com.proj.salad.notice.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.proj.salad.notice.vo.Criteria;
import com.proj.salad.notice.vo.NoticeVO;
import com.proj.salad.notice.vo.Notice_imageVO;

import lombok.RequiredArgsConstructor;

@Repository("noticeDao")
@RequiredArgsConstructor
public class NoticeDAOImpl implements NoticeDAO {

	//DB에 접속하기 위해 의존관계 주입
	@Autowired
	private SqlSessionTemplate sqlSession;

	// 1-1. 리뷰게시판 전체리스트 보기(23.07.16.)
	@Override
	public List<NoticeVO> selectAllNoticeList(Criteria criteria) {
		return sqlSession.selectList("notice.selectAllNoticeList", criteria);
	}

	// 1-2. 게시물 총 개수(23.07.16.)
	@Override
	public int getTotal() {
		return sqlSession.selectOne("notice.getTotal");
	}

	// 2-1. 리뷰게시판 글쓰기(23.07.16.)
	@Override
	public void insertNotice(NoticeVO noticeVO) {
		sqlSession.insert("notice.insertNotice", noticeVO);
	}
	
	// 게시물 번호 가져오기(23.07.20.)
	@Override
	public String selectNotice(NoticeVO noticeVO) {
		return sqlSession.selectOne("notice.selectNotice", noticeVO);
	}
	
	// 파일 업로드(23.07.20.)
	@Override
	public void insertImage(Map<String, Object> map) throws Exception {
		sqlSession.insert("notice.insertNoticeImg", map);
	}
	
	// 3-1. 게시물 상세보기(23.07.16.)
	@Override
	public NoticeVO detailNotice(int articleNO) {
		return (NoticeVO) sqlSession.selectOne("notice.detailNotice", articleNO);
	}
	
	// 3-2. 조회수(23.07.16.)
	@Override
	public void updateCnt(int articleNO) {
		sqlSession.update("notice.updateCnt", articleNO);
	}
	
	// 이미지 정보 가져오기(23.07.23.)
	@Override
	public List<Notice_imageVO> detailImg(int articleNO) {
		return sqlSession.selectList("notice.detailImg", articleNO);
	}

	// 4-2. 게시물 수정하기(23.07.18.)
	@Override
	public int updateNotice(NoticeVO noticeVO) {
		return sqlSession.update("notice.updateNotice", noticeVO);
	}

	// 5. 게시물 삭제하기(23.07.18.)
	@Override
	public void deleteNotice(int articleNO) {
		sqlSession.delete("notice.deleteNotice", articleNO);		
	}

	// 6-2. 답변 작성(23.07.18.)
	@Override
	public void replyNotice(NoticeVO noticeVO) {
		sqlSession.insert("notice.replyNotice", noticeVO);
	}
	
}
