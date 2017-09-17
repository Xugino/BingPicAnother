package com.xugino.bingpicanother;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataResource {

    public List<Map<String,Object>> list;
    private DataAsyncTask myTask;

    public DataResource(){
        list=new ArrayList<>();
    }

    public List<Map<String,Object>> getList()
    {
        return list;
    }

    public void getData()
    {
        try{
            myTask = new DataAsyncTask();
            list.addAll(myTask.execute(0).get());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}