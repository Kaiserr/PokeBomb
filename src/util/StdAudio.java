package util;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;

public class StdAudio implements Runnable
{
    private boolean running = false;
    private Thread thread;

    public StdAudio()
    {
        this.start();
    }

    public void start()
    {
        if(running)
            return;
        this.thread = new Thread(this);
        this.running = true;
        this.thread.start();
    }

    //
    private static boolean playSong = false;
    private static AudioInputStream inputStream;
    private static String url;
    private static Clip clip;

    @Override
    public void run()
    {
        while(running)
        {
            if(inputStream == null && playSong)
            {
                this.playSong = false;
                try
                {
                	
                    this.inputStream = AudioSystem.getAudioInputStream(new File(url));
                    this.clip.open(inputStream);
                    this.clip.start();
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void playBackGround(String string) // call to play .wav file
    {
        if(clip != null)
        {
            clip.stop();
            clip.close();
        }
        try
        {
            clip = AudioSystem.getClip();
        }
        catch(LineUnavailableException e)
        {
            e.printStackTrace();
        }
        url = string + ".wav";
        playSong = true;
        inputStream = null;
    }

    public void disposeSound()
    {
        if(this.clip != null)
        {
            this.clip.stop();
            this.clip.close();
        }
        this.clip = null;
        this.playSong = false;
        this.inputStream = null;
       // this.thread.stop();
        
    }
    
}