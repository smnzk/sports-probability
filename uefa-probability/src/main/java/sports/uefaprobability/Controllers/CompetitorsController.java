package sports.uefaprobability.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sports.uefaprobability.Services.CompetitorService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/competitors")
public class CompetitorsController {

    private final CompetitorService competitorService;

    @Autowired
    public CompetitorsController(CompetitorService competitorService) {
        this.competitorService = competitorService;
    }

    @GetMapping
    public List<String> getAllCompetitorsNamesAlphabetically(@RequestParam(defaultValue = "UEFA Champions League") String competitionName) throws IOException {
        return competitorService.getAllCompetitorNamesAlphabetically(competitionName);
    }
}
