package client;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class RunExecutes {

	private DataInputStream dataIn = null;
	private BufferedReader textIn = null;

	private int receivedCode = CommandC.NOTHING_TO_DO;
	private int dataInteger;
	private String dataText = null;
	private int numberOnDice;

	// pomocni atributi

	private static boolean colorIsSelected = false;

	public static boolean isColorIsSelected() {
		return colorIsSelected;
	}

	public static void setColorIsSelected(boolean colorIsSelected) {
		RunExecutes.colorIsSelected = colorIsSelected;
	}

	void runExecutes() throws IOException, InterruptedException {

		try {

			dataIn = new DataInputStream(Client.getSocket().getInputStream());
			textIn = new BufferedReader(new InputStreamReader(Client.getSocket().getInputStream()));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * stalno primamo poruke od servera
		 */

		while (!GameC.isEndOfGame()) {

			while (dataIn.available() == 0) {
				Thread.sleep(10);
			}
			receivedCode = dataIn.readInt();

			switch (receivedCode) {

			case CommandC.THROW_DICE:
				throw_dice();
				receivedCode = CommandC.NOTHING_TO_DO;
				break;

			case CommandC.CREATE_ROOM:
				create_room();
				receivedCode = CommandC.NOTHING_TO_DO;
				break;

			case CommandC.ERROR:
				error();
				receivedCode = CommandC.NOTHING_TO_DO;
				break;

			case CommandC.GO_START:
				go_start();
				receivedCode = CommandC.NOTHING_TO_DO;
				break;

			case CommandC.SEND_COLOR:
				send_color();
				receivedCode = CommandC.NOTHING_TO_DO;
				break;

			case CommandC.PLAY:
				play();
				receivedCode = CommandC.NOTHING_TO_DO;
				break;
				
			case CommandC.GAMESTART:
				gameStart();
				receivedCode = CommandC.NOTHING_TO_DO;
				break;

			default:
				receivedCode = CommandC.NOTHING_TO_DO;
				break;

			}

		}
	}

	private void gameStart() throws IOException, InterruptedException {
		System.out.println("Cita boju...");
		while (dataIn.available() == 0) {
			Thread.sleep(10);
		}
		int playerColor = dataIn.readInt();
		
		System.out.println("Procitao boju start");
		System.out.println(playerColor);
		
		switch (playerColor) {

		case CommandC.RED:
			Client.ludoGame.getLblDiceBackPlayerRed().setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/edgeDice (5).png")));
			break;

		case CommandC.BLUE:
			Client.ludoGame.getLblDiceBackPlayerBlue().setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/edgeDice (5).png")));
			break;

		case CommandC.GREEN:
			Client.ludoGame.getLblDiceBackPlayerGreen().setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/edgeDice (5).png")));
			break;

		case CommandC.YELLOW:
			Client.ludoGame.getLblDiceBackPlayerYellow().setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/edgeDice (5).png")));
			break;

		default:
			break;

		}
		
		//ClientExecute.setSendingCode(CommandC.THROW_DICE);
		
	}

	private void play() throws IOException, InterruptedException {

		// ovde ima mnogo gresaka!!!

		while (dataIn.available() == 0) {
			Thread.sleep(10);
		}
		int playerID = dataIn.readInt();

		//System.out.println("Uso u play - klijent");
		//System.out.println(playerID);

		// ovde je greska, mozda i na server strani

		// ova linija ne prima info od servera!!!!!!!!!!!!!!
		// zauvek ostaje u ovoj liniji koda
		while (dataIn.available() == 0) {
			Thread.sleep(10);
		}
		int codeAll = dataIn.readInt();

		//System.out.println("Procitao kod");
		//System.out.println(codeAll);

		String line;
		String name = textIn.readLine();
		/*
		while(textIn.ready()) {
			name = textIn.readLine();
		}
		*/
		//System.out.println("Procito ime sa servera");
		//System.out.println(name);

		// ako je 1 onda je jedan novi spreman, ako je 2 onda su svi spremni

		Client.game.getPlayers()[playerID - 1].setName(name);

		switch (Client.game.getPlayers()[playerID - 1].getColor()) {

		case CommandC.RED:
			Client.ludoMain.getLblPawnRed()
					.setIcon(new ImageIcon(LudoMain.class.getResource("/Resource/PawnEdge/pawnRedR.png")));
			Client.ludoGame.getLblNamePlayerRed().setText(name);
			break;

		case CommandC.BLUE:
			Client.ludoMain.getLblPawnBlue()
					.setIcon(new ImageIcon(LudoMain.class.getResource("/Resource/PawnEdge/pawnBlueR.png")));
			Client.ludoGame.getLblNamePlayerBlue().setText(name);
			break;

		case CommandC.GREEN:
			Client.ludoMain.getLblPawnGreen()
					.setIcon(new ImageIcon(LudoMain.class.getResource("/Resource/PawnEdge/pawnGreenR.png")));
			Client.ludoGame.getLblNamePlayerGreen().setText(name);
			break;

		case CommandC.YELLOW:
			Client.ludoMain.getLblPawnYellow()
					.setIcon(new ImageIcon(LudoMain.class.getResource("/Resource/PawnEdge/pawnYellowR.png")));
			Client.ludoGame.getLblNamePlayerYellow().setText(name);
			break;

		default:
			break;

		}
		if (codeAll == 1) {

			Client.ludoMain.setVisible(false);
			Client.ludoGame.setVisible(true);
		}

	}

	private void send_color() throws IOException, InterruptedException {

		while (dataIn.available() == 0) {
			Thread.sleep(10);
		}
		int playerID = dataIn.readInt();

		while (dataIn.available() == 0) {
			Thread.sleep(10);
		}
		int colour = dataIn.readInt();

		Client.game.getPlayers()[playerID - 1].setColor(colour);

		if (playerID == GameC.getYouPlayerID()) {
			// setujem da sam ja uzeo boju
			// za sada ce izgledati isto jer treba ubaciti nove ikonice za te slucajeve

			colorIsSelected = true;

			switch (colour) {

			case CommandC.RED:
				Client.ludoMain.getLblPawnRed()
						.setIcon(new ImageIcon(LudoMain.class.getResource("/Resource/PawnEdge/pawnRedEdge.png")));
				Client.game.make_red_pawns(playerID);
				break;

			case CommandC.BLUE:
				Client.ludoMain.getLblPawnBlue()
						.setIcon(new ImageIcon(LudoMain.class.getResource("/Resource/PawnEdge/pawnBlueEdge.png")));
				Client.game.make_blue_pawns(playerID);
				break;

			case CommandC.GREEN:
				Client.ludoMain.getLblPawnGreen()
						.setIcon(new ImageIcon(LudoMain.class.getResource("/Resource/PawnEdge/pawnGreenEdge.png")));
				Client.game.make_green_pawns(playerID);
				break;

			case CommandC.YELLOW:
				Client.ludoMain.getLblPawnYellow()
						.setIcon(new ImageIcon(LudoMain.class.getResource("/Resource/PawnEdge/pawnYellowEdge.png")));
				Client.game.make_yelow_pawns(playerID);
				break;

			default:
				break;

			}

		} else {
			// kad drugi uzmu boju
			// za sada ce izgledati isto jer treba ubaciti nove ikonice za te slucajeve

			Client.game.getPlayers()[playerID - 1].setPlayerId(playerID);

			switch (colour) {

			case CommandC.RED:
				Client.ludoMain.getLblPawnRed()
						.setIcon(new ImageIcon(LudoMain.class.getResource("/Resource/PawnEdge/pawnRedS.png")));
				Client.game.make_red_pawns(playerID);
				break;

			case CommandC.BLUE:
				Client.ludoMain.getLblPawnBlue()
						.setIcon(new ImageIcon(LudoMain.class.getResource("/Resource/PawnEdge/pawnBlueS.png")));
				Client.game.make_blue_pawns(playerID);
				break;

			case CommandC.GREEN:
				Client.ludoMain.getLblPawnGreen()
						.setIcon(new ImageIcon(LudoMain.class.getResource("/Resource/PawnEdge/pawnGreenS.png")));
				Client.game.make_green_pawns(playerID);
				break;

			case CommandC.YELLOW:
				Client.ludoMain.getLblPawnYellow()
						.setIcon(new ImageIcon(LudoMain.class.getResource("/Resource/PawnEdge/pawnYellowS.png")));
				Client.game.make_yelow_pawns(playerID);
				break;

			default:
				break;

			}
		}

	}

	private void go_start() throws IOException, InterruptedException {

		while (dataIn.available() == 0) {
			Thread.sleep(10);
		}
		int playerID = dataIn.readInt();

		// sstigo sam dovde 26.3.
		// mozda treba reorganizacija klijent strane jer mi ne trebaju tolike
		// informacije o drugim klijentima
		// kada treba nesto da se pomera na talonu server me obavestava o tomedd
		// ne treba da se sve te info prukupljaju kod mene
		// meni su potrebne samo striktne info o meni

		Client.game.setYouPlayerID(playerID);

		Client.game.getPlayers()[playerID - 1].setPlayerId(playerID);

		Client.ludoStart.setVisible(false);
		Client.ludoMain.setVisible(true);

	}

	/*
	 * sve greske prvo salju error kod, a drugi kod se gleda u ovom svicu i na
	 * osnovu njega izlai poruka
	 * 
	 */
	private void error() throws IOException, InterruptedException {

		while (dataIn.available() == 0) {
			Thread.sleep(10);
		}
		dataInteger = dataIn.readInt();

		switch (dataInteger) {

		case CommandC.ERROR_ROOM:
			JOptionPane.showMessageDialog(new JFrame(), "Room error", "Error", JOptionPane.ERROR_MESSAGE);
			break;

		case CommandC.ERROR_COLOR:
			JOptionPane.showMessageDialog(new JFrame(), "Color error, try again", "Error", JOptionPane.ERROR_MESSAGE);
			break;

		default:
			break;

		}

	}

	/*
	 * citam sa servera roomID, upisujem ga objekat game na klijentu
	 */
	private void create_room() throws IOException, InterruptedException {

		while (dataIn.available() == 0) {
			Thread.sleep(10);
		}
		dataInteger = dataIn.readInt();

		GameC.setRoomID(dataInteger);

		JOptionPane.showMessageDialog(new JFrame(), "You have successfully created room number: " + GameC.getRoomID(),
				"Room created", JOptionPane.INFORMATION_MESSAGE);

		LudoStart.textRoom.setText(String.valueOf(GameC.getRoomID()));

	}
	
	private void diceRoll(int color) {
		JLabel kockica = null;
		switch(color) {
		case CommandC.BLUE:
			kockica = Client.ludoGame.getLblDicePlayerBlue();
			break;
		case CommandC.YELLOW:
			kockica = Client.ludoGame.getLblDicePlayerYellow();
			break;
		case CommandC.RED:
			kockica = Client.ludoGame.getLblDicePlayerRed();
			break;
		case CommandC.GREEN:
			kockica = Client.ludoGame.getLblDicePlayerGreen();
			break;
		default:
			break;
		}
		for(int i = 0; i < 5000; i++) {
			kockica.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/DiceYou/diceYou1Final.png")));
			kockica.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/DiceYou/diceYou2Final.png")));
			kockica.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/DiceYou/diceYou3Final.png")));
			kockica.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/DiceYou/diceYou4Final.png")));
			kockica.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/DiceYou/diceYou5Final.png")));
			kockica.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/DiceYou/diceYou6Final.png")));
		}
	}
	
	private boolean isMovable(PawnC pawn, int color, int diceNum) {
		switch(color) {
		case CommandC.YELLOW:
			return pawn.getFieldIndex() + diceNum <= 56 || (diceNum == 6 && (pawn.getFieldIndex() == 88 || pawn.getFieldIndex() == 89 || pawn.getFieldIndex() == 90 || pawn.getFieldIndex() == 91));
		case CommandC.BLUE:
			return (pawn.getFieldIndex() >= 0 && pawn.getFieldIndex() <= 51) || (pawn.getFieldIndex() >= 67 && pawn.getFieldIndex() + diceNum <= 71) || (diceNum == 6 && pawn.getFieldIndex() >= 96 && pawn.getFieldIndex() <= 99); 
		case CommandC.RED:
			return (pawn.getFieldIndex() >= 0 && pawn.getFieldIndex() <= 51) || (pawn.getFieldIndex() >= 57 && pawn.getFieldIndex() + diceNum <= 61) || (diceNum == 6 && pawn.getFieldIndex() >= 92 && pawn.getFieldIndex() <= 95);
		case CommandC.GREEN:
			return (pawn.getFieldIndex() >= 0 && pawn.getFieldIndex() <= 51) || (pawn.getFieldIndex() >= 62 && pawn.getFieldIndex() + diceNum <= 66) || (diceNum == 6 && pawn.getFieldIndex() >= 100 && pawn.getFieldIndex() <= 103);
		default:
			return false;
		}
	}
	
	private void move(PawnC pawn, int color, int diceNum) {
		System.out.println(diceNum);
		switch(color) {
		case CommandC.BLUE:
			if(diceNum == 6 && pawn.getFieldIndex() >= 96 && pawn.getFieldIndex() <= 99) {
				pawn.setFieldIndex(39);
				pawn.setCoordinatePawn_x(Client.game.findFieldById(39).getCoordinate_x());
				pawn.setCoordinatePawn_y(Client.game.findFieldById(39).getCoordinate_y());
				break;
			}
			if(pawn.getFieldIndex() <= 51 && pawn.getFieldIndex() >= 39 && pawn.getFieldIndex() + diceNum > 51) {
				int id = pawn.getFieldIndex() + diceNum - 52;
				pawn.setFieldIndex(id);
				pawn.setCoordinatePawn_x(Client.game.findFieldById(id).getCoordinate_x());
				pawn.setCoordinatePawn_y(Client.game.findFieldById(id).getCoordinate_y());
				break;
			}
			if((pawn.getFieldIndex() <= 51 && pawn.getFieldIndex() >= 39 && pawn.getFieldIndex() + diceNum <= 51) || (pawn.getFieldIndex() <= 38 && pawn.getFieldIndex() >= 0 && pawn.getFieldIndex() + diceNum <= 38)) {
				int id = pawn.getFieldIndex() + diceNum;
				pawn.setFieldIndex(id);
				pawn.setCoordinatePawn_x(Client.game.findFieldById(id).getCoordinate_x());
				pawn.setCoordinatePawn_y(Client.game.findFieldById(id).getCoordinate_y());
				break;
			}
			if(pawn.getFieldIndex() <= 38 && pawn.getFieldIndex() + diceNum > 38) {
				int id = pawn.getFieldIndex() + diceNum - 38 + 66;
				pawn.setFieldIndex(id);
				pawn.setCoordinatePawn_x(Client.game.findFieldById(id).getCoordinate_x());
				pawn.setCoordinatePawn_y(Client.game.findFieldById(id).getCoordinate_y());
				break;
			}
			break;
			//ispraviti idejeve za kucice, dodati za ostale boje, i za cilj
		}
	}

	private void throw_dice() throws IOException, InterruptedException {
		while (dataIn.available() == 0) {
			Thread.sleep(10);
		}
		int color = dataIn.readInt();
		
		Client.game.setPlayersOnTurn(color);
		
		PlayerC player = Client.game.findPlayerByColor(color);
		
		for(int i = 0; i < Client.game.players.length; i++) {
			if(Client.game.players[i].getColor() == color) {
				diceRoll(color);
				break;
			}
		}

		while (dataIn.available() == 0) {
			Thread.sleep(10);
		}
		numberOnDice = dataIn.readInt();
		
		JLabel kockica = null;
		
		switch(color) {
		case CommandC.BLUE:
			kockica = Client.ludoGame.getLblDicePlayerBlue();
			break;
		case CommandC.YELLOW:
			kockica = Client.ludoGame.getLblDicePlayerYellow();
			break;
		case CommandC.RED:
			kockica = Client.ludoGame.getLblDicePlayerRed();
			break;
		case CommandC.GREEN:
			kockica = Client.ludoGame.getLblDicePlayerGreen();
			break;
		default:
			break;
		}

		
		switch(numberOnDice) {
		case 1:
			//slike
			kockica.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/DiceYou/diceYou1Final.png")));
			break;
		case 2:
			kockica.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/DiceYou/diceYou2Final.png")));
			break;
		case 3:
			kockica.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/DiceYou/diceYou3Final.png")));
			break;
		case 4:
			kockica.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/DiceYou/diceYou4Final.png")));
			break;
		case 5:
			kockica.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/DiceYou/diceYou5Final.png")));
			break;
		case 6:
			kockica.setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/DiceYou/diceYou6Final.png")));
/*
			switch(color) {
			case CommandC.BLUE:
				if(Client.ludoGame.getLblPawnBlue1().getIcon() != null) Client.ludoGame.getLblPawnBlue1().setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnBlueTableEdge.png")));
				if(Client.ludoGame.getLblPawnBlue2().getIcon() != null) Client.ludoGame.getLblPawnBlue2().setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnBlueTableEdge.png")));
				if(Client.ludoGame.getLblPawnBlue3().getIcon() != null) Client.ludoGame.getLblPawnBlue3().setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnBlueTableEdge.png")));
				if(Client.ludoGame.getLblPawnBlue4().getIcon() != null) Client.ludoGame.getLblPawnBlue4().setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnBlueTableEdge.png")));
				
				break;
			case CommandC.YELLOW:
				if(Client.ludoGame.getLblPawnYellow1().getIcon() != null) Client.ludoGame.getLblPawnYellow1().setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnYellowTableEdge.png")));
				if(Client.ludoGame.getLblPawnYellow2().getIcon() != null) Client.ludoGame.getLblPawnYellow2().setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnYellowTableEdge.png")));
				if(Client.ludoGame.getLblPawnYellow3().getIcon() != null) Client.ludoGame.getLblPawnYellow3().setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnYellowTableEdge.png")));
				if(Client.ludoGame.getLblPawnYellow4().getIcon() != null) Client.ludoGame.getLblPawnYellow4().setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnYellowTableEdge.png")));
				
				break;
			case CommandC.RED:
				if(Client.ludoGame.getLblPawnRed1().getIcon() != null) Client.ludoGame.getLblPawnRed1().setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnRedTableEdge.png")));
				if(Client.ludoGame.getLblPawnRed2().getIcon() != null) Client.ludoGame.getLblPawnRed2().setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnRedTableEdge.png")));
				if(Client.ludoGame.getLblPawnRed3().getIcon() != null) Client.ludoGame.getLblPawnRed3().setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnRedTableEdge.png")));
				if(Client.ludoGame.getLblPawnRed4().getIcon() != null) Client.ludoGame.getLblPawnRed4().setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnRedTableEdge.png")));
				
				break;
			case CommandC.GREEN:
				if(Client.ludoGame.getLblPawnGreen1().getIcon() != null) Client.ludoGame.getLblPawnGreen1().setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnGreenTableEdge.png")));
				if(Client.ludoGame.getLblPawnGreen2().getIcon() != null) Client.ludoGame.getLblPawnGreen2().setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnGreenTableEdge.png")));
				if(Client.ludoGame.getLblPawnGreen3().getIcon() != null) Client.ludoGame.getLblPawnGreen3().setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnGreenTableEdge.png")));
				if(Client.ludoGame.getLblPawnGreen4().getIcon() != null) Client.ludoGame.getLblPawnGreen4().setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnGreenTableEdge.png")));
				
				break;
			default:
				break;
			}
			*/
			break;
		default:
			break;
		}
		
		if(isMovable(player.getPawns()[0], color, numberOnDice)) {
			switch(color) {
			case CommandC.BLUE:
				Client.ludoGame.getLblPawnBlue1().setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnBlueTableEdge.png")));
				if(Client.ludoGame.getLblPawnBlue1().getMouseListeners().length == 0) {
					Client.ludoGame.getLblPawnBlue1().addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							move(player.getPawns()[0], color, numberOnDice);
							Client.ludoGame.getLblPawnBlue1().setBounds(player.getPawns()[0].getCoordinatePawn_x(), player.getPawns()[0].getCoordinatePawn_y(), 65, 92);
							Client.ludoGame.getLblPawnBlue1().setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnBlueTable.png")));
							Client.ludoGame.getLblPawnBlue2().setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnBlueTable.png")));
							Client.ludoGame.getLblPawnBlue3().setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnBlueTable.png")));
							Client.ludoGame.getLblPawnBlue4().setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnBlueTable.png")));
						}
					});
				}
				break;
			case CommandC.YELLOW:
				Client.ludoGame.getLblPawnYellow1().setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnYellowTableEdge.png")));
				break;
			case CommandC.RED:
				Client.ludoGame.getLblPawnRed1().setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnRedTableEdge.png")));
				break;
			case CommandC.GREEN:
				Client.ludoGame.getLblPawnGreen1().setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnGreenTableEdge.png")));
				break;
			}
		}
		
		if(isMovable(player.getPawns()[1], color, numberOnDice)) {
			switch(color) {
			case CommandC.BLUE:
				Client.ludoGame.getLblPawnBlue2().setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnBlueTableEdge.png")));
				break;
			case CommandC.YELLOW:
				Client.ludoGame.getLblPawnYellow2().setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnYellowTableEdge.png")));
				break;
			case CommandC.RED:
				Client.ludoGame.getLblPawnRed2().setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnRedTableEdge.png")));
				break;
			case CommandC.GREEN:
				Client.ludoGame.getLblPawnGreen2().setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnGreenTableEdge.png")));
				break;
			}
		}
		
		if(isMovable(player.getPawns()[2], color, numberOnDice)) {
			switch(color) {
			case CommandC.BLUE:
				Client.ludoGame.getLblPawnBlue3().setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnBlueTableEdge.png")));
				break;
			case CommandC.YELLOW:
				Client.ludoGame.getLblPawnYellow3().setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnYellowTableEdge.png")));
				break;
			case CommandC.RED:
				Client.ludoGame.getLblPawnRed3().setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnRedTableEdge.png")));
				break;
			case CommandC.GREEN:
				Client.ludoGame.getLblPawnGreen3().setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnGreenTableEdge.png")));
				break;
			}
		}
		
		if(isMovable(player.getPawns()[3], color, numberOnDice)) {
			switch(color) {
			case CommandC.BLUE:
				Client.ludoGame.getLblPawnBlue4().setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnBlueTableEdge.png")));
				break;
			case CommandC.YELLOW:
				Client.ludoGame.getLblPawnYellow4().setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnYellowTableEdge.png")));
				break;
			case CommandC.RED:
				Client.ludoGame.getLblPawnRed4().setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnRedTableEdge.png")));
				break;
			case CommandC.GREEN:
				Client.ludoGame.getLblPawnGreen4().setIcon(new ImageIcon(LudoGame.class.getResource("/Resource/pawnGreenTableEdge.png")));
				break;
			}
		}
		

//		if(Client.game.getPlayerYou().getColor() == color) {
//			if(numberOnDice > 6) {
//				//klikni na kockicu
//			}
//			else {
//				//setuj kockicu na broj
//				switch(numberOnDice) {
//				case 1:
//					//slike 
//					break;
//				case 2:
//					break;
//				case 3:
//					break;
//				case 4:
//					break;
//				case 5:
//					break;
//				case 6:
//					break;
//				default:
//					break;
//				}
//			}
//		}
		// else {
		// setuj kockicu koja nije tvoje, pre toga proveri da je manje od 6
		// }

	}

}
