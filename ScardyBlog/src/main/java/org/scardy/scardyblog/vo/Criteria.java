package org.scardy.scardyblog.vo;

import lombok.Data;

@Data
public class Criteria {
	/* 
	 * 
	 * 
	 * 페이지네이션. 페이지처리에 관한 모든 것을 설정한다.
	 * 한 '페이지'에 몇 개의 게시물을 보여줄지 (ex: 한 페이지당 10개의 개시물을 보여준다),
	 * 화면에 몇 개의 페이지를 표시할지 (ex: 게시판 글 목록 아래에 표시되는 페이지의 개수를 한 번에 몇 개를 보여줄지.
	 * 								 한 번에 1 2 3 4 5 다음> 으로 5개의 페이지만 보일수도 있고 1 2 3 다음>으로 3개의 페이지만 표시할 수도 있음.
	 * 								 한 화면에 표시하는 페이지의 개수를 이하에서는 페이지 묶음으로 설명),
	 * 현제 페이지묶음의 이전, 혹은 다음 묶음이 있는지 (ex: 현제 페이지묶음이 1~10일경우 이전페이지묶음은 존재하지 않으며 다음페이지묶음은 게시물의 개수에 따라 추가로 존재할 수 있음.
	 * 											 반대로 현재 페이지묶음이 11~20인 경우 이전 페이지묶음(1~10)은 반드시 존재하며 다음 페이지묶음(21~30)은 남은 개시물의 수에 따라 존재여부가 갈림)
	 * 이전, 혹은 다음 페이지묶음의 존재 여부에 따라 <이전, 다음> 버튼을 보여줄지
	 * 
	 *  위의 사항들을 결정하는게 페이지네이션이다.
	 *  페이지네이션에는 두 가지 요소(Criteria, paging)로 구성되어있다.
	 *  
	 * 
	 * Criteria는 criterion의 복수형이다. Criterion은 무언가를 결정하는데 있어서 필요한 기준이란 뜻이다.
	 * 즉 페이지네이션에서 Criteria는 페이지네이션을 '결정'하기 위한 '기준'들 이다.
	 * 그렇기에 '기준'이 될 수 있는 기본적인 수치들을 가지고 있으며
	 * 이 '기준'을 통한 연산은 paging에서 처리한다 
	 * 
	 * 
	 * 기본적인 수치에는 
	 * 우리가 현재 몇 페이지를 보고있는지 알기 위한 현재페이지,
	 * 한 페이지당 몇 개의 글을 보여줄지 결정하는 페이지당 보여줄 게시글의 수, 총 개시물의수 (총 개시물수/ 페이지당 보여줄 수 = 총 페이지개수, 그렇기에 총 개시물 수가 필요)
	 * 이렇게 존재한다
	 */
	
	private int nowPage; // 현재 페이지 번호
	private int boardPerPage; // 페이지당 보여줄 게시글의 개수
	private int totalBoard;	//총 게시물의 개수
	private String tag;	//이거는 개인 블로그에서 필요한거. rekosta에는 필요없음
	public int getStartPage() {
		// 특정 페이지의 범위를 정하는 구간, 현재 페이지의 게시글 시작 번호
		// 0 ~ 10 , 10 ~ 20 이런식으로
		return (this.nowPage -1) * boardPerPage+1;
	}

	public int getTotalBoard() {
		return totalBoard;
	}

	public Criteria() {
		// 기본 생성자 : 최초 게시판에 진입시 필요한 기본값
		this.nowPage = 1;
		this.boardPerPage = 10;
	}

	public void setNowPage(int page) {
		if(page <= 0) {
			this.nowPage = 1;
			
		} else {
			this.nowPage = page;
		}	
	}


	public void setBoardPerPage(int perPageNum) {
		int cnt = this.boardPerPage;
		
		if(perPageNum != cnt) {
			this.boardPerPage = cnt;	
		} else {
			this.boardPerPage = perPageNum;
		}
		
	}
}
