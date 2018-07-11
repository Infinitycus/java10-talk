package com.exadel.meetup.version;

import com.exadel.meetup.Annotations.After;
import com.exadel.meetup.Annotations.Before;

public class VersionDemo {

    public static void main(String[] args) {
        new VersionDemo().demo();
    }

    private void demo() {
        System.out.println(new GetJavaVersionFromProperty().getJavaVersion());
        System.out.println(new GetJavaVersionFromRuntime().getJavaVersion());
    }

    @Before
    class GetJavaVersionFromProperty {
        public int getJavaVersion() {
            String[] javaVersionElements = System.getProperty("java.version").split("\\.");
            int major = Integer.parseInt(javaVersionElements[0]);
            if (major == 1) {
                return Integer.parseInt(javaVersionElements[1]);
            } else {
                return major;
            }
        }
    }

    @After
    class GetJavaVersionFromRuntime {
        public int getJavaVersion() {
            Runtime.Version version = Runtime.version();
            return version.feature();
        }
    }
}
