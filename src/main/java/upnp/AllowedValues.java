package upnp;

import org.fourthline.cling.binding.AllowedValueRangeProvider;

/**
 * Created by comkostiuk on 11/04/2017.
 */
public class AllowedValues implements AllowedValueRangeProvider {

    @Override
    public long getMinimum() {
        return 0;
    }

    @Override
    public long getMaximum() {
        return 100;
    }

    @Override
    public long getStep() {
        return 1;
    }
}
