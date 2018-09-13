package com.sbrf.meta.plugin;


import com.sbrf.meta.plugin.asm.AsmParser;
import org.apache.maven.artifact.Artifact;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.*;
import org.apache.maven.project.MavenProject;

import java.io.File;
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
        Set<File> files = getDependency();
        files.add(getJar());
        AsmParser parser = new AsmParser(files);
        parser.parse();
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

}
