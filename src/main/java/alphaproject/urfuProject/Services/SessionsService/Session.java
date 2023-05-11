package alphaproject.urfuProject.Services.SessionsService;

public class Session {
    private String sessionId;
    private String name;
    private int page;

    public Session(String sessionId, String name) {
        this.sessionId = sessionId;
        this.name = name;
        this.page = 0;
    }

    public String getSessionId() {
        return sessionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
