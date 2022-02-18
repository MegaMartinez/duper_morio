package mainApp;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Sound {

        void playMusic(){
            try {
                File audioFile;
                audioFile = new File("music\\overworld_2_start.wav");
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(audioFile);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                FloatControl volume = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
                clip.start();
                clip.drain();
                Thread.sleep(1);
                while(true){
                    if(!clip.isRunning()){
                        break;
                    }
                }
                volume.setValue(1.0f);
                audioFile = new File("music\\overworld_2_loop.wav");
                audioInput = AudioSystem.getAudioInputStream(audioFile);
                clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                clip.start();
                clip.drain();


            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    
    
}
