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

public class AutoBase2 {
    public static final GsonBuilder BUILDER = new GsonBuilder();
    public static final Gson GSON = BUILDER.setPrettyPrinting().create();
    public static final Path WRITE_PATH = Paths.get("./autoBase2.json");

    public static void read() {
        InformationOfDriver2 []informationOfDriver2={
                new InformationOfDriver2("1", "Petr"),
                new InformationOfDriver2("2","Michael"),
                new InformationOfDriver2("3","John")
        };
        String gson = GSON.toJson(informationOfDriver2);
        AutoBase2.writeJson(gson);
    }
    static void writeJson(String object1) {
        try {
            Files.writeString(WRITE_PATH, object1, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void parsing() throws IOException {
        String data = new String(Files.readAllBytes(Paths.get("C:\\Users\\User\\IdeaProjects\\JsonProject\\autoBase2.json")));
        JSONArray jsonArray = new JSONArray(data);
        List<InformationOfDriver2> list = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String string = jsonArray.get(i).toString();
            JSONObject jsonObject2 = new JSONObject(string);
            String id = jsonObject2.getString("id");
            String name = jsonObject2.getString("name");
            InformationOfDriver2 informationOfDriver2 = new InformationOfDriver2(id, name);
            list.add(informationOfDriver2);
        }
        for (InformationOfDriver2 informationOfDriver2 : list) {
            System.out.print(informationOfDriver2.getId() + "  |");
            System.out.printf("%15s", informationOfDriver2.getName() + "|");
            System.out.print("        |");
            System.out.println();
        }
    }
}
