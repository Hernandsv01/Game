package com.gamu.main;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioPlayer {
    
    private static Clip play;
    
    public static void playMenuSound(){
        try {

            AudioInputStream menuSound = AudioSystem.getAudioInputStream(new File("C:\\Hernan\\Proyectos\\Game\\res\\Wav\\Memory.wav"));

            play = AudioSystem.getClip();

            play.open(menuSound);

            FloatControl volume = (FloatControl) play.getControl(FloatControl.Type.MASTER_GAIN);

            volume.setValue(0.5f);

            play.loop(Clip.LOOP_CONTINUOUSLY);

        }catch (LineUnavailableException | IOException | UnsupportedAudioFileException e){
            e.printStackTrace();
        }
    }
    
    public static void playMenuClickSound(){
        try {

            AudioInputStream menuSound = AudioSystem.getAudioInputStream(new File("C:\\Hernan\\Proyectos\\Game\\res\\Wav\\ClickSound.wav"));

            play = AudioSystem.getClip();

            play.open(menuSound);

            FloatControl volume = (FloatControl) play.getControl(FloatControl.Type.MASTER_GAIN);

            volume.setValue(0.5f);

//            play.loop(Clip.LOOP_CONTINUOUSLY);

        }catch (LineUnavailableException | IOException | UnsupportedAudioFileException e){
            e.printStackTrace();
        }
    }

    public static void playEndSound(){
        try {

            AudioInputStream menuSound = AudioSystem.getAudioInputStream(new File("C:\\Hernan\\Proyectos\\Game\\res\\Wav\\Determination.wav"));

            play = AudioSystem.getClip();

            play.open(menuSound);

            FloatControl volume = (FloatControl) play.getControl(FloatControl.Type.MASTER_GAIN);

            volume.setValue(0.5f);

            play.loop(Clip.LOOP_CONTINUOUSLY);

        }catch (LineUnavailableException | IOException | UnsupportedAudioFileException e){
            e.printStackTrace();
        }
    }
    
    public static void playBossSound(){
        try {

            AudioInputStream menuSound = AudioSystem.getAudioInputStream(new File("C:\\Hernan\\Proyectos\\Game\\res\\Wav\\MetalCrusher.wav"));

            play = AudioSystem.getClip();

            play.open(menuSound);

            FloatControl volume = (FloatControl) play.getControl(FloatControl.Type.MASTER_GAIN);

            volume.setValue(0.5f);

            play.loop(Clip.LOOP_CONTINUOUSLY);

        }catch (LineUnavailableException | IOException | UnsupportedAudioFileException e){
            e.printStackTrace();
        }
    }

    public static void playGameSound(){

        try {

            AudioInputStream gameSound = AudioSystem.getAudioInputStream(new File("C:\\Hernan\\Proyectos\\Game\\res\\Wav\\Dummy.wav"));

            play = AudioSystem.getClip();

            play.open(gameSound);

            FloatControl volume = (FloatControl) play.getControl(FloatControl.Type.MASTER_GAIN);

            volume.setValue(1.0f);

            play.loop(Clip.LOOP_CONTINUOUSLY);

        }catch (LineUnavailableException | IOException | UnsupportedAudioFileException e){
            e.printStackTrace();
        }
    }

 

    public static void stopMusic(){
        play.close();
    }
}