package at.maymay.convertme.application.dal;

import com.activeandroid.serializer.TypeSerializer;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import at.maymay.convertme.application.core.model.Unit;

final public class ListTypeSerializer extends TypeSerializer {
    private static final Gson gson = new Gson();
    @Override
    public Class<?> getDeserializedType() {
        return List.class;
    }

    @Override
    public Class<?> getSerializedType() {
        return String.class;
    }

    @Override
    public String serialize(final Object data) {
        if (null == data) return null;
        final String json = gson.toJson(data);
        return json;
    }

    @Override
    public List<Unit> deserialize(final Object data) {
        if (null == data) return null;
        Type listType = new TypeToken<ArrayList<Unit>>(){}.getType();
        JsonParser jsonParser = new JsonParser();
        JsonArray jo = jsonParser.parse((String)data).getAsJsonArray();
        if (jo == null) return null;
        return new Gson().fromJson(jo, listType);
    }

}
