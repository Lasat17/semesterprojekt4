package dk.sdu.mmmi.cbse.commonmap;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        String t = "background_test_1";
        Map map = new Map(t);


    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {


    }
}
