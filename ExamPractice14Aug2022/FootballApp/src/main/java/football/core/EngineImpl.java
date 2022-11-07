package football.core;

import football.common.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EngineImpl implements Engine{
    private Controller controller;
    private BufferedReader reader;

    public EngineImpl() {
        this.controller = new ControllerImpl();
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run() {
        while (true) {
            String result = null;
            try {
                result = processInput();

                if (result.equals("Exit")) {
                    break;
                }
            } catch (NullPointerException | IllegalArgumentException | IllegalStateException | IOException e) {
                result = e.getMessage();
            }

            System.out.println(result);
        }
    }
    private String processInput() throws IOException {
        String input = this.reader.readLine();
        String[] tokens = input.split("\\s+");

        Command command = Command.valueOf(tokens[0]);
        String result = null;
        String[] data = Arrays.stream(tokens).skip(1).toArray(String[]::new);

        switch (command) {
            case AddField:
                result = addField(data);
                break;
            case DeliverySupplement:
                result = deliverySupplement(data);
                break;
            case SupplementForField:
                result = supplementForField(data);
                break;
            case AddPlayer:
                result = addPlayer(data);
                break;
            case DragPlayer:
                result = dragPlayer(data);
                break;
            case CalculateStrength:
                result = calculateStrength(data);
                break;
            case GetStatistics:
                result = getStatistics();
                break;
            case Exit:
                result = Command.Exit.name();
                break;
        }
        return result;
    }
    private String addField(String[] data) {
        String fieldType = data[0];
        String fieldName = data[1];
        String result = controller.addField(fieldType, fieldName);
        return result;
    }

    private String deliverySupplement(String[] data) {
        String result = controller.deliverySupplement(data[0]);
        return result;
    }

    private String supplementForField(String[] data) {
        String fieldName = data[0];
        String supplementType = data[1];
        String result = controller.supplementForField(fieldName, supplementType);
        return result;
    }

    private String addPlayer(String[] data) {
        String fieldName = data[0];
        String playerType = data[1];
        String playerName = data[2];
        String playerNationality = data[3];
        int playerStrength = Integer.parseInt(data[4]);
        String result = controller.addPlayer(fieldName, playerType, playerName, playerNationality, playerStrength);
        return result;
    }

    private String dragPlayer(String[] data) {
        String result = controller.dragPlayer(data[0]);
        return result;
    }

    private String calculateStrength(String[] data) {
        String result = controller.calculateStrength(data[0]);
        return result;
    }

    private String getStatistics() {
        String result = controller.getStatistics();
        return result;
    }
}
