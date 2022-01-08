package com.company;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;


public class JsonParser {
    public static final GsonBuilder BUILDER = new GsonBuilder();
    public static final Gson GSON = BUILDER.setPrettyPrinting().create();
    public static final Path WRITE_PATH = Paths.get("./autoBase.json");

    public static void read() {
        AutoBase[] autoBases = {
                new AutoBase(1, "Renault Magnum", "", "base"),
                new AutoBase(2, "Volvo", "", "base"),
                new AutoBase(3, "DAF XT", "", "base")
        };
        String gson = GSON.toJson(autoBases);
        JsonParser.writeJson(gson);
    }

    public static void parsing() throws IOException {
        String data = new String(Files.readAllBytes(Paths.get("C:\\Users\\User\\IdeaProjects\\JsonProject\\autoBase.json")));
        JSONArray jsonArray = new JSONArray(data);
        List<AutoBase> list = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String string = jsonArray.get(i).toString();
            JSONObject jsonObject1 = new JSONObject(string);
            int id = jsonObject1.getInt("id");
            String name = jsonObject1.getString("name");
            String driver = jsonObject1.getString("driver");
            String state = jsonObject1.getString("state");
            AutoBase autoBase = new AutoBase(id, name, driver, state);
            list.add(autoBase);
        }
        for (AutoBase autoBase : list) {
            System.out.print(autoBase.getId() + "  |");
            System.out.printf("%15s", autoBase.getName() + "|");
            System.out.print("        |");
            System.out.printf("%5s", autoBase.getState() + "    |");
            System.out.println();
        }
    }

    static void writeJson(String object1) {
        try {
            Files.writeString(WRITE_PATH, object1, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
