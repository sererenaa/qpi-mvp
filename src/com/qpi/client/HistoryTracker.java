package com.qpi.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

import java.awt.*;

/**
 * Created by Serena on 6/11/2018.
 */
public class TrackHistory implements EntryPoint, ValueChangeHandler<String>{
    private Label lbl = new Label();

    public void onModuleLoad() {
        // Create three hyperlinks that change the application's history.
        Hyperlink link0 = new Hyperlink("link to foo", "foo");
        Hyperlink link1 = new Hyperlink("link to bar", "bar");
        Hyperlink link2 = new Hyperlink("link to baz", "baz");

        // If the application starts with no history token, redirect to a new
        // 'baz' state.

        String initToken = History.getToken();
        if (initToken.length() == 0) {
            History.newItem("baz");
        }

        // Add widgets to the root panel.
        VerticalPanel panel = new VerticalPanel();
        panel.add((IsWidget) lbl);
        panel.add(link0);
        panel.add(link1);
        panel.add(link2);
        RootPanel.get().add(panel);

        // Add history listener
        History.addValueChangeHandler(this);

        // Now that we've setup our listener, fire the initial history state.
        History.fireCurrentHistoryState();
    }

    public void onValueChange(ValueChangeEvent<String> event) {
        // This method is called whenever the application's history changes. Set
        // the label to reflect the current history token.
        lbl.setText("The current history token is: " + event.getValue());
    }

}
