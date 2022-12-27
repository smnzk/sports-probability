package sports.uefaprobability.Services;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import sports.uefaprobability.Models.Competitor;
import sports.uefaprobability.Models.Event;
import sports.uefaprobability.Models.Venue;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class JsonReader {

    public List<Event> readJsonFile(String competitionName) throws IOException {
        String data = new String(Files.readAllBytes(Paths.get("BE_data.json")));
        JSONObject obj = new JSONObject(data);

        JSONArray jsonArray = obj.getJSONArray("Events");

        ArrayList<Event> events = new ArrayList<>();

        for(int i = 0; i < jsonArray.length(); i++) {

            JSONObject event = jsonArray.getJSONObject(i);

            if(!event.getString("competition_name").equals(competitionName)) {
                continue;
            }

            JSONArray competitors = event.getJSONArray("competitors");

            Venue venue;
            try {
                JSONObject vObj = event.getJSONObject("venue");
                venue = new Venue(
                        vObj.getString("id"),
                        vObj.getString("name"),
                        vObj.getInt("capacity"),
                        vObj.getString("city_name"),
                        vObj.getString("country_name"),
                        vObj.getString("map_coordinates"),
                        vObj.getString("country_code")
                );
            } catch (JSONException ignored) {
                venue = new Venue();
            }
            ArrayList<Competitor> c = new ArrayList<>();

            for (int j = 0; j < competitors.length(); j++) {
                JSONObject ob = competitors.getJSONObject(j);
                c.add(new Competitor(
                        ob.getString("id"),
                        ob.getString("name"),
                        ob.getString("country"),
                        ob.getString("country_code"),
                        ob.getString("abbreviation"),
                        ob.getString("qualifier"),
                        ob.getString("gender")
                ));
            }

            events.add(new Event(
                    event.getString("sport_event_id"),
                    event.getString("start_date"),
                    event.getString("sport_name"),
                    event.getString("competition_name"),
                    event.getString("competition_id"),
                    event.getString("season_name"),
                    c,
                    venue,
                    event.getDouble("probability_home_team_winner"),
                    event.getDouble("probability_draw"),
                    event.getDouble("probability_away_team_winner")
            ));
        }
        return events;
    }
}
