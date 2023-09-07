package com.proj.salad.notice.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.proj.salad.notice.vo.Criteria;
import com.proj.salad.notice.vo.NoticeVO;
import com.proj.salad.notice.vo.Notice_imageVO;

public interface NoticeService {
	
	// 1-1. (23.07.16.)
	public List<NoticeVO> selectAllNoticeList(Criteria criteria);

	// 1-2. 게시물 총 개수(23.07.16.)
	public int getTotal();
	
	// 2. 글쓰기(23.07.16.)
	public void insertNotice(NoticeVO noticeVO, HttpServletRequest request, MultipartHttpServletRequest mRequest) throws Exception;
	
	// 3-1. 게시물 상세보기(23.07.16.)
	public NoticeVO detailNotice(int articleNO);

	// 3-2. 조회수(23.07.16.)
	public void updateCnt(int articleNO, HttpSession session);
	
	// 이미지 정보 가져오기(23.07.23.)
	public List<Notice_imageVO> detailImg(int articleNO);
	
	// 3-3. 업로드 이미지 출력(23.07.23.)
	public void imgDown(String storedFileName, HttpServletResponse response);
	
	// 4-2. 게시물 수정하기(23.07.18.)
	public int updateNotice(NoticeVO noticeVO);

	// 5. 게시물 삭제하기(23.07.18.)
	public void deleteNotice(int articleNO);
	
	// 6-2. 답변 작성(23.07.18.)
	public void replyNotice(NoticeVO noticeVO);

}
