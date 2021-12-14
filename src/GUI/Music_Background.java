package GUI;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

/**
 * Music and Background class
 * for adding bgm and background image features during the game
 * @author Zuocheng Wang
 *
 */
public class Music_Background {
	String musicFileName;
	String backgroundFileName;
	String question_text;
	Clip music_clip;
	
	/**
	 * constructor of Music_Background class
	 * @param musicFileName
	 * @param backgroundFileName
	 */
	public Music_Background(String musicFileName, String backgroundFileName, String question_text) 
	{
		this.musicFileName = musicFileName;
		this.backgroundFileName = backgroundFileName;
		this.question_text = question_text;
		this.music_clip = null;
	}
	
	
	/**
	 * constructor of Music_Background class
	 * @param musicFileName
	 */
	public Music_Background(String musicFileName) 
	{
		this.musicFileName = musicFileName;
	}
	
	/**
	 * method of play music and adding background image
	 */
	public void play()
	{
		try 
		{
			File music_file = new File(this.musicFileName);
			AudioInputStream music = AudioSystem.getAudioInputStream(music_file);
			Clip music_clip = AudioSystem.getClip();
			this.music_clip = music_clip;
			music_clip.open(music);
			music_clip.start();
			music_clip.loop(Clip.LOOP_CONTINUOUSLY);
			
			ImageIcon background = new ImageIcon(backgroundFileName);
				
			JOptionPane.showMessageDialog(null,question_text,"Europe Champion League Soccer ball Manager",JOptionPane.INFORMATION_MESSAGE, background);
			music_clip.stop();
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * method of play music and add text only (no image)
	 */
	public void play_without_image()
	{
		try 
		{
			File music_file = new File(this.musicFileName);
			AudioInputStream music = AudioSystem.getAudioInputStream(music_file);
			Clip music_clip = AudioSystem.getClip();
			this.music_clip = music_clip;
			music_clip.open(music);
			music_clip.start();
			music_clip.loop(Clip.LOOP_CONTINUOUSLY);
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	
	/**
	 * method of play music and adding background image
	 */
	public void play_no_text()
	{
		try 
		{
			File music_file = new File(this.musicFileName);
			AudioInputStream music = AudioSystem.getAudioInputStream(music_file);
			Clip music_clip = AudioSystem.getClip();
			this.music_clip = music_clip;
			music_clip.open(music);
			music_clip.start();
			music_clip.loop(Clip.LOOP_CONTINUOUSLY);
			
			ImageIcon background = new ImageIcon(backgroundFileName);
				
			JOptionPane.showMessageDialog(null,null,"Europe Champion League Soccer ball Manager",JOptionPane.INFORMATION_MESSAGE, background);
			music_clip.stop();
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public Clip getMusicClip()
	{
		return this.music_clip;
	}
	
	public void music_only()
	{
		try 
		{
			File music_file = new File(this.musicFileName);
			AudioInputStream music = AudioSystem.getAudioInputStream(music_file);
			Clip music_clip = AudioSystem.getClip();
			this.music_clip = music_clip;
			music_clip.open(music);
			music_clip.start();
			music_clip.loop(Clip.LOOP_CONTINUOUSLY);
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void Stop()
	{
		this.music_clip.stop();
	}
	
}
