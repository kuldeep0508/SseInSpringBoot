package jvmMemoryView.jvmMemoryView.service;

import jvmMemoryView.jvmMemoryView.api.MemoryInfo;
import org.springframework.stereotype.Service;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

@Service
public class MemoryObserver {

    public MemoryInfo fetchMemoryInfo() {
        MemoryMXBean memBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heap = memBean.getHeapMemoryUsage();
        MemoryUsage nonHeap = memBean.getNonHeapMemoryUsage();

        return new MemoryInfo(heap.getUsed(), nonHeap.getUsed());
    }
}
