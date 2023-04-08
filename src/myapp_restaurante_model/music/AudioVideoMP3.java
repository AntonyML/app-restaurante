/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package music;

/**
 *
 * @author Tony ML
 */
import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;

public class AudioVideoMP3 extends Application {

    private boolean check = true;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() {
        music(check);
    }

    @Override
    public void start(Stage stage) throws Exception {
        music(check);
    }

    //reproducir musica
    public void music(boolean check) {
        File file = new File("D:\\Users\\Tony ML\\Documents\\NetBeansProjects\\ProyectoCompa\\src\\Música\\DoomMusic.mp3");
        Media media = new Media(file.toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);

        if (check) {
            mediaPlayer.play();
        } else {
            mediaPlayer.stop();
        }

    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
    
    

}
