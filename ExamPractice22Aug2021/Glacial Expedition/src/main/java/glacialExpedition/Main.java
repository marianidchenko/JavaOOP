package glacialExpedition;

import glacialExpedition.core.Controller;
import glacialExpedition.core.ControllerImpl;
import glacialExpedition.core.Engine;
import glacialExpedition.core.EngineImpl;
import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.explorers.GlacierExplorer;
import glacialExpedition.models.mission.Mission;
import glacialExpedition.models.mission.MissionImpl;
import glacialExpedition.models.states.State;
import glacialExpedition.models.states.StateImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();

//        Explorer pesho = new GlacierExplorer("Pehso");
//        Explorer gosho = new GlacierExplorer("Gosho");
//        Mission mission = new MissionImpl();
//        State state = new StateImpl("state");
//        state.getExhibits().add("ex1");
//        state.getExhibits().add("ex2");
//        state.getExhibits().add("ex3");
//        List<Explorer> explorers = new ArrayList<>();
//        explorers.add(gosho);
//        explorers.add(pesho);
//        mission.explore(state, explorers);

    }
}
