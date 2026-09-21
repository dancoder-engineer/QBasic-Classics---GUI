import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AudioPlayer {

    private File soundFile = new File("");
    private Clip clip;
    private boolean looping;
    private String folder = "";

    public AudioPlayer(boolean loop) {
        looping = loop;
        folder = (looping) ?".\\sound\\music\\" : ".\\sound\\sfx\\";
    }

    public void play(String name) {

        try {
            if(clip!= null) { 
                clip.stop();
                clip.close();
            }
            soundFile = new File(folder + name);
            AudioInputStream audio = AudioSystem.getAudioInputStream(soundFile);
            clip = AudioSystem.getClip();
            clip.open(audio);
            if(!looping) { clip.start(); }
                else { clip.loop(Clip.LOOP_CONTINUOUSLY); }
                
            


        } catch(Exception e) {
            System.out.println("Failed to play audio file " + name);
        }
    }

    public void stop() {
        if(clip!= null) { 
            clip.stop();
            clip.close();
            clip = null;
        }
    }

}
