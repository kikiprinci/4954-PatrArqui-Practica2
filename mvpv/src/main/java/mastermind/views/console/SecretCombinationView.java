package mastermind.views.console;

import mastermind.utils.WithConsoleView;
import mastermind.views.MessageView;

public class SecretCombinationView extends WithConsoleView {

	public SecretCombinationView() {
	}

	public void write(int width) {
		for (int i = 0; i < width; i++) {
			this.console.write(MessageView.SECRET.getMessage());
		}
		this.console.writeln();
	}

}
