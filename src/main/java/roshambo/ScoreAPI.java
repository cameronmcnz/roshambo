package roshambo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@Transactional
public class ScoreAPI {
	
	
	@PersistenceContext
	private EntityManager entityManager;
	

	@GetMapping("/thescore")
	public Score getTheMainScore() {
		Score score = entityManager.find(Score.class, 1);
		return score;
	}
	
	@GetMapping("/increasethewins")
	public Score increaseScore() {
		Score score = entityManager.find(Score.class, 1);
		score.wins++;
		return score;
	}
	
	@GetMapping("/deletescore")
	public String deleteScore() {
		Score score = entityManager.find(Score.class, 1);
		entityManager.remove(score);
		return "deleted";
	}
	
	@GetMapping("/allscores")
	public List<Score> getAllScores() {
		List<Score> allScores = entityManager.createQuery("from Score", Score.class).getResultList();
		return allScores;
	}
	
	@GetMapping("/randomizescore")
	public Score updateScore() {
		Score score = entityManager.find(Score.class, 1);

		score.wins = (int)(Math.random()*100);
		score.losses = (int)(Math.random()*100);
		score.ties = (int)(Math.random()*100);

		return score;
	}
	

	@GetMapping("/addabunchofscores")
	public List<Score> addSomeScores() {
		for (int i = 0; i<10;i++) {
			Score score = new Score();
			entityManager.persist(score);
			
			score.wins = (int)(Math.random()*100);
			score.losses = (int)(Math.random()*100);
			score.ties = (int)(Math.random()*100);
			
		}
		return getAllScores();
	}
	
	@EventListener(ContextRefreshedEvent.class)
	public void addTheFirstRecordOnStartup() {
		Score score = entityManager.find(Score.class, 1);
		if (score == null) {
			score = new Score();
			entityManager.persist(score);
		}
		System.out.println("Score object id 1 created.");
	}
	
}
