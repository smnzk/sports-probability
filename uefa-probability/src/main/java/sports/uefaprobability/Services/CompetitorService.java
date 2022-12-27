package sports.uefaprobability.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sports.uefaprobability.Models.Competitor;
import sports.uefaprobability.Models.Event;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@Service
public class CompetitorService {

    private final JsonReader reader;

    @Autowired
    public CompetitorService(JsonReader reader) {
        this.reader = reader;
    }

    public List<String> getAllCompetitorNamesAlphabetically() throws IOException {
        HashSet<String> namesSet = new HashSet<>();

        for(Event e : reader.readJsonFile()) {
            for(Competitor c : e.getCompetitors()) {
                namesSet.add(c.getName());
            }
        }

        ArrayList<String> names = new ArrayList<>(namesSet);
        Collections.sort(names);

        for (String name : names) {
            System.out.println(name);
        }

        return names;
    }
}
