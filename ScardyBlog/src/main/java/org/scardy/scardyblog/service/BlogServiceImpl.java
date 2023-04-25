package org.scardy.scardyblog.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Clob;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import javax.sql.rowset.serial.SerialClob;
import javax.sql.rowset.serial.SerialException;

import org.scardy.scardyblog.entity.Blog;
import org.scardy.scardyblog.entity.Category;
import org.scardy.scardyblog.repository.BlogRepository;
import org.scardy.scardyblog.repository.CategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BlogServiceImpl implements BlogService {
	private final BlogRepository blogRepository;
	private final CategoryRepository categoryRepository;

	@Transactional
	public boolean wirteBlogPost(String id, String category, String title, StringBuilder content, String thumbnail ) {
		Blog board = new Blog();
		board.setId(id);
		board.setCategory(category);
		board.setTitle(title);
		board.setThumbnail(thumbnail);
		SerialClob clobContent;
		try {
			clobContent = new SerialClob(content.toString().toCharArray());
			board.setContent(clobContent);
			LocalDateTime now = LocalDateTime.now();
			board.setPost_date(Date.valueOf(now.toLocalDate()));;
			blogRepository.save(board);
		} catch (SerialException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Blog findBlogPostInfoDetail(int postNo) throws SQLException, IOException {
		Blog board = blogRepository.findById(postNo).get();
		return board;
	}
	
	@Override
	public StringBuilder findBlogPostContentDetail(int postNo) throws SQLException, IOException {
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		//CLOB(텍스트데이터)->getCharacterStream(변환기)->finder(문자의 stream, 글자 하나하나가 여러개있음)->Bufferedfinder(변환기)->String or StringBuilder(문자열)
		//우리가 일반적으로 사용하는건 문자'열'로써 문장으로써 사용된다. finder은 문자를 return하므로 이를 모아서 문자열로써 만드는 작업이 필요하다
		Clob clob = blogRepository.findById(postNo).get().getContent();//Clob데이터형은 기본적으로 데이터베이스에서 사용되는 자료형으로써 java에서 사용하기에는 부적절	
		Reader finder = clob.getCharacterStream();
		//getCharactherStream은 clob데이터를 읽기위한 finder클래스를 반환함. finder클래스는 텍스트 데이터를 문자로 변환함
		//즉 데이터베이스에 텍스트데이터 형태로 저장되어있는 정보를 가져온 뒤 getCharacterStream을 사용하여 문자로 변환하는 finder 클래스를 만듦
		BufferedReader bufferedfinder = new BufferedReader(finder); //문자를 문자열로 만드는 변환기
		StringBuilder contentStringBuilder = new StringBuilder();//데이터 용량이 커서 String 대신 StringBuilder클래스를 사용함
		String line;//BufferedReader를 통해 문자에서 문자열(문장)으로 만들어진걸 저장할 String 객체
		while ((line = bufferedfinder.readLine()) != null) {//문자->문자열로 바뀐걸 한 줄 한 줄 변환해서
			contentStringBuilder.append(line);//StringBuilder클래스에 추가해줌.
		}
		/*
		* 압축된 원자재(clob, 텍스트데이터)이(가) 있고
		* 이를 도구(finder)를 통해 잘개 쪼개서(텍스트데이터->문자) 운반을 한 뒤 
		* 한 줄에 10개씩 총 10줄에 들어가는 상자에 넣기 편하게
		* Bufferedfinder를 사용해서 도구(reader)를 통해 잘게 쪼개진 재료(문자)를 한 줄(문자열)로 만든 뒤
		* 만들어진 한 줄을 상자(StringBuilder)에 넣는다
		* 
		*/
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		return contentStringBuilder;
	}
	/*
	@Override
	public List<Board> findBlogPostListByCategoryForBlog(String category) {
		blogRepository.findByCategoryForBlog(category);
		return null;
	}
*/	@Override
	public List<Blog> findListByCategoryForBlog(String category) {
		List<Blog> boardList= blogRepository.findListByCategoryForBlog(category);
		return boardList;
	}

	@Override
	public List<Blog> findListByCategoryForBlogMode(String category) {
		List<Blog> boardList= blogRepository.findListByCategoryForBlogMode(category);
		return boardList;
	}
	
	@Override
	public List<Blog> findBlogPostList(String postNo) {
		return null;
	}

	@Override
	public String writeCategory(Category category) {
		String result;
		try {
			categoryRepository.save(category);
			result = "success";
		} catch (Exception e) {
			result = e.toString();
		}
		return result;
	}

	@Override
	public List<Blog> findListByRecent4() {
		List<Blog> list = blogRepository.findListByRecent4();
		return list;
	}

	

	

	
}
