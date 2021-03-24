package com.javarush.task.task36.task3606;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/* 
Осваиваем ClassLoader и Reflection
*/
public class Solution {
    private List<Class> hiddenClasses = new ArrayList<>();
    private String packageName;

    public Solution(String packageName) {
        this.packageName = packageName;
    }

    public static void main(String[] args) throws ClassNotFoundException {
        Solution solution = new Solution(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "com/javarush/task/task36/task3606/data/second");
        solution.scanFileSystem();
        System.out.println(solution.getHiddenClassObjectByKey("secondhiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("firsthiddenclassimpl"));
        System.out.println(solution.getHiddenClassObjectByKey("packa"));
    }

    public void scanFileSystem() throws ClassNotFoundException {
        String prefix = packageName.substring(packageName.indexOf("com")).replaceAll("/", ".");
        File dir = new File(packageName);
        File[] files = dir.listFiles();

        for (File f : files) {
            String fileName = f.getName();
            if (f.isFile() && fileName.endsWith(".class")) hiddenClasses.add(Class.forName(prefix + "." + fileName.replaceAll("\\.class", "")));
        }
    }

    public HiddenClass getHiddenClassObjectByKey(String key) {
        if (key == null) return null;

        try {
            for (Class c : hiddenClasses) {
                if (c.getSimpleName().toLowerCase().startsWith(key.toLowerCase())) {
                    Constructor constructor = c.getDeclaredConstructor();
                    if (Modifier.isPrivate(constructor.getModifiers())) constructor.setAccessible(true);
                    if (constructor.getModifiers() == 0) constructor.setAccessible(true);
                    HiddenClass clazzForReturn = (HiddenClass) constructor.newInstance();
                    return clazzForReturn;
                }
            }
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {

        }

        return null;
    }
}

