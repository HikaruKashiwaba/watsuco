package jp.co.ugatria.base.multipart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultiPartParam {

    Map<String, Object> param;

    Map<String, byte[]> data;

    public MultiPartParam() {
        param = new HashMap<String, Object>();
        data = new HashMap<String, byte[]>();
    }

    private Object get(String name) {
        return param.get(name);
    }

    void setParameter(String name, String value) {
        if (param.containsKey(name)) {
            Object o = get(name);
            if (o != null) {
                if (o instanceof List<?>) {
                    List<String> list = cast(o);
                    list.add(value);
                }
                else if (o instanceof String) {
                    List<String> list = new ArrayList<String>();
                    list.add((String)o);
                    list.add(value);
                    param.put(name, list);
                }
            }
        }
        else {
            param.put(name, value);
        }
    }

    public String getParameter(String name) {
        Object o = get(name);
        if (o != null) {
            if (o instanceof List) {
                List<String> params = cast(o);
                return params.get(0);
            }
            else if (o instanceof String) {
                return (String)o;
            }
        }
        return null;
    }


    public List<String> getParameterValues(String name) {
        Object o = get(name);
        if (o != null) {
            if (o instanceof List) {
                List<String> params = cast(o);
                return params;
            }
            else if (o instanceof String) {
                List<String> list = new ArrayList<String>();
                list.add((String)o);
                return list;
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
	private List<String> cast(Object o) {
    	return (List<String>)o;
    }

    public byte[] getFileData(String name) {
        return data.get(name);
    }

    void setFileData(String name, byte[] value) {
        data.put(name, value);
    }
}
