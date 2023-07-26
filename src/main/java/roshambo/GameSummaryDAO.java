package roshambo;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GameSummaryDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public Collection<GameSummary> getAllGameSummarys() {
		// Replace this statement with the call to jdbcTemplate.
		return jdbcTemplate.query("SELECT * FROM GAMESUMMARY", new BeanPropertyRowMapper<GameSummary>(GameSummary.class));
	}

}
