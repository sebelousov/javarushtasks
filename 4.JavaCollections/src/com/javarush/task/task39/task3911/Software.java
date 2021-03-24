package com.javarush.task.task39.task3911;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Software {
    int currentVersion;

    private Map<Integer, String> versionHistoryMap = new LinkedHashMap<>();

    public void addNewVersion(int version, String description) {
        if (version > currentVersion) {
            versionHistoryMap.put(version, description);
            currentVersion = version;
        }
    }

    public int getCurrentVersion() {
        return currentVersion;
    }

    public Map<Integer, String> getVersionHistoryMap() {
        return Collections.unmodifiableMap(versionHistoryMap);
    }

    public boolean rollback(int rollbackVersion) {
        if (rollbackVersion < currentVersion && versionHistoryMap.containsKey(rollbackVersion)) {
            for (int i = rollbackVersion + 1; i <= currentVersion; i++) {
                versionHistoryMap.remove(i);
            }
            currentVersion = rollbackVersion;
            return true;
        }
        return false;
    }
}
