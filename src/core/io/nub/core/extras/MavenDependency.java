package io.nub.core.extras;

import java.net.MalformedURLException;
import java.net.URL;

import io.nub.core.file.File2;

/**
 * Encapsulation of Maven based dependency downloader as a helper for launchers and scripts of all types.<br>
 * 
 * @author Nektro
 */
public class MavenDependency
{
	public enum MavenDependencyFile
	{
		POM     (".pom"),
		JAR     (".jar"),
		JAVADOC ("-javadoc.jar"),
		SOURCES ("-sources.jar");
		
		public String ext;
		private MavenDependencyFile(String s) { this.ext = s; }
	}
	
	public static final String REPO_MAVEN_CENTRAL_REPO1   = "https://repo1.maven.org/maven2/";
	public static final String REPO_MAVEN_CENTRAL_CENTRAL = "http://central.maven.org/maven2/";
	
	private String url;
	private String group;
	private String artifact;
	private String version;
	
	public MavenDependency(String mavenSite, String groupId, String artifactId, String version)
	{
		this.url = mavenSite;
		this.group = groupId;
		this.artifact = artifactId;
		this.version = version;
	}
	
	public URL getDowloadLink(MavenDependencyFile file)
	{
		try {
			return new URL(url + (url.lastIndexOf('/') == url.length()-1 ? "" : "/") + group.replace('.', '/') + '/' + artifact + '/' + version + '/' + artifact + '-' + version + file.ext);
		}
		catch (MalformedURLException e) {
			return null;
		}
	}
	
	public boolean download(File2 toDir, MavenDependencyFile file)
	{
		return Download.to(getDowloadLink(file), toDir, true, false);
	}
	
	@Override
	public String toString() {
		return "'" + group + ":" + artifact + ":" + version + "'";
	}
}
