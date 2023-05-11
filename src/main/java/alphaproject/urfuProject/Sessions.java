package alphaproject.urfuProject;

import java.util.Collection;
import java.util.Objects;

public class Sessions {
    public Collection<Session> Sessions;

    public void deleteSession(Session session) {
        Sessions.remove(session);
    }

    public void addSession(Session session) {
        Sessions.add(session);
    }

    public Session getSessionById(String id) {
        return Sessions.stream().filter(x -> Objects.equals(x.SessionId, id)).toList().get(0);
    }

    public Session getSessionByName(String name) {
        return Sessions.stream().filter(x -> Objects.equals(x.Name, name)).toList().get(0);
    }

    public int getSessionPage(String id) {
        return getSessionById(id).Page;
    }


}
