package fairyShop.core;

import fairyShop.common.ConstantMessages;
import fairyShop.common.ExceptionMessages;
import fairyShop.models.*;
import fairyShop.repositories.HelperRepository;
import fairyShop.repositories.PresentRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller{
    private HelperRepository helperRepository = new HelperRepository();
    private PresentRepository presentRepository = new PresentRepository();
    private ShopImpl shop = new ShopImpl();

    @Override
    public String addHelper(String type, String helperName) {
        switch (type) {
            case "Happy":
                this.helperRepository.add(new Happy(helperName));
                break;
            case "Sleepy":
                this.helperRepository.add(new Sleepy(helperName));
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.HELPER_TYPE_DOESNT_EXIST);
        }
        return String.format(ConstantMessages.ADDED_HELPER, type, helperName);
    }

    @Override
    public String addInstrumentToHelper(String helperName, int power) {
        Helper helper = helperRepository.findByName(helperName);
        if (helper == null) {
            throw new IllegalArgumentException(ExceptionMessages.HELPER_DOESNT_EXIST);
        }
        helper.addInstrument(new InstrumentImpl(power));
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_INSTRUMENT_TO_HELPER, power, helperName);
    }

    @Override
    public String addPresent(String presentName, int energyRequired) {
        this.presentRepository.add(new PresentImpl(presentName, energyRequired));
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_PRESENT, presentName);
    }

    @Override
    public String craftPresent(String presentName) {

        List<Helper> suitableHelpers = this.helperRepository.getModels().stream().filter(h -> h.getEnergy() > 50)
                .collect(Collectors.toList());
        if (suitableHelpers.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.NO_HELPER_READY);
        }

        int brokenInstruments = 0;
        Present present = presentRepository.findByName(presentName);
        for (Helper helper : suitableHelpers) {
            shop.craft(present, helper);
            brokenInstruments += (int) helper.getInstruments().stream().filter(Instrument::isBroken).count();
            if (present.isDone()){
                break;
            }
        }
        if (present.isDone()) {
            return String.format(ConstantMessages.PRESENT_DONE, presentName, "done") +
                    String.format(ConstantMessages.COUNT_BROKEN_INSTRUMENTS, brokenInstruments);
        }
        return String.format(ConstantMessages.PRESENT_DONE, presentName, "not done") +
                String.format(ConstantMessages.COUNT_BROKEN_INSTRUMENTS, brokenInstruments);
    }

    @Override
    public String report() {
        int size = (int) presentRepository.getModels().stream().filter(Present::isDone).count();
        List<String> collect = helperRepository.getModels().stream().map(helper -> String.format("Name: %s%n" +
                        "Energy: %d%n" +
                        "Instruments: %d not broken left%n", helper.getName(), helper.getEnergy(),
                (int) helper.getInstruments().stream().filter(instrument -> !instrument.isBroken()).count())).collect(Collectors.toList());
        return String.format("%d presents are done!%n", size) + String.format("Helpers info:%n") + String.join("", collect).trim();
    }
}
