package audio;
//hii
import javax.sound.sampled.*;
import java.io.*;

public class PlayAudio {

    public static void main(String[] args) {

        File audioFile = new File("audio1.wav");

        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

            AudioFormat format = audioStream.getFormat();

            DataLine.Info info = new DataLine.Info(Clip.class, format);

            Clip audioClip = (Clip) AudioSystem.getLine(info);

            audioClip.open(audioStream);

            audioClip.start();

            while (!audioClip.isRunning())
                Thread.sleep(10);
            while (audioClip.isRunning())
                Thread.sleep(10);

            audioClip.close();

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
            System.out.println("Error playing audio file.");
            e.printStackTrace();
        }
    }
}
