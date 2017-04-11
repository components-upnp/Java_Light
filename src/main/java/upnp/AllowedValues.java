package upnp;

import org.fourthline.cling.binding.AllowedValueProvider;

/**
 * Created by comkostiuk on 11/04/2017.
 */
public class AllowedValues implements AllowedValueProvider {
    @Override
    public String[] getValues() {
        String[] allowedvalues = new String [101];

        for (int i = 0; i <= 100; i++)
            allowedvalues[i] = String.valueOf(i);

        return allowedvalues;
    }
}
