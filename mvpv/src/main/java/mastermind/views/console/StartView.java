package mastermind.views.console;

import mastermind.utils.WithConsoleView;
import mastermind.views.MessageView;

public class StartView extends WithConsoleView {

	public StartView() {
	}

	public void write() {
		this.console.writeln(MessageView.TITLE.getMessage());
	}

}
