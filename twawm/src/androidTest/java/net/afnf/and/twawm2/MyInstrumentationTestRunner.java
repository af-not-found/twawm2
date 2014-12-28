package net.afnf.and.twawm2;

import android.os.Bundle;
import android.test.InstrumentationTestRunner;

public class MyInstrumentationTestRunner extends InstrumentationTestRunner {

    @Override
    public void onCreate(Bundle arguments) {
        System.setProperty("dexmaker.dexcache", getTargetContext().getCacheDir().toString());
        arguments.putString("package", "com.appspot.afnf4199ga");
        super.onCreate(arguments);
    }
}