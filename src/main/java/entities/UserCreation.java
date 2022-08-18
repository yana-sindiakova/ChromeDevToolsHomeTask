package entities;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

import static com.google.gson.JsonParser.parseReader;

public class UserCreation {
    private String name;

    public UserCreation(String name) {
        this.name = name;
    }

    public User getUser() {
        User user = null;
        for (JsonElement jsonUser : getUsersJson()) {
            JsonObject userJsonObject = jsonUser.getAsJsonObject();
            if (userJsonObject.get("name").getAsString().equals(name)) {
                user = new User(userJsonObject.get("login").getAsString(),
                        userJsonObject.get("password").getAsString());
            }
        }
        return user;
    }

    private JsonArray getUsersJson() {
        File usersFile = new File("/Users/yanasindiakova/Documents/AutomationProjects/user.json");
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(usersFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        JsonArray jsonUsers = parseReader(new InputStreamReader(inputStream))
                .getAsJsonObject().get("users").getAsJsonArray();
        return jsonUsers;
    }
}
