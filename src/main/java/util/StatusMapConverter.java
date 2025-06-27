package util;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.enums.Status;

@Converter
public class StatusMapConverter implements AttributeConverter<Map<Status, Float>, String> {
    private final Gson gson = new Gson();

    @Override
    public String convertToDatabaseColumn(Map<Status, Float> statusMap) {
        if (statusMap == null || statusMap.isEmpty()) {
            return "{}";
        }
        return gson.toJson(statusMap);
    }

    @Override
    public Map<Status, Float> convertToEntityAttribute(String json) {
        if (json == null || json.trim().equals("{}") || json.trim().isEmpty()) {
            return new HashMap<>();
        }
        try {
            return gson.fromJson(json, new TypeToken<Map<Status, Float>>() {
            }.getType());
        } catch (Exception e) {
            throw new IllegalArgumentException("Erro ao converter JSON para Map: " + json, e);
        }
    }
}