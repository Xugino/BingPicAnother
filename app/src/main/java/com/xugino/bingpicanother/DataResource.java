package com.xugino.bingpicanother;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataResource {

    private List<Map<String,Object>> list;
    private DataAsyncTask myTask;

    public DataResource(){
        list=new ArrayList<>();
    }

    public List<Map<String,Object>> getData()
    {
        try{
            myTask = new DataAsyncTask();
            myTask.execute(0);
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}