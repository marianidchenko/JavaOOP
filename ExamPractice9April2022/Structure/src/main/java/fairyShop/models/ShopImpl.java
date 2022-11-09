package fairyShop.models;

import java.util.List;
import java.util.stream.Collectors;

public class ShopImpl implements Shop{
    @Override
    public void craft(Present present, Helper helper) {
        List<Instrument> workingInstruments = helper.getInstruments().stream().filter(i -> i.getPower() > 0)
                .collect(Collectors.toList());
        while (workingInstruments.size() > 0 && helper.canWork()) {
            present.getCrafted();
            helper.work();
            workingInstruments.get(0).use();
            if (workingInstruments.get(0).isBroken()) {
                workingInstruments.remove(0);
            }
            if (present.isDone()) {
                break;
            }
        }
    }
}
