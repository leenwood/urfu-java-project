package alphaproject.urfuProject.Services.SessionsService;

import java.util.Stack;

public class Session {
    private final String sessionId;
    private String name;
    private int page;
    private Stack<String> searchHistory;

    public Session(String sessionId, String name) {
        this.sessionId = sessionId;
        this.name = name;
        this.page = 0;
        this.searchHistory = new Stack<>();
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

    public String getSearchHistoryString() {
        StringBuilder sb = new StringBuilder();
        this.searchHistory.forEach(x -> {
            sb.append(x);
            sb.append('\n');
        });
        return sb.toString();
    }

    public Stack<String> getSearchHistory() {
        return this.searchHistory;
    }

    public void setSearchHistory(Stack<String> searchHistory) {
        this.searchHistory = searchHistory;
    }
}
