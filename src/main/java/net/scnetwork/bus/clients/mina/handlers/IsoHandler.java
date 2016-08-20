package net.scnetwork.bus.clients.mina.handlers;

import net.scnetwork.bus.utils.LogBus;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import java.util.Date;

/**
 * Разбор входящих пактов
 */
public class IsoHandler extends IoHandlerAdapter {
    /**
     * Обработка исключений
     * @param session сессия
     * @param cause исключение
     */
    @Override
    public void exceptionCaught(IoSession session, Throwable cause) {
        LogBus.writeLog((Exception) cause);
    }

    /**
     * Обработка сообщений
     * @param session сессия
     * @param message сообщение
     */
    @Override
    public void messageReceived(IoSession session, Object message){
        String str = message.toString();
        if ("quit".equalsIgnoreCase(str.trim())){
            session.closeNow();
            return;
        }

        Date date = new Date();
        session.write(date.toString());
    }

    /**
     * Простой сессии
     * @param session сессия
     * @param status статус
     */
    @Override
    public void sessionIdle(IoSession session, IdleStatus status){
        LogBus.info("MINA idle");
    }
}
