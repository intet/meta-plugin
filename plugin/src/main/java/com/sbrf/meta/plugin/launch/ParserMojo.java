package com.sbrf.meta.plugin.launch;


import com.sbrf.meta.plugin.Parser;
import org.apache.maven.artifact.Artifact;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.*;
import org.apache.maven.project.MavenProject;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Mojo(name = "findApi", requiresDependencyResolution = ResolutionScope.COMPILE,
        defaultPhase = LifecyclePhase.PACKAGE, executionStrategy = "always")
@Execute(phase = LifecyclePhase.PACKAGE, goal = "findApi")
public class ParserMojo extends AbstractMojo {

    @Parameter(defaultValue = "${project}")
    private MavenProject project;

    @Parameter(defaultValue = "${project.build.sourceDirectory}")
    private String sourceDir;


    public void execute() throws MojoExecutionException {
        getLog().info("Start parse");
        Set<File> jars = getDependency();
        jars.add(getJar());
        Collection<File> source = new ArrayList<>();
        collectFileFromDir(new File(sourceDir), source);
        Parser.parse(jars, source);

    }

    public Set<File> getDependency() {
        Set<File> result = new HashSet<>();
        for (Artifact artifact : project.getArtifacts()) {
            result.add(artifact.getFile());
            getLog().info("jar " + artifact.getFile().getAbsolutePath());
        }
        return result;
    }
    public File getJar(){
        return project.getArtifact().getFile();
    }

    public void collectFileFromDir(File dir, Collection<File> result) {
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory())
                collectFileFromDir(file, result);
            if (file.isFile()) {
                result.add(file);
            }
        }
    }
}
