package persistence;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;

import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;
import entity.Question;
import entity.Quiz;

@RunWith(DemoiselleRunner.class)
public class QuizDAOTest {
	@Inject
	QuizDAO dao;
	
	@Test
	public void testAdd() {
		QuizDAO dao = new QuizDAO();
		
		Quiz quiz = new Quiz();
		quiz.setCategory("Category 1");
		
		Question q1 = new Question();
		q1.setEnunciation("These are the option for 1st question");
		q1.setPropositions(new String[]{"Option 1.1","Option 1.2","Option 1.3"});
		q1.setAnswer(0);
		
		Question q2 = new Question();
		q2.setEnunciation("These are the option for 2nd question");
		q2.setPropositions(new String[]{"Option 2.1","Option 2.2","Option 2.3"});
		q2.setAnswer(0);

		quiz.setQuestions(new Question[]{q1,q2});
		
		dao.add(quiz);
		
		assertNotNull(dao.quiz("Category 1"));
	}
	
	@Test
	public void listCategories() {
		assertTrue(dao.listCategories().size() > 0);
	}

}
