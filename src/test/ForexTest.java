import org.junit.Test;
import quickfix.Application;
import quickfix.ApplicationAdapter;
import quickfix.SessionID;

public class ForexTest {
    @Test
    public void testCreateLogin(){
        String beginStr = "str";
        String sender = "sender";
        String target = "target";

        SessionID sessionID = new SessionID(beginStr, sender, target);

        Application application = new ApplicationAdapter();
        application.onLogon(sessionID);
    }
}
