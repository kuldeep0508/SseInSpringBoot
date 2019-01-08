package jvmMemoryView.jvmMemoryView.api;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class MemoryInfo {
    private long heap;
    private  long nonHeap;
    private  LocalDateTime systemDate;

    public MemoryInfo(long heap, long nonHeap) {
        this.systemDate = LocalDateTime.now();
        this.heap = heap;
        this.nonHeap = nonHeap;
    }
}
