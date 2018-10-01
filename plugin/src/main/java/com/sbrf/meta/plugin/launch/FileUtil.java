package com.sbrf.meta.plugin.launch;

import com.sbrf.meta.plugin.dto.api.GAV;
import org.apache.maven.artifact.Artifact;
import org.apache.maven.project.MavenProject;

import java.io.File;
import java.util.*;

public class FileUtil {
    static Map<GAV, File> getJars(MavenProject project) {
        Map<GAV, File> result = new HashMap<>();
        for (Artifact artifact : project.getArtifacts()) {
            File file = artifact.getFile();
            if (file == null)
                continue;
            result.put(new GAV(artifact), file);
        }
        if (project.getArtifact().getFile() != null) {
            result.put(new GAV(project.getArtifact()), project.getArtifact().getFile());
        }
        return result;
    }

    public static Collection<File> collectFileFromDir(File dir) {
        Collection<File> result = new ArrayList<>();
        collectFileFromDir(dir, result);
        return result;
    }

    static void collectFileFromDir(File dir, Collection<File> result) {
        if (dir == null)
            return;
        File[] files = dir.listFiles();
        if (files == null)
            return;
        for (File file : files) {
            if (file.isDirectory())
                collectFileFromDir(file, result);
            if (file.isFile()) {
                result.add(file);
            }
        }
    }

    static Collection<File> getDependencySource(MavenProject project) {
        Set<File> result = new HashSet<>();
        for (Artifact jarA : project.getArtifacts()) {
            File jar = jarA.getFile();
            if (jar == null) continue;
            String path = jar.getPath();
            File source = new File(path.substring(0, path.length() - 4) + "-sources.jar");
            if (!source.exists()) continue;
            result.add(source);

        }
        return result;
    }

}
