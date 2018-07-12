package com.exadel.meetup.process;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.CompletableFuture;

public class ProcessHandlerDemo {

    private void listAllProcesses() {
        ProcessHandle.allProcesses()
                .filter(ProcessHandle::isAlive)
                .forEach(this::dumpProcessInfo);
    }

    private void dumpProcessInfo(ProcessHandle ph) {
        System.out.println("PROCESS INFORMATION");
        System.out.println("===================");
        System.out.printf("Process id: %d%n", ph.pid());

        ProcessHandle.Info info = ph.info();

        System.out.printf("Command: %s%n", info.command().orElse(""));

        String[] args = info.arguments().orElse(new String[]{});
        System.out.println("Arguments:");
        for (String arg : args) {
            System.out.printf("   %s%n", arg);
        }

        System.out.printf("Command line: %s%n", info.commandLine().orElse(""));
        System.out.printf("Start time: %s%n", info.startInstant().orElse(Instant.now()).toString());
        System.out.printf("Run time duration: %sms%n", info.totalCpuDuration().orElse(Duration.ofMillis(0)).toMillis());
        System.out.printf("Owner: %s%n", info.user().orElse(""));
        System.out.println();
    }

    private void demoActionOnTerminating() {
        try {
            Process process = new ProcessBuilder("notepad.exe").start();
            ProcessHandle processHandle = process.toHandle();
            CompletableFuture<ProcessHandle> onExitHandler = processHandle.onExit();
            onExitHandler.get();
            onExitHandler.thenAccept(ph -> System.out.printf("PID %d terminated%n", ph.pid()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ProcessHandlerDemo processHandlerDemo = new ProcessHandlerDemo();
        processHandlerDemo.listAllProcesses();
        processHandlerDemo.demoActionOnTerminating();
    }
}
