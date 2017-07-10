package com.revature.main;

import com.revature.beans.Game;
import com.revature.beans.League;
import com.revature.daos.GameDAO;
import com.revature.daos.GameDAOImpl;
import com.revature.daos.LeagueDAO;
import com.revature.daos.LeagueDAOImpl;

public class DriverTeresa {

	public static void main(String[] args) {
		/*GameDAO dao = new GameDAOImpl();
		List<Game> games = dao.viewScheduleByTeam(new Integer(5));
		for (Game g : games) {
			System.out.println(g.toString());
		}*/
		
		/* select trade0_.TRADE_ID as TRADE_ID1_5_0_, trade0_.COMMISSIONER_APPROVAL as COMMISSIONER_APPRO2_5_0_, 
		* trade0_.FROM_TEAM_APPROVAL as FROM_TEAM_APPROVAL3_5_0_, trade0_.USER_ID as USER_ID5_5_0_, trade0_.TEAM_ID 
		* as TEAM_ID6_5_0_, trade0_.TO_TEAM_APPROVAL as TO_TEAM_APPROVAL4_5_0_, user1_.USER_ID as USER_ID1_6_1_, 
		* user1_.ACTIVE as ACTIVE2_6_1_, user1_.EMAIL as EMAIL3_6_1_, user1_.FIRST_NAME as FIRST_NAME4_6_1_, 
		* user1_.LAST_NAME as LAST_NAME5_6_1_, user1_.PASSWORD as PASSWORD6_6_1_, user1_.ROLE as ROLE7_6_1_, 
		* user1_.TEAM_ID as TEAM_ID10_6_1_, user1_.UNIFORM_NUMBER as UNIFORM_NUMBER8_6_1_, user1_.USERNAME as USERNAME9_6_1_, 
		* team2_.TEAM_ID as TEAM_ID1_4_2_, team2_.TEAMID as TEAMID6_4_2_, team2_.LEAGUE_ID as LEAGUE_ID7_4_2_, team2_.TEAM_NAME 
		* as TEAM_NAME2_4_2_, team2_.TEAM_NICKNAME as TEAM_NICKNAME3_4_2_, team2_.COLOR_PRIMARY as COLOR_PRIMARY4_4_2_, 
		* team2_.COLOR_SECONDARY as COLOR_SECONDARY5_4_2_, league3_.LEAGUE_ID as LEAGUE_ID1_1_3_, league3_.PTS_PER_OT_LOSS as 
		* PTS_PER_OT_LOSS2_1_3_, league3_.NAME as NAME3_1_3_, league3_.PTS_OR_PCT as PTS_OR_PCT4_1_3_, league3_.SPORT_ID as 
		* SPORT_ID9_1_3_, league3_.PTS_PER_TIE as PTS_PER_TIE5_1_3_, league3_.TIES_ALLOWED as TIES_ALLOWED6_1_3_, 
		* league3_.PTS_PER_OT_WIN as PTS_PER_OT_WIN7_1_3_, league3_.PTS_PER_WIN as PTS_PER_WIN8_1_3_, sport4_.SPORT_ID as 
		* SPORT_ID1_3_4_, sport4_.SPORT as SPORT2_3_4_, league5_.LEAGUE_ID as LEAGUE_ID1_1_5_, league5_.PTS_PER_OT_LOSS as 
		* PTS_PER_OT_LOSS2_1_5_, league5_.NAME as NAME3_1_5_, league5_.PTS_OR_PCT as PTS_OR_PCT4_1_5_, league5_.SPORT_ID as 
		* SPORT_ID9_1_5_, league5_.PTS_PER_TIE as PTS_PER_TIE5_1_5_, league5_.TIES_ALLOWED as TIES_ALLOWED6_1_5_, 
		* league5_.PTS_PER_OT_WIN as PTS_PER_OT_WIN7_1_5_, league5_.PTS_PER_WIN as PTS_PER_WIN8_1_5_ from TRADES trade0_ left 
		* outer join USERS user1_ on trade0_.USER_ID=user1_.USER_ID left outer join TEAMS team2_ on trade0_.TEAM_ID=team2_.TEAM_ID 
		* left outer join LEAGUES league3_ on team2_.TEAMID=league3_.LEAGUE_ID left outer join SPORTS sport4_ on 
		* league3_.SPORT_ID=sport4_.SPORT_ID left outer join LEAGUES league5_ on team2_.LEAGUE_ID=league5_.LEAGUE_ID where 
		* trade0_.TRADE_ID=?
		
		TradeDAO dao = new TradeDAOImpl();
		Trade trade = dao.selectTradeById(new Integer(1));
		System.out.println(trade.getTradeID());
		*/
		
		/*
		 * select user0_.USER_ID as USER_ID1_6_0_, user0_.ACTIVE as ACTIVE2_6_0_, user0_.EMAIL as EMAIL3_6_0_, user0_.FIRST_NAME 
		 * as FIRST_NAME4_6_0_, user0_.LAST_NAME as LAST_NAME5_6_0_, user0_.PASSWORD as PASSWORD6_6_0_, user0_.ROLE as 
		 * ROLE7_6_0_, user0_.TEAM_ID as TEAM_ID10_6_0_, user0_.UNIFORM_NUMBER as UNIFORM_NUMBER8_6_0_, user0_.USERNAME as 
		 * USERNAME9_6_0_ from USERS user0_ where user0_.USER_ID=?
		 * 
		UserDAO udao = new UserDAOImpl();
		User user = udao.selectUserById(new Integer(5));
		System.out.println(user.getFirstName());*/
		
		//GameDAO dao = new GameDAOImpl();
		//Game game = dao.selectGameById(new Integer(2));
		//System.out.println(game.getGameID());
		
		LeagueDAO dao = new LeagueDAOImpl();
		League league = dao.selectLeagueById(new Integer(1));
		System.out.println(league.getLeagueID());
		
	}
}
