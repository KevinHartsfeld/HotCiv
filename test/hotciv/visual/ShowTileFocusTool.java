package hotciv.visual;

import java.awt.Point;

import hotciv.factory.DeltaFactory;
import hotciv.factory.SemiFactory;
import hotciv.framework.Game;
import hotciv.standard.GameImpl;
import hotciv.tool.TileFocusTool;
import hotciv.view.CityFigure;
import hotciv.view.GfxConstants;
import minidraw.framework.DrawingEditor;
import minidraw.standard.MiniDrawApplication;

public class ShowTileFocusTool {
	public static void main(String[] args) {
		Game game = new GameImpl(new DeltaFactory());

		DrawingEditor editor = 
				new MiniDrawApplication( "HotCiv world map, show tile focus tool!!!!!!!!!",  
						new HotCivFactory4(game) );
		editor.open();

		editor.setTool( new TileFocusTool(game, editor));
	}
}
