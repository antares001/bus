package net.scnetwork.bus;

import net.scnetwork.bus.clients.mina.handlers.IsoHandler;
import net.scnetwork.bus.config.Global;
import net.scnetwork.bus.providers.jpos.config.Jpos;
import net.scnetwork.bus.utils.LogBus;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

/**
 * Класс запуска сервера платежных систем
 */
@Component
public class MinaServer {
    @Autowired
    private Global global;

    /**
     * Запуск сервиса
     */
    @PostConstruct
    public void init(){
        Jpos jpos = global.getModules().getJpos();

        if (jpos.isUse()) {
            IoAcceptor acceptor = new NioSocketAcceptor();

            acceptor.getFilterChain().addLast("logger", new LoggingFilter());
            acceptor.getFilterChain().addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));

            acceptor.setHandler(new IsoHandler());
            acceptor.getSessionConfig().setReadBufferSize(jpos.getBufferSize());
            acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);
            try {
                acceptor.bind(new InetSocketAddress(jpos.getPort()));
            } catch (IOException e) {
                LogBus.writeLog(e);
            }
        }
    }
}
