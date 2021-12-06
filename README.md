# Android-Simple-SeekBar

#Grdle
    ##Step 1
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

    ##Step 2
    dependencies {
            implementation 'com.github.cheonjoosung:Android-Simple-SeekBar:Tag'
    }

#mavn
    ##Step.1
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>

    ##Step.2
	<dependency>
	    <groupId>com.github.cheonjoosung</groupId>
	    <artifactId>Android-Simple-SeekBar</artifactId>
	    <version>Tag</version>
	</dependency>
	
#sbt
   resolvers += "jitpack" at "https://jitpack.io"
   libraryDependencies += "com.github.cheonjoosung" % "Android-Simple-SeekBar" % "Tag"	

#leiningen
    :repositories [["jitpack" "https://jitpack.io"]]
    dependencies [[com.github.cheonjoosung/Android-Simple-SeekBar "Tag"]]	