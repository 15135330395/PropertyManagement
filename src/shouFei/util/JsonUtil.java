package shouFei.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import shouFei.entity.PageBean;

import java.util.List;

/**
 * @Acthor:孙琪; date:2019/3/24;
 */
public class JsonUtil {

    public static <T> JSONObject getJsonObject(List<T> list , PageBean pageBean) {
        Object jsonArr = JSONArray.toJSON(list);
        JSONObject array=new JSONObject();
        array.put("code",0);
        array.put("msg","");
        array.put("count",pageBean.getCount());
        array.put("data",jsonArr);
        return array;
    }
}
