package soccer_manager;

import java.util.LinkedList;

import Club.Account;
import Club.Club;
import Club.Manager;
import Club.Stadium;
import Club.Tactics;

/**
 * Class for initiating 32 clubs objects
 * @author Zuocheng Wang
 *
 */
public class Clubs {
	
	public Club Chelsea;
	public Club Liverpool;
	public Club Manchester_United;
	public Club Real_Madrid;
	public Club Barcelona;
	public Club Manchester_City;
	public Club Paris_Saint_Germain;
	public Club bayernmunich;
	public Club Juventus;
	public Club Inter_Milan;
	public Club Atletico_Madrid;
	public Club Lokomotiv_Moscow;
	public Club Red_Bull_Salzburg;
	public Club Borussia_Dortmund;
	public Club Sevilla;
	public Club Ajax;
	public Club RB_Leipzig;
	public Club Lazio;
	public Club Borussia_Mionchengladbach;
	public Club Olympiacos;
	public Club Shakhtar_Donetsk;
	public Club Porto;
	public Club Marseille;
	public Club Atalanta;
	public Club midtjylland;
	public Club rennes;
	public Club Club_Brugge;
	public Club Dynamo_Kyiv;
	public Club Benfica;
	public Club Spartak_Moscow;
	public Club CSKA_Moscow;
	public Club Galatasaray;
	
	LinkedList<Club> clubs_list;
	
