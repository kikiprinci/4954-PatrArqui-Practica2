package mastermind.controllers;

import mastermind.models.Session;
import mastermind.views.console.SecretCombinationView;
import mastermind.views.console.StartView;

public class StartController extends Controller {

	public StartController(Session session) {
		super(session);
	}

	@Override
	public void control() {
		StartView startView = new StartView();
		SecretCombinationView secretCombinationView = new SecretCombinationView();

		startView.write();
		secretCombinationView.write(this.session.getWidth());
		session.next();
	}

}
