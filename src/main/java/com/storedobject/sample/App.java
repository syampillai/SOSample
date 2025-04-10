package com.storedobject.sample;

import com.storedobject.vaadin.*;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.router.Route;

public class App extends Application {

    @Override
    protected ApplicationLayout createLayout() {
        return new AppFrame();
    }

    private static class AppFrame extends ApplicationFrame {

        @Override
        public void drawMenu(Application application) {
            setCaption("Sample Application");
            addToNavbar(new SpeakerButton());
            ApplicationMenu menu = getMenu();
            ApplicationMenuItem ami;
            ami = application.createMenuItem("One", () -> Notification.show("Hello World!"));
            menu.add(ami);
            ami = application.createMenuItem("Two", () -> Notification.show("Hello World 2!"));
            menu.add(ami);
            ami = application.createMenuItem("Greeting", () -> {
                Application a = Application.get();
                a.speak("Hello, how are you?");
                if(!a.isSpeakerOn()) {
                    Notification.show("Speaker is off! Click on the speaker button to turn it on.");
                }
            });
            menu.add(ami);
        }
    }

    @Route("")
    public static class AppView extends ApplicationView {

        @Override
        protected Application createApplication() {
            return new App();
        }
    }
}
