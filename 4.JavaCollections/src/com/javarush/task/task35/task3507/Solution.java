package com.javarush.task.task35.task3507;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
ClassLoader - что это такое?
*/
public class Solution {
    public static void main(String[] args) {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        Set<Animal> animals = new HashSet<>();

        File dir = new File(pathToAnimals);
        File[] files = dir.listFiles();

        for (File f : files) {
            if (f.isFile() && f.getName().endsWith(".class")) {
                String packageName = Solution.class.getPackage().getName() + ".data";
                Class clazz = new ClassLoaderFromPath().load(f.toPath(), packageName);


                Class[] interfaces = clazz.getInterfaces();
                for (Class i : interfaces) {
                    if (i.getSimpleName().equals("Animal")) {
                        Constructor[] constructors = clazz.getConstructors();
                        for (Constructor c : constructors) {
                            if (c.getParameterCount() == 0) {
                                try {
                                    animals.add((Animal) c.newInstance());
                                } catch (InstantiationException e) {
                                    e.printStackTrace();
                                } catch (IllegalAccessException e) {
                                    e.printStackTrace();
                                } catch (InvocationTargetException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }


            }
        }
        return animals;
    }

    public static class ClassLoaderFromPath extends ClassLoader {

        public Class<?> load(Path path, String packageName) {
            try {
                String className = packageName + "." + path.getFileName().toString().replace(".class", "");
                byte[] b = Files.readAllBytes(path);
                return defineClass(className, b, 0, b.length);
            } catch (IOException e) {
                e.printStackTrace();
            }


            return null;
        }
    }
}


