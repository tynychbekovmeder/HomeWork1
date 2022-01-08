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


public class AutoBase1 {
    public static final GsonBuilder BUILDER = new GsonBuilder();
    public static final Gson GSON = BUILDER.setPrettyPrinting().create();
    public static final Path WRITE_PATH = Paths.get("./autoBase.json");

    public static void read() {
        InformationOfDriver1[] informationOfDriver1s = {
                new InformationOfDriver1(1, "Renault Magnum", "", "base"),
                new InformationOfDriver1(2, "Volvo", "", "base"),
                new InformationOfDriver1(3, "DAF XT", "", "base")
        };
        String gson = GSON.toJson(informationOfDriver1s);
        AutoBase1.writeJson(gson);
    }

    public static void parsing() throws IOException {
        String data = new String(Files.readAllBytes(Paths.get("C:\\Users\\User\\IdeaProjects\\JsonProject\\autoBase.json")));
        JSONArray jsonArray = new JSONArray(data);
        List<InformationOfDriver1> list = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String string = jsonArray.get(i).toString();
            JSONObject jsonObject1 = new JSONObject(string);
            int id = jsonObject1.getInt("id");
            String name = jsonObject1.getString("name");
            String driver = jsonObject1.getString("driver");
            String state = jsonObject1.getString("state");
            InformationOfDriver1 informationOfDriver1 = new InformationOfDriver1(id, name, driver, state);
            list.add(informationOfDriver1);
        }
        for (InformationOfDriver1 informationOfDriver1 : list) {
            System.out.print(informationOfDriver1.getId() + "  |");
            System.out.printf("%15s", informationOfDriver1.getName() + "|");
            System.out.print("        |");
            System.out.printf("%5s", informationOfDriver1.getState() + "    |");
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
