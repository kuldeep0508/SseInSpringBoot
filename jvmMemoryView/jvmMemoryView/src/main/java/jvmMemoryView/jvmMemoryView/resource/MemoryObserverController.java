package jvmMemoryView.jvmMemoryView.resource;

import jvmMemoryView.jvmMemoryView.api.MemoryInfo;
import jvmMemoryView.jvmMemoryView.service.MemoryObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class MemoryObserverController {

    @Autowired
    MemoryObserver memoryObserver;

    @GetMapping(value = "/memory" , produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<MemoryInfo> onMemoryInfo(){
         return  Flux.interval(Duration.ofSeconds(5))
                 .map(pulse -> memoryObserver.fetchMemoryInfo())
                 ;

    }
}
