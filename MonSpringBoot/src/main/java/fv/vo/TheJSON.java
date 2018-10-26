package fv.vo;

import com.alibaba.fastjson.JSON;

import java.util.List;

public class TheJSON {


    public TheJSON(String filename) {

        List<String> fileAttachName = JSON.parseArray(filename,String.class);
        com.alibaba.fastjson.JSONArray filenames = JSON.parseArray(filename);

    }
}
