package com.muhamadarief.ngulikmvppattern.model;

import java.util.ArrayList;

/**
 * Created by riefist on 1/4/18.
 */

public class EmployeeModel {
    private ArrayList<Data> data;

    public ArrayList<Data> getData() {
        return data;
    }

    public static class Data {
        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }
}
