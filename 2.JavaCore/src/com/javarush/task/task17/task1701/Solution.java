package com.javarush.task.task17.task1701;

import java.util.ArrayList;
import java.util.List;

/* 
Заметки
*/

public class Solution {
    public static void main(String[] args) {
        NoteThread thread1 = new NoteThread();
        Thread t1 = new Thread(thread1);
        t1.start();

        NoteThread thread2 = new NoteThread();
        Thread t2 = new Thread(thread2);
        t2.start();
    }

    public static class Note {

        public static final List<String> notes = new ArrayList<>();

        public static void addNote(String note) {
            notes.add(0, note);
        }

        public static void removeNote(String threadName) {
            String note = notes.remove(0);
            if (note == null) {
                System.out.println("Другая нить удалила нашу заметку");
            } else if (!note.startsWith(threadName)) {
                System.out.println("Нить [" + threadName + "] удалила чужую заметку [" + note + "]");
            } else {
                System.out.println("Нить [" + threadName + "] удалила свою заметку [" + note + "]");
            }
        }
    }

    public static class NoteThread extends Thread {
        public void run() {
            for (int index = 0; index < 1000; index++) {
                Note.addNote(getName() + "-Note" + Integer.toString(index));
                try {
                    Thread.sleep(1);
                }
                catch (InterruptedException e) {
                    //System.out.println(e);
                }
                Note.removeNote(getName());
            }
        }
    }
}
