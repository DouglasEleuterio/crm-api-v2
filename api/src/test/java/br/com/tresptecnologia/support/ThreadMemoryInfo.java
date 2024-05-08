package br.com.tresptecnologia.support;

import lombok.extern.slf4j.Slf4j;

import java.lang.management.ClassLoadingMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.lang.management.ThreadMXBean;

@Slf4j
public class ThreadMemoryInfo {

    final ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
    final MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
    final ClassLoadingMXBean classLoadingMXBean = ManagementFactory.getClassLoadingMXBean();

    long classesLoadedBefore = 0L;
    long startTime = 0L;

    MemoryUsage memoryBefore;

    public void init() {
        this.memoryBefore = memoryMXBean.getHeapMemoryUsage();
        this.classesLoadedBefore = classLoadingMXBean.getTotalLoadedClassCount();
        this.startTime = threadMXBean.getCurrentThreadCpuTime();
    }

    public void log() {
        long endTime = threadMXBean.getCurrentThreadCpuTime();
        long executionTime = (endTime - startTime) / 1000000;  // Converter nanossegundos para milissegundos
        log.info("Tempo de execução: " + executionTime + " milissegundos");

        MemoryUsage memoryAfter = memoryMXBean.getHeapMemoryUsage();
        long classesLoadedAfter = classLoadingMXBean.getTotalLoadedClassCount();

        long memoryUsed = memoryAfter.getUsed() - memoryBefore.getUsed();
        long classesAllocated = classesLoadedAfter - classesLoadedBefore;

        log.info("Memória usada: " + memoryUsed + " bytes");
        log.info("Classes alocadas: " + classesAllocated);
    }

}
