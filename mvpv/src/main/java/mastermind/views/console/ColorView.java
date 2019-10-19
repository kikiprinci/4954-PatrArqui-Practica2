package mastermind.views.console;

import mastermind.types.Color;
import mastermind.utils.Console;

public class ColorView extends mastermind.views.ColorView {

	public ColorView(Color color) {
		super(color);
	}
	
	public void write() {
		new Console().write(ColorView.INITIALS[this.color.ordinal()]);
	}

}
