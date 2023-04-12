package org.scardy.scardyblog.vo;

import lombok.Data;

@Data
public class Paging {
	/* Criteria 먼저 읽고 오기
	 * 
	 * 여기서는 Criteria(기준)을 가지고 연산을 해 세부적인 결과값을 정한다
	 * 
	 */
	
	private int totalBoard; // 게시판 전체 데이터 개수
	private int displayPageNum = 5; // 게시판 화면에서 한번에 보여질 페이지 번호의 개수 (하나의 페이지묶음에 몇 개의 페이지(게시물개수아님)가 들어갈지) 
	private int startPage; // 화면의 시작 번호
	private int endPage;  // 화면의 끝 번호
	private boolean prev; // 페이징 이전 버튼 활성화 여부
	private boolean next; // 페이징 다음 버튼 활성화 여부
	private Criteria cri;

	
	public int getTotalBoard() {
		return totalBoard;
	}

	public void setTotalBoard(int totalCount) {
		this.totalBoard = totalCount;
		pagingData();
	}
	
	private void pagingData() {
		
		endPage = (int) (Math.ceil(cri.getNowPage() / (double) displayPageNum) * displayPageNum);
		// endPage = (현재 페이지 번호 / 화면에 보여질 페이지 번호의 개수) * 화면에 보여질 페이지 번호의 개수
		startPage = (endPage - displayPageNum) + 1;
		// startPage = (끝 페이지 번호 - 화면에 보여질 페이지 번호의 개수) + 1
		
		int tempEndPage = (int) (Math.ceil(totalBoard / (double) cri.getBoardPerPage()));	
		if(endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		// 마지막 페이지 번호 = 총 게시글 수 / 한 페이지당 보여줄 게시글의개수
		
		prev = startPage == 1 ? false : true;	
		// 이전 버튼 생성 여부 = 시작 페이지 번호가 1과 같으면 false, 아니면 true
		next = endPage * cri.getBoardPerPage() >= totalBoard ? false : true;
		// 다음 버튼 생성 여부 = 끝 페이지 번호 * 한 페이지당 보여줄 게시글의 개수가 총 게시글의 수보다
		// 크거나 같으면 false, 아니면 true
	}
	
}