	/**
	 * constructor of clubs class
	 */
	public Clubs()
	{
		clubs_list = new LinkedList<Club>();
		
		//String name, double pay, int age, String nationality, 
		//int attacker_num, int midfielder_num, int defender_num, Tactics tactics
		
		// Chelsea
		Stadium s1 = new Stadium("Stamford Bridge Stadium", 40834);
		Account che_rich_club_account = new Account(300000000);
		Chelsea = new Club("Chelsea", che_rich_club_account, "Roman Abramovich", s1, 5);
		Manager m1 = new Manager("Thomas Tuchel", 10000000 ,47, "Germany", 4, 5 ,1 , Tactics.counter_attack );
		Chelsea.addManager(m1);
		clubs_list.add(Chelsea);
		
		// Liverpool
		Stadium s2 = new Stadium("Anfield Stadium", 53394);
		Account lp_strong_club_account = new Account(250000000);
		Liverpool = new Club("Liverpool", lp_strong_club_account, "Tom Werner", s2, 5);
		Manager m2 = new Manager("Jurgen Klopp", 10000000 ,54 , "Germany", 4, 3 ,3 , Tactics.attacking );
		Liverpool.addManager(m2);
		clubs_list.add(Liverpool);

		
		// Manchester United 
		Stadium s3 = new Stadium("Old Trafford", 74140);
		Account mu_strong_club_account = new Account(250000000);
		Manchester_United = new Club("Manchester United", mu_strong_club_account, "Avram Glazer", s3, 5);
		Manager m3 = new Manager("Ole Gunnar Solskjr", 10000000 ,48 , "Germany", 4, 5 ,1 , Tactics.attacking );
		Manchester_United.addManager(m3);
		clubs_list.add(Manchester_United);
		
		// Real Madrid 
		Stadium s4 = new Stadium("Bernabeu", 74140);
		Account rm_rich_club_account = new Account(300000000);
		Real_Madrid = new Club("Real Madrid", rm_rich_club_account, "Florentino Perez", s4, 5); 
		Manager m4 = new Manager("Carlo Ancelotti", 10000000 ,62 , "Italy", 4, 5 ,1 , Tactics.counter_attack );
		Real_Madrid.addManager(m4);
		clubs_list.add(Real_Madrid);
		
		// Barcelona 
		Stadium s5 = new Stadium("Camp Nou", 99354);
		Account barc_rich_club_account = new Account(250000000);
		Barcelona = new Club("Barcelona", barc_rich_club_account, "Joan Laporta", s5, 5);
		Manager m5 = new Manager("Ronald Koeman", 10000000 ,58 , "Netherlands", 3, 4 ,3 , Tactics.tiki_taka );
		Barcelona.addManager(m5);
		clubs_list.add(Barcelona);
		
		// Manchester City 
		Stadium s6 = new Stadium("Etihad Stadium", 55017);
		Account mc_rich_club_account = new Account(300000000);
		Manchester_City = new Club("Manchester City", mc_rich_club_account, "Khaldoon Al Mubarak", s6, 4);
		Manager m6 = new Manager("Pep Guardiola", 15000000 ,50 , "Spain", 3, 5 ,2 , Tactics.tiki_taka );
		Manchester_City.addManager(m6);
		clubs_list.add(Manchester_City);
		
		// Paris Saint-Germain
		Stadium s7 = new Stadium("Parc des Princes", 47929);
		Account psg_rich_club_account = new Account(350000000);
		Paris_Saint_Germain = new Club("Paris Saint-Germain", psg_rich_club_account, "Nasser Al-Khelaifi", s7, 4);
		Manager m7 = new Manager("Mauricio Pochettino", 15000000 ,49 , "Argentina", 4, 3 ,3 , Tactics.attacking );
		Paris_Saint_Germain.addManager(m7);
		clubs_list.add(Paris_Saint_Germain);
		
		// Bayern Munich
		Stadium s8 = new Stadium("Allianz Arena", 75000);
		Account bay_strong_club_account = new Account(250000000);
		bayernmunich  = new Club("Bayern Munich", bay_strong_club_account, "Herbert Hainer", s8, 5);
		Manager m8 = new Manager("Julian Nagelsmann", 10000000 ,34 , "Germany", 3, 5 ,2 , Tactics.attacking );
		bayernmunich.addManager(m8);
		clubs_list.add(bayernmunich);
		
		// Juventus
		Stadium s9 = new Stadium("Juventus Stadium", 41507);
		Account juven_strong_club_account = new Account(250000000);
		Juventus = new Club("Juventus", juven_strong_club_account, "Andrea Agnelli", s9, 5);
		Manager m9 = new Manager("Massimiliano Allegri", 10000000 ,53 , "Italy", 4, 3 ,3 , Tactics.balance );
		Juventus.addManager(m9);
		clubs_list.add(Juventus);
		
		// Inter_Milan
		Stadium s10 = new Stadium("Giuseppe Meazza", 75923);
		Account Inter_strong_club_account = new Account(200000000);
		Inter_Milan = new Club("Inter Milan", Inter_strong_club_account, "Steven Zhang", s10, 4);
		Manager m10 = new Manager("Simone Inzaghi", 10000000 ,45 , "Italy", 3, 5 ,2 , Tactics.balance );
		Inter_Milan.addManager(m10);
		clubs_list.add(Inter_Milan);
		
		// Atletico_Madrid
		Stadium s11 = new Stadium("Wanda Metropolitano", 68457);
		Account am_normal_club_account = new Account(200000000);
		Atletico_Madrid = new Club("Atletico Madrid", am_normal_club_account, "Enrique Cerezo", s11, 3);
		Manager m11 = new Manager("Diego Simeone", 10000000 ,51 , "Argentina", 4, 4 ,2 , Tactics.counter_attack );
		Atletico_Madrid.addManager(m11);
		clubs_list.add(Atletico_Madrid);
		
		// Lokomotiv Moscow
		Stadium s12 = new Stadium("RZD Arena", 27320);
		Account lm_week_club_account = new Account(150000000);
		Lokomotiv_Moscow = new Club("Lokomotiv Moscow", lm_week_club_account, "Vladimir Leonchenko", s12, 1);
		Manager m12 = new Manager("Marko Nikolic", 5000000 ,42 , "Serbia", 4, 4 ,2 , Tactics.park_the_bus );
		Lokomotiv_Moscow.addManager(m12);
		clubs_list.add(Lokomotiv_Moscow);
		
		// Red Bull Salzburg
		Stadium s13 = new Stadium("	Red Bull Arena", 31895);
		Account rbs_week_club_account = new Account(150000000);
		Red_Bull_Salzburg = new Club("Red Bull Salzburg", rbs_week_club_account, "Harald Lurzer", s13, 2);
		Manager m13 = new Manager("Matthias Jaissle", 5000000 ,33 , "Germany", 4, 3 ,3 , Tactics.balance );
		Red_Bull_Salzburg.addManager(m13);
		clubs_list.add(Red_Bull_Salzburg);
		
		// Borussia Dortmund
		Stadium s14 = new Stadium("Westfalenstadion", 81365);
		Account dt_strong_club_account = new Account(200000000);
		Borussia_Dortmund = new Club("Borussia Dortmund", dt_strong_club_account, "Reinhard Rauball", s14, 3);
		Manager m14 = new Manager("Marco Rose", 5000000 ,44 , "Germany", 4, 5 ,1 , Tactics.attacking );
		Borussia_Dortmund.addManager(m14);
		clubs_list.add(Borussia_Dortmund);
		
		// Sevilla
		Stadium s15 = new Stadium("stadio Ramon Sanchez Pizjuan", 42714);
		Account sev_normal_club_account = new Account(150000000);
		Sevilla = new Club("Sevilla", sev_normal_club_account, "Rafael Carrion Moreno", s15, 2);
		Manager m15 = new Manager("Julen Lopetegui", 5000000 ,54 , "Spain", 4, 3 ,3 , Tactics.counter_attack );
		Sevilla.addManager(m15);
		clubs_list.add(Sevilla);
		
		// ajax 
		Stadium s16 = new Stadium("Johan Cruyff Arena", 55500);
		Account ajax_normal_club_account = new Account(150000000);
		Ajax  = new Club("Ajax", ajax_normal_club_account, "Rafael Carrion Moreno", s16, 2);
		Manager m16 = new Manager("Erik ten Hag", 5000000 ,51 , "Netherlands", 4, 5 ,1 , Tactics.attacking );
		Ajax.addManager(m16);
		clubs_list.add(Ajax);
		
		// RB leipzig  
		Stadium s17 = new Stadium("Red Bull Arena", 42959);
		Account Leipzig_weak_club_account = new Account(150000000);
		RB_Leipzig  = new Club("RB Leipzig", Leipzig_weak_club_account, "Oliver Mintzlaff", s17, 2);
		Manager m17 = new Manager("Jesse Marsch", 5000000 ,47 , "US", 4, 4 ,2 , Tactics.balance );
		RB_Leipzig.addManager(m17);
		clubs_list.add(RB_Leipzig);
		
		// lazio 
		Stadium s18 = new Stadium("Stadio Olimpico", 70634);
		Account lazio_normal_club_account = new Account(200000000);
		Lazio = new Club("Lazio", lazio_normal_club_account, "Claudio Lotito", s18, 3);
		Manager m18 = new Manager("Maurizio Sarri", 10000000 ,62 , "Italy", 4, 3 ,3 , Tactics.counter_attack );
		Lazio.addManager(m18);
		clubs_list.add(Lazio);
		
		// Borussia Mionchengladbach
		Stadium s19 = new Stadium("Borussia-Park", 54057);
		Account Borussia_normal_club_account = new Account(200000000);
		Borussia_Mionchengladbach = new Club("Borussia Mionchengladbach", Borussia_normal_club_account, "Rolf Konigs", s19, 3);
		Manager m19 = new Manager("Adi Hutter", 5000000 ,51 , "Austria", 4, 4 ,2 , Tactics.park_the_bus);
		Borussia_Mionchengladbach.addManager(m19);
		clubs_list.add(Borussia_Mionchengladbach);
		
		
		// Olympiacos
		Stadium s20 = new Stadium("Karaiskakis Stadium", 32115);
		Account Olympiacos_weak_club_account = new Account(150000000);
		Olympiacos = new Club("Olympiacos", Olympiacos_weak_club_account, "Evangelos Marinakis", s20, 2);
		Manager m20 = new Manager("Pedro Martins", 5000000 ,51 , "Portugal", 5, 4 ,1 , Tactics.park_the_bus);
		Olympiacos.addManager(m20);
		clubs_list.add(Olympiacos);
		
		// Shakhtar_Donetsk 
		Stadium s21 = new Stadium("Donbass Arena", 70050);
		Account Shakhtar_Donetsk_weak_club_account = new Account(150000000);
		Shakhtar_Donetsk = new Club("Shakhtar Donetsk", Shakhtar_Donetsk_weak_club_account, "Rinat Akhmetov", s21, 1);
		Manager m21 = new Manager("Roberto De Zerbi", 5000000 ,42 , "Italy", 4, 3 ,3 , Tactics.balance);
		Shakhtar_Donetsk.addManager(m21);
		clubs_list.add(Shakhtar_Donetsk);
		
		// porto 
		Stadium s22 = new Stadium("Estadio do Dragon", 50033);
		Account porto_weak_club_account = new Account(150000000);
		Porto = new Club("Porto", porto_weak_club_account, "Jorge Nuno Pinto da Costa", s22, 2);
		Manager m22 = new Manager("Sergio Conceicao", 5000000 ,46 , "Portugal", 4, 4 ,3 , Tactics.attacking);
		Porto.addManager(m22);
		clubs_list.add(Porto);
		
		// marseille 
		Stadium s23 = new Stadium("Estadio do Dragon", 50033);
		Account marseille_weak_club_account = new Account(150000000);
		Marseille = new Club("Marseille", marseille_weak_club_account, "Pablo Longoria", s23, 2);
		Manager m23 = new Manager("Jorge Sampaoli", 5000000 ,61 , "Argentine", 4, 4 ,3 , Tactics.tiki_taka);
		Marseille.addManager(m23);
		clubs_list.add(Marseille);
		
		// atalanta  
		Stadium s24 = new Stadium("Gewiss Stadium", 21300);
		Account Atalanta_weak_club_account = new Account(150000000);
		Atalanta  = new Club("Atalanta", Atalanta_weak_club_account, "Antonio Percassi", s24, 2);
		Manager m24 = new Manager("Gian Piero Gasperini", 5000000 ,63 , "Italy", 3, 4 ,3 , Tactics.attacking);
		Atalanta.addManager(m24);
		clubs_list.add(Atalanta);

		// midtjylland   
		Stadium s25 = new Stadium("MCH Arena", 11432);
		Account midtjylland_weak_club_account = new Account(150000000);
		midtjylland   = new Club("Midtjylland", midtjylland_weak_club_account, "Antonio Percassi", s25, 1);
		Manager m25 = new Manager("Bo Henriksen", 5000000 ,46 , "Denmark", 4, 3 ,3 , Tactics.counter_attack);
		midtjylland.addManager(m25);
		clubs_list.add(midtjylland);
		
		// rennes    
		Stadium s26 = new Stadium("Roazhon Park", 29778);
		Account rennes_weak_club_account = new Account(180000000);
		rennes = new Club("Rennes", rennes_weak_club_account, "Antonio Percassi", s26, 2);
		Manager m26 = new Manager("Bruno Genesio", 5000000 ,54 , "France", 4, 5 ,1 , Tactics.park_the_bus);
		rennes.addManager(m26);
		clubs_list.add(rennes);
		
		// Club Brugge    
		Stadium s27 = new Stadium("Jan Breydel Stadium", 29062);
		Account Club_Brugge_weak_club_account = new Account(150000000);
		Club_Brugge = new Club("Club Brugge", Club_Brugge_weak_club_account, "Bart Verhaeghe", s27, 1);
		Manager m27 = new Manager("Philippe Clement", 5000000 ,47 , "Belgium", 4, 3 ,3 , Tactics.attacking);
		Club_Brugge.addManager(m27);
		clubs_list.add(Club_Brugge);
		
		// dynamokyiv   
		Stadium s28 = new Stadium("NSC Olimpiyskiy", 70050);
		Account dynamokyiv_weak_club_account = new Account(150000000);
		Dynamo_Kyiv = new Club("Dynamo Kyiv", dynamokyiv_weak_club_account, "Ihor Surkis", s28, 1);
		Manager m28 = new Manager("Mircea Lucescu", 5000000 ,75 , "Romania", 4, 3 ,3 , Tactics.attacking);
		Dynamo_Kyiv.addManager(m28);
		clubs_list.add(Dynamo_Kyiv);
		
		// benfica    
		Stadium s29 = new Stadium("Estadio da Luz", 64642);
		Account benfica_weak_club_account = new Account(150000000);
		Benfica  = new Club("Benfica", benfica_weak_club_account, "Rui Costa", s29, 1);
		Manager m29 = new Manager("Jorge Jesus", 5000000 ,67 , "Portugal", 4, 5 ,1 , Tactics.balance);
		Benfica.addManager(m29);
		clubs_list.add(Benfica);
		
		// Spartak Moscow    
		Stadium s30 = new Stadium("Otkritie Arena", 45360);
		Account Spartak_Moscow_weak_club_account = new Account(150000000);
		Spartak_Moscow  = new Club("Spartak Moscow", Spartak_Moscow_weak_club_account, "Yevgeni Melezhikov", s30, 1);
		Manager m30 = new Manager("Rui Vitoria", 5000000 ,51 , "Portugal", 4, 5 ,1 , Tactics.counter_attack);
		Spartak_Moscow.addManager(m30);
		clubs_list.add(Spartak_Moscow);
		
		// CSKA_Moscow    
		Stadium s31 = new Stadium("VEB Arena", 30457);
		Account CSKA_Moscow_weak_club_account = new Account(150000000);
		CSKA_Moscow  = new Club("PFC CSKA Moscow", CSKA_Moscow_weak_club_account, "Yevgeni Giner", s31, 1);
		Manager m31 = new Manager("Aleksei Berezutski", 5000000 ,39 , "Russia", 4, 5 ,1 , Tactics.counter_attack);
		CSKA_Moscow.addManager(m31);
		clubs_list.add(CSKA_Moscow);
		
		// Galatasaray  
		Stadium s32 = new Stadium("Ali Sami Yen Stadium", 52695);
		Account Galatasaray_weak_club_account = new Account(150000000);
		Galatasaray  = new Club("Galatasaray", Galatasaray_weak_club_account, "Yevgeni Giner", s32, 2);
		Manager m32 = new Manager("Fatih Terim", 5000000 ,67 , "Turkey", 4, 5 ,1 , Tactics.balance);
		Galatasaray.addManager(m32);
		clubs_list.add(Galatasaray);
	}

}
