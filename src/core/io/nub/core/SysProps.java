package io.nub.core;

/**
 * A static class that is navigable through the JavaDoc code assist. All of the values are based
 * on their representations in the String value of System.getProperty().<br><br>
 * System.getProperty("sun.arch.data.model") == Java2.SysProps.sun.arch.data.model()<br>
 * 
 * @author Nektro
 */
public class SysProps
{
	public static class java {
		public static String version() { return System.getProperty("java.version"); }
		public static String home() { return System.getProperty("java.home"); }
		public static String vendor() { return System.getProperty("java.vendor"); }
		public static class runtime {
			public static String name() { return System.getProperty("java.runtime.name"); }
			public static String version() { return System.getProperty("java.runtime.version"); }
		}
		public static class vm {
			public static String version() { return System.getProperty("java.vm.version"); }
			public static String vendor() { return System.getProperty("java.vm.vendor"); }
			public static String name() { return System.getProperty("java.vm.name"); }
			public static String specification() { return System.getProperty("java.vm.specification"); }
			public static String info() { return System.getProperty("java.vm.info"); }
			public static class specification {
				public static String vendor() { return System.getProperty("java.vm.specification.vendor"); }
				public static String version() { return System.getProperty("java.vm.specification.version"); }
			}
		}
		public static class vendor {
			public static String url() { return System.getProperty("java.vendor.url"); }
			
			public static class url {
				public static String bug() { return System.getProperty("java.vendor.url.bug"); }
			}
		}
		public static class awt {
			public static String graphicsenv() { return System.getProperty("java.awt.graphicsenv"); }
			public static String printerjob() { return System.getProperty("java.awt.printerjob"); }
		}
		public static class endorsed {
			public static String dirs() { return System.getProperty("java.endorsed.dirs"); }
		}
		public static class io {
			public static String tmpdir() { return System.getProperty("java.io.tmpdir"); }
		}
		public static class library {
			public static String path() { return System.getProperty("java.library.path"); }
		}
		public static class specification {
			public static String name() { return System.getProperty("java.specification.name"); }
			public static String version() { return System.getProperty("java.specification.version"); }
			public static String vendor() { return System.getProperty("java.specification.vendor"); }
		}
		public static class classs {
			public static String version() { return System.getProperty("java.class.version"); }
			public static String path() { return System.getProperty("java.class.path"); }
		}
		public static class ext {
			public static String dirs() { return System.getProperty("java.ext.dirs"); }
		}
	}
	public static class os {
		public static String name() { return System.getProperty("os.name"); }
		public static String arch() { return System.getProperty("os.arch"); }
		public static String version() { return System.getProperty("os.version"); }
	}
	public static class sun {
		public static class arch {
			public static class data {
				public static String model() { return System.getProperty("sun.arch.data.model"); }
			}
		}
		public static class boot {
			public static class library {
				public static String path() { return System.getProperty("sun.boot.library.path"); }
			}
			public static class classs {
				public static String path() { return System.getProperty("sun.boot.class.path"); }
			}
		}
		public static class java {
			public static String launcher() { return System.getProperty("sun.java.launcher"); }
			public static String command() { return System.getProperty("sun.java.command"); }
		}
		public static class os {
			public static class patch {
				public static String level() { return System.getProperty("sun.os.patch.level"); }
			}
		}
		public static class jnu {
			public static String encoding() { return System.getProperty("sun.jnu.encoding"); }
		}
		public static class management {
			public static String compiler() { return System.getProperty("sun.management.compiler"); }
		}
		public static class cpu {
			public static String endian() { return System.getProperty("sun.cpu.endian"); }
			public static String isalist() { return System.getProperty("sun.cpu.isalist"); }
		}
		public static class io {
			public static class unicode {
				public static String encoding() { return System.getProperty("sun.io.unicode.encoding"); }
			}
		}
		public static String desktop() { return System.getProperty("sun.desktop"); }
	}
	public static class user {
		public static String script() { return System.getProperty("user.script"); }
		public static String country() { return System.getProperty("user.country"); }
		public static String dir() { return System.getProperty("user.dir"); }
		public static String variant() { return System.getProperty("user.varient"); }
		public static String home() { return System.getProperty("user.home"); }
		public static String timezone() { return System.getProperty("user.timezone"); }
		public static String name() { return System.getProperty("user.name"); }
		public static String language() { return System.getProperty("user.language"); }
	}
	public static class path {
		public static String separator() { return System.getProperty("path.separator"); }
	}
	public static class file {
		public static String encoding() { return System.getProperty("file.encoding"); }
		public static String separator() { return System.getProperty("file.separator"); }
		public static class encoding {
			public static String pkg() { return System.getProperty("file.encoding.pkg"); }
		}
	}
	public static class line {
		public static String separator() { return System.getProperty("line.separator"); }
	}
	public static class awt {
		public static String toolkit() { return System.getProperty("awt.toolkit"); }
	}
	public static class java2 {
		public static final float version = 1.0F;
		public static final String author = "Nektro";
	}
}
