package com.guxuede.myca.socket;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.eclipse.jetty.util.Callback;
import org.eclipse.jetty.util.FutureCallback;
import org.eclipse.jetty.websocket.api.RemoteEndpoint;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.core.annotations.WebSocket;
import org.eclipse.jetty.websocket.core.api.WebSocketConnection;
import org.eclipse.jetty.websocket.core.api.WebSocketException;
import org.eclipse.jetty.websocket.core.api.WebSocketListener;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebSocket
public class MyEchoSocket implements
		org.eclipse.jetty.websocket.api.WebSocketListener {

	public static ConcurrentHashMap<String, List<MyEchoSocket>> rooms = new ConcurrentHashMap<String, List<MyEchoSocket>>();

	static {
		rooms.put("<a href='?room=大厅'>大厅</a>", new ArrayList<MyEchoSocket>());
		rooms.put("<a href='?room=厕所'>厕所</a>", new ArrayList<MyEchoSocket>());
		rooms.put("<a href='?room=卧室'>卧室</a>", new ArrayList<MyEchoSocket>());
		rooms.put("<a href='?room=厨房'>厨房</a>", new ArrayList<MyEchoSocket>());
		rooms.put("<a href='?room=二次元世界'>二次元世界</a>", new ArrayList<MyEchoSocket>());
	}

	public String name;
	public String room;
	public String avatar;
	private Session session;

	public void onWebSocketText(String msg) {
		String message = msg.toString();
		broadcast(message);
		if (message.startsWith("@java")) {
			String req = message.substring(5).trim();
			if (req != null && !req.equals("")) {
				String sim = talkToSimsimi(req);
				systemBroadcast(name + "," + sim);
			}
		}
	}

	public void onWebSocketConnect(Session session) {
		System.out.println("Connect:"+this);
		this.session=session;
		Map<String, String[]> param = session.getUpgradeRequest().getParameterMap();
		String[] names = param.get("name");
		if (names != null && names.length > 0) {
			name = names[0];
		}
		String[] avatars = param.get("avatar");
		if (avatars != null && avatars.length > 0) {
			avatar = avatars[0];
		}
		String[] rs = param.get("room");
		if (rs != null && rs.length > 0) {
			room = rs[0];
		}
		if (name == null || "".equals(name) || "null".equals(name)) {
			name = "<span style='color:black'>" + "无名大侠("
					+ session.getRemoteAddress() + ")" + "</span>";
		} else {
			name = "<span style='color:green'>" + name + "</span>";
		}
		if (avatar == null || "".equals(avatar) || "null".equals(avatar)) {
			avatar = "../resources/img/avatar.jpg";
		} else {
			//avatar = "<span style='color:green'>" + avatar + "</span>";
		}
		if (room == null || "".equals(room) || "null".equals(room)) {
			room = "<a href='?room=大厅'>大厅</a>";
		} else {
			room = "<a href='?room=" + room + "'>" + room + "</a>";
		}

		if (rooms.containsKey(room)) {
			rooms.get(room).add(this);
		} else {
			rooms.put(room, new ArrayList<MyEchoSocket>());
			rooms.get(room).add(this);
		}
		systemBroadcast("欢迎 " + name + " 来到了" + room + ".");
		info();
	}

	public void onWebSocketClose(int statusCode, String reason) {
		try {
			session.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	System.out.println("close:"+rooms.get(room).remove(this));
    	System.out.println("close:"+rooms);
    	systemBroadcast(name+":"+"离开了"+room+".");
		info();
	}
	
	public void onWebSocketError(Throwable cause) {
		// TODO Auto-generated method stub

	}
	public void onWebSocketBinary(byte[] payload, int offset, int len) {
		// TODO Auto-generated method stub

	}


	private String talkToSimsimi(String msg) {
		// if(msg!=null){
		// return "断网了,暂时休息下";
		// }
		InputStreamReader reader = null;
		try {
			String us = "http://api.simsimi.com/request.p?key=a1156453-bd1d-4617-9783-a5ef440a4cef&lc=zh&ft=1.0&text="
					+ URLEncoder.encode(msg, "utf-8");
			System.out.println(us);
			URL u = new URL(us);
			URLConnection conn = u.openConnection();
			conn.setConnectTimeout(5000);
			conn.setReadTimeout(5000);
			reader = new InputStreamReader(conn.getInputStream(),"utf-8");
			SimsimiResponse res = new GsonBuilder().create().fromJson(reader,SimsimiResponse.class);
			System.out.println(res.getResponse());
			if (res.getResult() == 100) {
				return res.getResponse();
			} else if (res.getResult() == 404) {
				return "呃,无法理解(404)...";
			} else if (res.getResult() == 500) {
				return "救命,我的脑子崩溃了(500)...";
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			return "我脑子出异常(" + e.getCause() != null ? e.getCause().getClass().getName() : "2了" + ")了,暂时无法回应你...";
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "我脑子出异常了,暂时无法回应你...";
	}

	public void broadcast(String msg) {
		SMessage m=new SMessage();
		m.setName(name);
		m.setRoom(room);
		m.setMsg(msg);
		m.setAvatar(avatar);
		for (MyEchoSocket socket : rooms.get(room)) {
			socket.speack(m);
		}
	}
	
	public void systemBroadcast(String msg) {
		SMessage m=new SMessage();
		m.setName("JAVA");
		m.setRoom(room);
		m.setMsg(msg);
		m.setAvatar("../resources/img/java.jpg");
		for (MyEchoSocket socket : rooms.get(room)) {
			socket.speack(m);
		}
	}

	private void info() {
		int total = 0;
		Set<String> roomnames = rooms.keySet();
		StringBuilder sb = new StringBuilder();
		Iterator<String> i = roomnames.iterator();
		while (i.hasNext()) {
			String s = i.next();
			int size = rooms.get(s).size();
			total = total + size;
			sb.append(s).append("[").append(size).append("]");
			if (i.hasNext()) {
				sb.append(",");
			}
		}
		systemBroadcast("当前你所在的" + room + "共" + rooms.get(room) + ","
					+ rooms.get(room).size() + "人." + "共有" + sb.toString()
					+ roomnames.size() + "个房间,共" + total + "人."
					+ "我是管家 Java,如果有问题请 @java.");

	}
	
	private void speack(Object msg){
		if(session.isOpen()){
			RemoteEndpoint outbound = this.session.getRemote();
			try {
				String s=new Gson().toJson(msg);
				outbound.sendString(s);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	@Override
	public String toString() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((room == null) ? 0 : room.hashCode());
		result = prime * result + ((session == null) ? 0 : session.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyEchoSocket other = (MyEchoSocket) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (room == null) {
			if (other.room != null)
				return false;
		} else if (!room.equals(other.room))
			return false;
		if (session == null) {
			if (other.session != null)
				return false;
		} else if (!session.equals(other.session))
			return false;
		return true;
	}
	


	// private WebSocketConnection outbound;
	//
	// public void onWebSocketBinary(byte[] arg0, int arg1, int arg2) {
	// // TODO Auto-generated method stub
	//
	// }
	//
	// public void onWebSocketClose(int arg0, String arg1) {
	// // TODO Auto-generated method stub
	//
	// }
	//
	// public void onWebSocketConnect(WebSocketConnection connection) {
	// this.outbound = connection;
	// }
	//
	// public void onWebSocketException(WebSocketException arg0) {
	// // TODO Auto-generated method stub
	// arg0.printStackTrace();
	// }
	//
	// public void onWebSocketText(String message) {
	// if (outbound == null)
	// {
	// return;
	// }
	//
	// try
	// {
	// String context = null;
	// Callback callback = new FutureCallback();
	// outbound.write(context,callback,message);
	// }
	// catch (IOException e)
	// {
	// e.printStackTrace();
	// }
	// }

}