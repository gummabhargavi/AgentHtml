package Infinte.AgentJdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AgentDAO {
	
	Connection connection;
	PreparedStatement pst;

	public List<Agent> showAgent() throws ClassNotFoundException, SQLException{
		
		List<Agent> agentList = new ArrayList<Agent>();
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Agent";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		Agent agent = null;
		while(rs.next()){
			agent = new Agent();
			agent.setAgentId(rs.getInt("AgentId"));
			agent.setCity(rs.getString("City"));
			agent.setPremium(rs.getInt("Premium"));
			agent.setName(rs.getString("Name"));
//			agent.setGender(rs.getString("GENDER"));
			agent.setMaritalStatus(rs.getInt("MaritalStatus"));
			agentList.add(agent);
		}
		return agentList;
	}
}
