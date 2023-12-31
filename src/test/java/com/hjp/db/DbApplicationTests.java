package com.hjp.db;

import com.hjp.db.domain.question.entity.Question;
import com.hjp.db.domain.question.service.QuestionService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
class DbApplicationTests {

	@Autowired
	private QuestionService questionService;

	@Test
	@DisplayName("N + 1 문제 해결")
	@Transactional
	void t1() {
		List<Question> questions = questionService.findAll();

		for (Question question : questions) {
			String username = question.getAuthor().getUsername();
			int size = question.getAnswers().size();
		}
	}

	@Test
	@DisplayName("질문 제목 + 질문 내용 + 답변 내용 + 질문자 아이디 + 답변자 아이디")
	@Transactional
	void t2() {
		Page<Question> questionPage = questionService.search("제목1", 1, "NEW");

		for (Question question : questionPage.getContent()) {
			String username = question.getAuthor().getUsername();
			int size = question.getAnswers().size();

			System.out.println("username = " + username);
			System.out.println("size = " + size);
		}
	}

	@Test
	@DisplayName("질문 제목 + 질문 내용 + 답변 내용 + 질문자 아이디 + 답변자 아이디")
	@Transactional
	void t3() {
		Page<Question> questionPage = questionService.searchV2("제목", 1, "NEW");

		for (Question question : questionPage.getContent()) {
			String username = question.getAuthor().getUsername();
			int size = question.getAnswers().size();

			System.out.println("username = " + username);
			System.out.println("size = " + size);
		}
	}

	@Test
	@DisplayName("질문 제목 + 질문 내용 + 답변 내용 + 질문자 아이디 + 답변자 아이디")
	@Transactional
	void t4() {
		Page<Question> questionPage = questionService.searchV3("제목", 1, "OLD");
	}

	@Test
	@DisplayName("옵션선택가능")
	@Transactional
	void t5() {
		Page<Question> questionPage = questionService.searchV4(List.of("subject", "content", "questionAuthorUsername"), "제목", 1, "NEW");
	}

}
