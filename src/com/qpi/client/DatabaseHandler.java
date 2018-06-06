package com.qpi.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
/**
 * Created by pingp on 6/1/2018.
 */
@RemoteServiceRelativePath("db")
public interface DatabaseHandler extends RemoteService{
    String validateLogin(String user, String pw)
            throws Exception;
}
