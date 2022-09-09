
package jmusic;

import java.io.File;
import java.net.URL;
import javafx.util.Duration;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.TimerTask;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.management.timer.Timer;

public class SceneController implements Initializable {
    
    @FXML
    private Pane pane;
    @FXML
    private Label songLabel;
    @FXML
    private Button playButton, pauseButton, resetButton, previousButton, nextButton;
    @FXML
    private ComboBox<String> speedBox;
    @FXML
    private Slider volumeSlider;
    @FXML
    private ProgressBar songProgressBar;
    
    private Media media;
    private MediaPlayer mediaPlayer;
    
    private File directory;
    private File[] files;
    
    private ArrayList<File> songs;
    
    private int songNumber;
    private int[] speeds = {25, 50, 75, 100, 125, 150, 175, 200};
    private Timer timer;
    private TimerTask task;
    private boolean running;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        songs = new ArrayList<File>();
        directory = new File("Music");
        files = directory.listFiles();
        if(files != null) {
            for(File file: files) {
                songs.add(file);
                System.out.println(file);
            }
        }
        
        media = new Media(songs.get(songNumber).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        songLabel.setText(songs.get(songNumber).getName());
    }
    public void playMedia() {
        mediaPlayer.play();
    }
    public void pauseMedia() {
        mediaPlayer.pause();
    }
    public void resetMedia() {
        mediaPlayer.seek(Duration.seconds(0));
    }
    public void previousMedia() {
        
    }
    public void nextMedia() {
        if(songNumber < songs.size() - 1) {
            songNumber++;
            mediaPlayer.stop();
            media = new Media(songs.get(songNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(media);
            songLabel.setText(songs.get(songNumber).getName());
            playMedia();
        } else {
            songNumber = 0;
            songNumber++;
            mediaPlayer.stop();
            media = new Media(songs.get(songNumber).toURI().toString());
            mediaPlayer = new MediaPlayer(media);
            songLabel.setText(songs.get(songNumber).getName());
            playMedia();
        }
    }
    public void changeSpeed(ActionEvent event) {
        
    }
    public void beginTimer() {
        
    }
    public void cancelTimer() {
        
    }
}
