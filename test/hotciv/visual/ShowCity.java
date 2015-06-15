package hotciv.visual;

import minidraw.standard.*;
import minidraw.framework.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import hotciv.framework.*;
import hotciv.framework.HotCivFactory;
import hotciv.view.*;
import hotciv.stub.*;

/** Test the CityFigure.
 * 
   This source code is from the book 
     "Flexible, Reliable Software:
       Using Patterns and Agile Development"
     published 2010 by CRC Press.
   Author: 
     Henrik B Christensen 
     Computer Science Department
     Aarhus University

   This source code is provided WITHOUT ANY WARRANTY either 
   expressed or implied. You may study, use, modify, and 
   distribute it for non-commercial purposes. For any 
   commercial use, see http://www.baerbak.com/
 */
public class ShowCity {

	public static void main(String[] args) {

		Game game = new StubGame1();

		DrawingEditor editor = 
				new MiniDrawApplication( "Click to see city graphics update...",  
						new HotCivFactory3(game) );
		editor.open();
		
		CityStub city = new CityStub();

		CityFigure cf = new CityFigure( city,
				new Point( GfxConstants.getXFromColumn(4),
						GfxConstants.getYFromRow(7) ) );
		editor.drawing().add(cf);
		editor.setTool( new ChangeCityTool(city, cf) );

	}
}

class ChangeCityTool extends NullTool {
	private CityStub city;
	private CityFigure cityFigure;
	public ChangeCityTool(CityStub c, CityFigure cf) {
		city = c;
		cityFigure = cf;
	}
	public void mouseDown(MouseEvent e, int x, int y) {
		city.makeAChange();
		cityFigure.changed();
	}
}

class HotCivFactory3 implements HotCivFactory, Factory {
	private Game game;
	public HotCivFactory3(Game g) { game = g; }

	public DrawingView createDrawingView( DrawingEditor editor ) {
		DrawingView view = 
				new MapView(editor, game);
		return view;
	}

	public Drawing createDrawing( DrawingEditor editor ) {
		return new StandardDrawing();
	}

	public JTextField createStatusField( DrawingEditor editor ) {
		return null;
	}

	public ActionStrategy getActionStrategy() {
		// TODO Auto-generated method stub
		return null;
	}

	public AgeStrategy getAgeStrategy() {
		// TODO Auto-generated method stub
		return null;
	}

	public SetupStrategy getSetupStrategy() {
		// TODO Auto-generated method stub
		return null;
	}

	public WinnerStrategy getWinnerStrategy() {
		// TODO Auto-generated method stub
		return null;
	}

	public AttackStrategy getAttackStrategy() {
		// TODO Auto-generated method stub
		return null;
	}

	public GrowthStrategy getGrowthStrategy() {
		// TODO Auto-generated method stub
		return null;
	}

	public ProductionStrategy getProductionStrategy() {
		// TODO Auto-generated method stub
		return null;
	}
}

// a test stub implementation just to 
// force some graphical updates.
class CityStub implements City {
	boolean redOwns = true;
	// a testing method just to make some
	// state changes
	public void  makeAChange() {
		redOwns = ! redOwns;
	}
	public Player getOwner() {
		return (redOwns ? Player.RED : Player.BLUE);
	}

	public int getSize() {
		return (redOwns ? 4 : 9);
	}
	public String getProduction() {
		return null;
	}
	public String getWorkforceFocus() {
		return null;
	}
	public void setSize(int size) {
		// TODO Auto-generated method stub
	}
	public void changeOwner(Player player) {
		// TODO Auto-generated method stub
	}
	public int getProductionAmount() {
		// TODO Auto-generated method stub
		return 0;
	}
	public void setProduction(String production) {
		// TODO Auto-generated method stub
	}
	public void addProduction(int amount) {
		// TODO Auto-generated method stub
	}
	public Unit produce() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setWorkforceFocus(String workFocus) {
		// TODO Auto-generated method stub
	}
	public int getFood() {
		// TODO Auto-generated method stub
		return 0;
	}
	public void addFood(int amount) {
		// TODO Auto-generated method stub
	}
	public void resetFood() {
		// TODO Auto-generated method stub
	}
}
