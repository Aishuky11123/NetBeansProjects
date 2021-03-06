
import java.io.IOException;

public class RevealCurrentTrack implements Runnable
{
    public void run()
    {
        try
        {
            Runtime rt = Runtime.getRuntime();
            String[] args = { "osascript",
                              "-e",
                              //"tell app \"iTunes\" to play"
                              //"tell app \"iTunes\" to pause"
                              //"tell app \"iTunes\" to set sound volume to 100"
                              //"tell app \"iTunes\" to set sound volume to sound volume - 5"
                              //"tell app \"iTunes\" to set sound volume to sound volume + 5"
                              //"tell app \"iTunes\" to previous track"
                              "tell app \"iTunes\" to reveal current track"
                              //"tell app \"iTunes\" to playpause"
                            };
            Process proc = rt.exec(args);
	} catch (IOException ex)
                {
                    System.out.println("exception : " + ex.getMessage());
                    ex.printStackTrace();
		}
    }
}



