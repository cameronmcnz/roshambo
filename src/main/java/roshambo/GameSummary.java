package roshambo;

public class GameSummary {
	
	public Long id;
	public String clientGesure, serverGesture, result;
	java.sql.Timestamp timePlayed;
	
	public GameSummary() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClientGesure() {
		return clientGesure;
	}

	public void setClientGesure(String clientGesure) {
		this.clientGesure = clientGesure;
	}

	public String getServerGesture() {
		return serverGesture;
	}

	public void setServerGesture(String serverGesture) {
		this.serverGesture = serverGesture;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public java.sql.Timestamp getTimePlayed() {
		return timePlayed;
	}

	public void setTimePlayed(java.sql.Timestamp timePlayed) {
		this.timePlayed = timePlayed;
	}

}
