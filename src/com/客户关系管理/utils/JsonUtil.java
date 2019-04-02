package utils;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @Description JsonUtil
 * @Author 项目组
 * @CreateTime 2019-03-26 14:45
 */
public class JsonUtil {
    public static <T> JSONObject getJsonObject(List<T> list) {
        JSONObject table = new JSONObject();
        table.put("code", 0);
        table.put("msg", "");
        table.put("count", 0);
        table.put("data", list);
        return table;
    }
}
