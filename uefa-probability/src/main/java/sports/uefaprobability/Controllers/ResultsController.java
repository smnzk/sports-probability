package sports.uefaprobability.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sports.uefaprobability.Models.Event;
import sports.uefaprobability.Models.Result;
import sports.uefaprobability.Services.EventService;
import sports.uefaprobability.Services.ResultService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/results")
public class ResultsController {

    private final EventService eventService;
    private final ResultService resultService;

    @Autowired
    public ResultsController(EventService eventService, ResultService resultService){
        this.eventService = eventService;
        this.resultService = resultService;
    }

    @GetMapping
    public List<Result> getMostProbableResults() throws IOException {
        return resultService.getMostProbableResults(eventService.getMostProbable());
    }
}
