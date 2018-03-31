package com.wy.tests.util;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultIndenter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
public abstract class JsonUtils {
	private static final ObjectMapper m = new ObjectMapper();
    private static final ObjectWriter w;

    public JsonUtils() {
    }

    private static ObjectWriter createObjectWriter() {
        DefaultPrettyPrinter prettyPrinter = new DefaultPrettyPrinter();
        prettyPrinter.indentArraysWith(DefaultIndenter.SYSTEM_LINEFEED_INSTANCE);
        return m.writer(prettyPrinter);
    }

    public static final String toJson(Object bean) {
        try {
            return m.writeValueAsString(bean);
        } catch (Throwable var2) {
            throw new JsonUtils.JsonException(var2);
        }
    }

    public static final <T> T toBean(String json, Class<T> clazz) {
        try {
            return m.readValue(json, clazz);
        } catch (Throwable var3) {
            throw new JsonUtils.JsonException(var3);
        }
    }

    public static final <T> T toBean(String json, JsonUtils.TypeRef<T> ref) {
        try {
            return m.readValue(json, ref);
        } catch (Throwable var3) {
            throw new JsonUtils.JsonException(var3);
        }
    }

    static {
        m.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        m.configure(Feature.ALLOW_COMMENTS, true);
        w = createObjectWriter();
    }

    private static class JsonException extends RuntimeException {
        private static final long serialVersionUID = 1L;

        private JsonException(Throwable cause) {
            super(cause);
        }
    }

    public abstract static class PrettyPrinter {
        public PrettyPrinter() {
        }

        public static final String toJson(Object bean) {
            try {
                return JsonUtils.w.writeValueAsString(bean);
            } catch (Throwable var2) {
                throw new JsonUtils.JsonException(var2);
            }
        }
    }

    public abstract static class TypeRef<T> extends TypeReference<T> {
        public TypeRef() {
        }
    }
}
