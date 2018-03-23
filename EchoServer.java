import java.io.*;
import java.net.*;

public class EchoServer
{
	public EchoServer(int portnum)
	{
	    try
		{
			server = new ServerSocket(portnum);
		}
		catch (Exception err)
		{
			System.out.println(err);
		}
	}

	public void serve()
	{
		try
		{
			while (true)
			{
				Socket s = new Socket("127.0.0.1", 9999);
				BufferedReader r = new BufferedReader(new InputStreamReader(s.getInputStream()));
				PrintWriter w = new PrintWriter(s.getOutputStream(), true);
				BufferedReader con = new BufferedReader(new InputStreamReader(System.in));
				String line;
				do
				{
					line = r.readLine();
					if ( line != null )
						System.out.println(line);
					line = con.readLine();
					w.println(line);
				}
				while ( !line.trim().equals("Ok") );
				client.close();
			}
		}
		catch (Exception err)
		{
			System.err.println(err);
		}
	}	
	public static void main(String[] args)
	{
		EchoServer s = new EchoServer(9999);
		s.serve();
	}

	private ServerSocket server;
}
