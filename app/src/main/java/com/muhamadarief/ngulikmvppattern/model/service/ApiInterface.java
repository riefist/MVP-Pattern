package com.muhamadarief.ngulikmvppattern.model.service;

import com.muhamadarief.ngulikmvppattern.model.EmployeeModel;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by riefist on 12/19/17.
 */

public interface ApiInterface {

    @GET("/")
    Call<EmployeeModel> getEmployee();

}
