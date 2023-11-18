package com.cst2335.lab1;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private ListView entityListView;
    private List<Entity> entityList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the ListView in the layout
        entityListView = findViewById(R.id.entityListView);

        // Load JSON data from the assets folder
        loadJSONFromAsset();

        // Create an adapter and set it to the ListView
        EntityAdapter adapter = new EntityAdapter(this, entityList);
        entityListView.setAdapter(adapter);
    }

    // Method to load JSON data from the assets folder
    private void loadJSONFromAsset() {
        try {
            // Open and read the JSON file from assets
            InputStream is = getAssets().open("entities.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            // Convert the byte buffer to a String
            String jsonContent = new String(buffer, "UTF-8");

            // Parse the JSON array and create Entity objects
            JSONArray jsonArray = new JSONArray(jsonContent);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Entity entity = new Entity(
                        jsonObject.getInt("type"),
                        jsonObject.getString("name"),
                        jsonObject.getString("text_type"),
                        jsonObject.getString("description")
                );
                entityList.add(entity);
            }

        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }
}
