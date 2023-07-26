package roshambo;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class MyRestAPI {
	
	@Autowired
	private GameSummaryDAO gameSummaryDAO;
	
	@GetMapping("/gamesummary")
	public Collection<GameSummary> getAllGameSummaryObjects() {
		return gameSummaryDAO.getAllGameSummarys();
	}
	


}
