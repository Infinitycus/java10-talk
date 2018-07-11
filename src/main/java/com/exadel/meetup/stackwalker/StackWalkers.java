package com.exadel.meetup.stackwalker;

import static java.lang.StackWalker.Option.RETAIN_CLASS_REFERENCE;
import static java.util.stream.Collectors.toList;

import com.exadel.meetup.Annotations.After;
import com.exadel.meetup.Annotations.Before;

import java.util.List;

public class StackWalkers {

    public static void main(String[] args) {
        new StackWalkers().walk();
    }

    public void walk() {
        new Walker1().walk();
    }

    private class Walker1 {
        private void walk() {
            new WalkerFromException().walk();
            new WalkerFromSecurityManager().walk();
            new WalkerNew().walk();
        }
    }

    @Before
    private class WalkerFromException {
        private void walk() {
            System.out.println("Stack Walker - new Throwable().getStackTrace()");

            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            for (int i = 0; i < stackTrace.length; i++) {
                StackTraceElement stackTraceElement = stackTrace[i];
                String className = stackTraceElement.getClassName();
                String methodName = stackTraceElement.getMethodName();
                int lineNumber = stackTraceElement.getLineNumber();

                System.out.printf("[%s] %s : %s : %s\n", i, className, methodName, lineNumber);
            }
        }
    }

    @Before
    private class WalkerFromSecurityManager {
        private void walk() {
            System.out.println("Stack Walker - SecurityManager::getClassContext()");

            Class[] classStack = new CustomSecurityManager().getClassContext();
            for (int i = 0; i < classStack.length; i++) {
                Class clazz = classStack[i];
                String className = clazz.getSimpleName();

                System.out.printf("[%s] %s\n", i, className);
            }
        }

        class CustomSecurityManager extends SecurityManager {
            public Class[] getClassContext() {
                return super.getClassContext();
            }
        }
    }

    @After
    private class WalkerNew {
        private void walk() {
            System.out.println("Stack Walker - Java 9");

            StackWalker stackWalker = StackWalker.getInstance(RETAIN_CLASS_REFERENCE);
            System.out.println("The caller class: " + stackWalker.getCallerClass());

            stackWalker.forEach(frame -> {
                String className = frame.getClassName();
                String methodName = frame.getMethodName();
                int lineNumber = frame.getLineNumber();

                System.out.printf("%s : %s : %d\n", className, methodName, lineNumber);
            });

            List<StackWalker.StackFrame> frames = stackWalker.walk(stream ->
                    stream.dropWhile(frame -> frame.getClassName().startsWith("com.exadel.meetup"))
                            .collect(toList()));
            System.out.println(frames);
        }
    }
}
