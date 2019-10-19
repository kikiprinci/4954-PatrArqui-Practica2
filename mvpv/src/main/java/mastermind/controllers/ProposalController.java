package mastermind.controllers;

import java.util.List;

import mastermind.models.Session;
import mastermind.types.Color;
import mastermind.views.console.GameView;
import mastermind.views.console.ProposedCombinationView;

public class ProposalController extends Controller {

	public ProposalController(Session session) {
		super(session);
	}

	@Override
	public void control() {
		ProposedCombinationView proposedCombinationView = new ProposedCombinationView();
		List<Color> colors = proposedCombinationView.read();
		this.session.addProposedCombination(colors);
		new GameView().write(session);
		new GameView().checkResult(session);
	}

}
