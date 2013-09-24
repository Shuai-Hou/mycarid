package com.guxuede.myca.socket;
import org.eclipse.jetty.websocket.server.WebSocketServerFactory;
import org.eclipse.jetty.websocket.servlet.WebSocketServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;




public class ChatWebSocketServlet extends WebSocketServlet{

	private static final long serialVersionUID = -1512490379106861382L;


	@Override
	public void configure(WebSocketServletFactory arg0) {
		//arg0.getPolicy().setIdleTimeout(idleTimeout);
		arg0.register(MyEchoSocket.class);
	}

}
