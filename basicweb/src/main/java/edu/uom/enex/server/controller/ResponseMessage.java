package edu.uom.enex.server.controller;

/**
 * Created by Himashi Nethinika on 4/1/16.
 */

public class ResponseMessage {

    public static final ResponseMessage SUCCESS=new ResponseMessage("success", "200");
    public static final ResponseMessage WARN=new ResponseMessage("warn", "400");
    public static final ResponseMessage DANGER=new ResponseMessage("danger", "500");


    private final String text;
    private final String type;
    private Object data;


    private ResponseMessage(String type, String text) {
        this.type = type;
        this.text = text;
        this.data = data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getText() {
        return text;
    }

    public String getType() {
        return type;
    }

    public Object getData() {
        return data;
    }
}
