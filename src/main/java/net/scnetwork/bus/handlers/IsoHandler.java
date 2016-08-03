package net.scnetwork.bus.handlers;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import java.util.Date;

public class IsoHandler extends IoHandlerAdapter {
    @Override
    public void exceptionCaught(IoSession session, Throwable cause) {
        cause.printStackTrace();
    }

    @Override
    public void messageReceived(IoSession session, Object message){
        String str = message.toString();
        if (str.trim().equalsIgnoreCase("quit")){
            session.closeNow();
            return;
        }

        Date date = new Date();
        session.write(date.toString());
        System.out.println("Message written...");
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status){
        System.out.println( "IDLE " + session.getIdleCount( status ));
    }
}
