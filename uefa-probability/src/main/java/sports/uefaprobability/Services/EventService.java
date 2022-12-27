package sports.uefaprobability.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sports.uefaprobability.Models.Event;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {

    private final JsonReader reader;

    @Autowired
    public EventService(JsonReader reader) {
        this.reader = reader;
    }

    public List<Event> getMostProbable(int amount, String competitionName) throws IOException {

        List<Event> events = reader.readJsonFile(competitionName);

        if(amount > events.size()) {
            amount = events.size();
        }

        events.sort((o1, o2) -> Double.compare(o2.getHighestProbability(), o1.getHighestProbability()));

        return events.stream().limit(amount).collect(Collectors.toList());

    }

}
