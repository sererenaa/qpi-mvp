package com.qpi.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Created by pingp on 6/1/2018.
 */
public interface DatabaseHandlerAsync {
    void validateLogin(String user, String pw, AsyncCallback<String> callback);
}
