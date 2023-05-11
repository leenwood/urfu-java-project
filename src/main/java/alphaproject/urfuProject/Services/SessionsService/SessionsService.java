package alphaproject.urfuProject.Services.SessionsService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

public class SessionsService {
    public ArrayList<Session> Sessions;

    public SessionsService() {
        this.Sessions = new ArrayList<Session>();
    }

    public void deleteSession(Session session) {
        Sessions.remove(session);
    }

    public void addSession(Session session) {
        Sessions.add(session);
    }

    public Session getSessionById(String id) {
        return Sessions.stream().filter(x -> Objects.equals(x.getSessionId(), id)).toList().get(0);
    }

    public Session getSessionByName(String name) {
        return Sessions.stream().filter(x -> Objects.equals(x.getName(), name)).toList().get(0);
    }

    public int getSessionPage(String id) {
        return getSessionById(id).getPage();
    }


}
