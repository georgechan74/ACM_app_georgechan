package com.example.acm_app_georgechan.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Hackathons {
    public List<Event> getEvents() { return events; }

    @SerializedName("array")
    List<Event> events;
}
