package matala4;
import java.awt.Color;
import ex4.geometry.*;
/**
 * This class is the "main" class which will be constructed and run as in (Test_Ex4).
 * Ex4: you should implement this class!
 * @author boaz.benmoshe
 *
 */
public class Ex4 implements Ex4_GUI {
	private GUI_Shape_Collection s_c;
	 String information;

	public Ex4() {             //constructor

		this.s_c = new Shape_Collection();
		this.information = "";
	}
//---------------------------------------------------------------------
	@Override
	public void init(GUI_Shape_Collection g) {;
	}
	
	@Override
	public GUI_Shape_Collection getShape_Collection() {
		return this.s_c;
	}

	@Override
	public void show() {;
	}

	@Override
	public String getInfo() {
		return this.information;
	}

}
