package com.sbrf.meta.plugin.launch;


import com.sbrf.meta.plugin.Parser;
import com.sbrf.meta.plugin.dto.api.ApiStorage;
import org.apache.maven.artifact.Artifact;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.*;
import org.apache.maven.project.MavenProject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Mojo(name = "findApi", requiresDependencyResolution = ResolutionScope.COMPILE,
        defaultPhase = LifecyclePhase.PACKAGE, executionStrategy = "always")
@Execute(phase = LifecyclePhase.PACKAGE, goal = "findApi")
public class ParserMojo extends AbstractMojo {

    @Parameter(defaultValue = "${project}")
    private MavenProject project;

    @Parameter(defaultValue = "${project.build.sourceDirectory}")
    private String sourceDir;

    @Parameter(defaultValue = "${project.build.directory}")
    private String directory;

    public void execute() {
        getLog().info("Start parse");
        Map<GAV, File> jars = getJars();
        Collection<File> source = new ArrayList<>();
        collectFileFromDir(new File(sourceDir), source);
        ApiStorage storage = Parser.parse(jars, source);
        saveToFile(storage.toJson().toString());

    }

    private Map<GAV, File> getJars() {
        Map<GAV, File> result = new HashMap<>();
        for (Artifact artifact : project.getArtifacts()) {
            File file = artifact.getFile();
            if (file == null)
                continue;
            result.put(new GAV(artifact), file);
            getLog().info("jar " + file.getAbsolutePath());
        }
        if (project.getArtifact().getFile() != null) {
            result.put(new GAV(project.getArtifact()), project.getArtifact().getFile());
        }
        return result;
    }
    private void collectFileFromDir(File dir, Collection<File> result) {
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

    private void saveToFile(String json) {
        try (FileWriter file = new FileWriter(directory + "/api.json")) {
            file.write(json);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
